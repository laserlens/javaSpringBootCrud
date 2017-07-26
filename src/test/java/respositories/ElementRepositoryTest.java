package respositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



/**
 * Created by Adrian.Flak on 6/28/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement () {
        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element and verify it has id after save
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        Element fetchElement = elementRepository.findOne(element.getId());

        //test fetch
        assertNotNull(fetchElement);
        assertEquals(element.getId(),fetchElement.getId());

        //test update
        fetchElement.setElementName("Email");
        elementRepository.save(fetchElement);

        Element updatedElement = elementRepository.findOne(fetchElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");

        elementRepository.deleteAll();


    }

    @Test
    public void testSaveElementList(){

        elementRepository.deleteAll();
        assertFalse(elementRepository.findAll().iterator().hasNext());

        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Email"));
        elementList.add((new Element("Phone")));
        elementList.add((new Element("PayRate")));
        elementList.add((new Element("Labtop")));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementalList = elementRepository.findAll();

        int count = 0;

        for(Element element: fetchedElementalList){
            count++;
        }

        assertEquals(4,count);
        assertEquals(4,fetchedElementalList.spliterator().getExactSizeIfKnown());

        elementRepository.deleteAll();

    }

    @Test
    public void testFindByElementName(){

        Element findMeElement = new Element("Find Me");
        elementRepository.save(findMeElement);

        Element foundByNameElement = elementRepository.findByElementName("Find Me");

        assertEquals("Find Me", foundByNameElement.getElementName());
        assertEquals(findMeElement.getId(),foundByNameElement.getId());

        elementRepository.deleteAll();


    }

    @Test
    public void testFindAllByElementName(){

        List<Element> findUsElement = new ArrayList<>();
        findUsElement.add(new Element("Find Us"));
        findUsElement.add(new Element("Find Us"));

        elementRepository.save(findUsElement);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("Find Us");

        assertEquals("Find Us",foundAllByNameElement.iterator().next().getElementName());
        assertEquals(findUsElement.iterator().next().getId(),foundAllByNameElement.iterator().next().getId());
        assertEquals(2,foundAllByNameElement.size());

        elementRepository.deleteAll();

    }

    @Test
    public void testFindAllTop3(){

        List<Element> topThreeElements = new ArrayList<>();
        topThreeElements.add(new Element("same"));
        topThreeElements.add(new Element("same"));
        topThreeElements.add(new Element("same"));
        topThreeElements.add(new Element("same"));

        elementRepository.save(topThreeElements);

        List<Element> top3Elements = elementRepository.findTop3ByElementName("same");

        assertEquals(3,top3Elements.size());
        assertEquals("same",top3Elements.iterator().next().getElementName());

        elementRepository.deleteAll();

    }

    @Test
    public void testFindByElementNameOrderById(){

        List<Element> elementListOrderId = new ArrayList<>();
        elementListOrderId.add(new Element("orderId"));
        elementListOrderId.add(new Element("orderId"));
        elementListOrderId.add(new Element("orderId"));
        elementListOrderId.add(new Element("orderId"));

        elementRepository.save(elementListOrderId);

        List<Element> orderedByIdElementList = elementRepository.findByElementNameOrderById("orderId");

        assertEquals(elementListOrderId.get(0).getId(),orderedByIdElementList.get(0).getId());
        assertEquals(elementListOrderId.get(2).getId(),orderedByIdElementList.get(2).getId());
        assertEquals(4,orderedByIdElementList.size());

        elementRepository.deleteAll();



    }

    @Test
    public void testFindByElementNameOrderByIdDesc(){

        List<Element> elementListOrderMe = new ArrayList<>();
        elementListOrderMe.add(new Element("orderMe"));
        elementListOrderMe.add(new Element("orderMe"));
        elementListOrderMe.add(new Element("orderMe"));
        elementListOrderMe.add(new Element("orderMe"));

        elementRepository.save(elementListOrderMe);

        List<Element> orderedByIdElementListDesc = elementRepository.findByElementNameOrderByIdDesc("orderMe");

        assertEquals(elementListOrderMe.get(0).getId(),orderedByIdElementListDesc.get(3).getId());
        assertEquals(elementListOrderMe.get(1).getId(),orderedByIdElementListDesc.get(2).getId());
        assertEquals(4,orderedByIdElementListDesc.size());

        elementRepository.deleteAll();

    }

    @Test
    public void testFindAllReturnAsList(){

        List<Element> anElementList = new ArrayList<>();
        anElementList.add(new Element("one"));
        anElementList.add(new Element("two"));
        anElementList.add(new Element("three"));
        anElementList.add(new Element("four"));

        elementRepository.save(anElementList);


        List<Element> elementListNotIterable = elementRepository.findAll();

        assertTrue(elementListNotIterable instanceof List<?>);
        assertFalse(elementListNotIterable.isEmpty());
        assertEquals(anElementList.size(),elementListNotIterable.size());

        elementRepository.deleteAll();

    }

    @Test
    public void testFirstByElementName(){

        List<Element> elementListSameName = new ArrayList<>();
        elementListSameName.add(new Element("SameName"));
        elementListSameName.add(new Element("SameName"));
        elementListSameName.add(new Element("SameName"));
        elementListSameName.add(new Element("SameName"));

        elementRepository.save(elementListSameName);

        Element fistByElementName = elementRepository.findFirstByElementName("SameName");

        assertNotNull(fistByElementName);
        assertEquals("SameName",fistByElementName.getElementName());
        assertEquals(elementListSameName.get(0).getId(),fistByElementName.getId());
        assertNotEquals(elementListSameName.get(1).getId(),fistByElementName.getId());

        elementRepository.deleteAll();

    }

}
