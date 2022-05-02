package com.RM.Challengue.Controller;

import com.RM.Challengue.Service.RMService;
import com.RM.Challengue.dto.OriginObjectSchema;
import com.RM.Challengue.dto.RootObjectSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RMControllerTest {

    @Autowired
    RMController rmController;

    @Autowired
    RMService rMService;

    @Autowired
    RootObjectSchema dto;

    int id =1;

    @BeforeEach
    void setUp() {

    }

    @Test
    void rMapi() {
        rMService = new RMService();
        dto = new RootObjectSchema();
        dto.setId(id);
        dto.setName("Rick Sanchez");
        dto.setStatus("characterSchema.getStatus()");
        dto.setSpecies("");
        dto.setType("");
        dto.setEpisode_count(4);
        dto.setOrigin(new OriginObjectSchema());
        dto.getOrigin().setName("");
        dto.getOrigin().setUrl("");
        dto.getOrigin().setDimension("");
        dto.getOrigin().setResidents(new String[]{""});
        rMService.rMService(1);

        Assertions.assertEquals(dto.getName(),rMService.rMService(1).getName());
    }
}