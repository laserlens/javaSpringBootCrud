package com.astontech.hr.services;


import com.astontech.hr.domain.ElementType;

import java.util.List;

/**
 * Created by Adrian.Flak on 6/30/2017.
 */
public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes ();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeList);

    void deleteElementTypeById(Integer id);

    //custom repository
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName);

}
