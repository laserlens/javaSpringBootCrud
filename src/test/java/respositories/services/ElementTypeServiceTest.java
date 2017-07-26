package respositories.services;


import com.astontech.hr.application;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.impl.ElementTypeServiceImpl;
import com.astontech.hr.domain.ElementType;

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
import static org.junit.Assert.fail;

/**
 * Created by Adrian.Flak on 6/30/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {application.class})
@WebAppConfiguration
public class ElementTypeServiceTest {

    private ElementType elementType;
    private List<ElementType> elementTypeList;

    @Autowired
    private ElementTypeServiceImpl elementTypeService;

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Before
    public void setUp() {
        elementType = new ElementType("SingleElementType");
        elementTypeList = new ArrayList<>();
        elementTypeList.add(new ElementType("SameElementType"));
        elementTypeList.add(new ElementType("SameElementType"));
        elementTypeList.add(new ElementType("SameElementType"));
        elementTypeList.add(new ElementType("SameElementType"));
    }

    @After
    public void TearDown(){
        elementTypeRepository.deleteAll();
    }

    @Test
    public void should_saveElementType() {
        assertNull(elementType.getId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getId());
    }

    @Test
    public void should_saveElementTypeList() {
        assertNull(elementTypeList.get(0).getId());
        elementTypeService.saveElementTypeList(elementTypeList);
        assertNotNull(elementTypeList.get(0).getId());
    }

    @Test
    public void should_findElementTypeByElementTypeName() {
        elementTypeService.saveElementType(elementType);
        ElementType foundOne = elementTypeService.findByElementTypeName("SingleElementType");
        assertEquals("SingleElementType",foundOne.getElementTypeName());
    }

    @Test
    public void should_findAllByElementTypeNameIgnoreCase() {
        elementTypeService.saveElementTypeList(elementTypeList);
        List<ElementType> foundMany = elementTypeService.findAllByElementTypeNameIgnoreCase("sameEleMENttype");
        assertEquals(4,foundMany.size());
    }


}