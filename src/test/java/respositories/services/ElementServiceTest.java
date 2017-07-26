package respositories.services;

import com.astontech.hr.application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adrian.Flak on 6/29/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {application.class})
@WebAppConfiguration
public class ElementServiceTest {

    private Element element;
    private List<Element> elementList;


    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementRepository elementRepository;


    @Before
    public void setUp() {

        element = new Element("SingleElement");

        elementList = new ArrayList<>();
        elementList.add(new Element("ListOfElements"));
        elementList.add(new Element("ListOfElements"));
        elementList.add(new Element("ListOfElements"));
        elementList.add(new Element("ListOfElements"));

    }

    @After
    public void tearDown(){
        elementRepository.deleteAll();
    }

    @Test
    public void should_save() {

        //save element and verify it has id after save
        assertNull(element.getId());
        elementService.saveElement(element);
        assertNotNull(element.getId());

    }

    @Test
    public void should_saveList() {

        //save element list and verify element with index zero has id after save
        assertNull(elementList.get(0).getId());
        elementService.saveElementList(elementList);
        assertNotNull(elementList.get(0).getId());

    }

    @Test
    public void should_findAllByElementName() {
        elementService.saveElementList(elementList);

        List<Element> testList = elementService.findAllByElementName("ListOfElements");
        List<Element> list = elementRepository.findAll();
        assertEquals(4,testList.size());
        assertEquals(4,list.size());

    }



}