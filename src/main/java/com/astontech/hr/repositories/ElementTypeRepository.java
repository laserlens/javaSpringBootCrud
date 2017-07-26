package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Adrian.Flak on 6/28/2017.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType,Integer> {

    //custom repository
    ElementType findByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName);

}
