package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Adrian.Flak on 6/28/2017.
 */
public interface ElementRepository extends CrudRepository<Element,Integer> {

    //this will auto generate the code
    Element findByElementName(String elementName);
    List<Element> findAllByElementName(String elementName);
    List<Element> findAllByElementNameIgnoreCase(String elementName);

    //five custom querrys
    List<Element> findTop3ByElementName(String elementName);
    List<Element> findByElementNameOrderById(String elementName);
    List<Element> findByElementNameOrderByIdDesc(String elementName);
    List<Element> findAll();
    Element findFirstByElementName(String elementName);




}
