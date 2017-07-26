package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;

import com.astontech.hr.services.impl.ElementTypeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;


/**
 * Created by Adrian.Flak on 6/30/2017.
 */
@Controller
public class ElementController {

    private Integer number = 0;

    @Autowired
    private ElementTypeServiceImpl elementTypeService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {

        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("aClick", number);

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO,Model model) {
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromElementVO(elementVO);
        model.addAttribute("aClick", number+=1);

        return "redirect:add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model){
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());

        number = 0;

        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String adminElementTypeDelete(@PathVariable int id) {

        elementTypeService.deleteElementTypeById(id);


        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String adminElementTypeEdit(@PathVariable int id,Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);


        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String adminElementTypeUpdate(ElementType elementType,
                                         @RequestParam("inputNewElement") String newElement  ) {

       //check for value
        if (!newElement.equals("")){
            if (elementType.getElementList()==null){
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            }else {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        for (int n=0; n<elementType.getElementList().size();n++){
            //check to see if element is name is blanck
            if (elementType.getElementList().get(n).getElementName().equals("")){
                elementType.getElementList().remove(n);
            }

        }

        elementTypeService.saveElementType(elementType);
        return "redirect:/admin/element/edit/" + elementType.getId();
    }




    //region Helper Methods

    private void logElementVO(ElementVO elementVO){
        log.info("New Element Type: " + elementVO.getNewElementType());
        log.info("New Element: " + elementVO.getNewElements());
    }

    private void saveElementTypeAndElementsFromElementVO(ElementVO elementVO){
        List<Element> newElements = new ArrayList<>();

        for (String element:elementVO.getNewElementArray()){
            if (!element.equals(""))
                newElements.add(new Element(element));
        }

        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElements);

        elementTypeService.saveElementType(newElementType);


    }

    //endregion

}
