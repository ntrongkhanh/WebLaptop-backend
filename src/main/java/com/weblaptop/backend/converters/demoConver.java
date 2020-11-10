package com.weblaptop.backend.converters;

import com.weblaptop.backend.models.dtos.DemoDTO;
import com.weblaptop.backend.models.entities.DemoEntity;
import org.springframework.stereotype.Component;

@Component
public class demoConver {
    public DemoEntity toEntity(DemoDTO dto){
        DemoEntity entity = new DemoEntity();

        return entity;
    }
}
