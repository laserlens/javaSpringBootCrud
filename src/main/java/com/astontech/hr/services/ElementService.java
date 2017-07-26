package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Adrian.Flak on 6/29/2017.
 */
public interface ElementService {

    Iterable<Element> listAllElements ();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementList);

    void deleteElementById(Integer id);

    //custom repository
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);







}
