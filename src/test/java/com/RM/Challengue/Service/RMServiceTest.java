package com.RM.Challengue.Service;

import com.RM.Challengue.dto.OriginObjectSchema;
import com.RM.Challengue.dto.RootObjectSchema;
import com.RM.Challengue.model.CharacterSchema;
import com.RM.Challengue.model.Location;
import com.RM.Challengue.model.LocationSchema;
import com.RM.Challengue.model.Origin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RMServiceTest {

    @Mock
    RMService rMService;

    @Autowired
    LocationSchema locationSchema;

    @Autowired
    CharacterSchema characterSchema;

    @Autowired
    RootObjectSchema dto;

    @Autowired
    RestTemplate restTemplate;

    int id=1;

    String resultCharacter = "https://rickandmortyapi.com/api/character/1";

    String resultLocation = "https://rickandmortyapi.com/api/location/3";

    @BeforeEach
    void setUp() {


    }

    @Test
    void rMService() {
        rMService = new RMService();
        restTemplate = new RestTemplate();

        CharacterSchema characterSchema = new CharacterSchema();
        characterSchema.setId(1);
        characterSchema.setName("Rick Sanchez");
        characterSchema.setStatus("Alive");
        characterSchema.setSpecies("Human");
        characterSchema.setType("");
        characterSchema.setGender("Male");
        characterSchema.setOrigin(new Origin());
        characterSchema.getOrigin().setName("Earth (C-137)");
        characterSchema.getOrigin().setUrl("https://rickandmortyapi.com/api/location/1");
        characterSchema.setLocation(new Location());
        characterSchema.getLocation().setName("Citadel of Ricks");
        characterSchema.getLocation().setUrl("https://rickandmortyapi.com/api/location/3");
        characterSchema.setImage("https://rickandmortyapi.com/api/character/avatar/1.jpeg");
        characterSchema.setEpisode(new String[]{""});
        characterSchema.setUrl("https://rickandmortyapi.com/api/location/1");
        LocationSchema locationSchema = new LocationSchema();
        locationSchema.setId(id);
        locationSchema.setName("");
        locationSchema.setType("");
        locationSchema.setDimension("");
        locationSchema.setUrl("");
        locationSchema.setResidents(new String[]{""});
        rMService.rMService(id);
        RootObjectSchema dto = new RootObjectSchema();
        dto.setId(characterSchema.getId());
        dto.setName(characterSchema.getName());
        dto.setStatus(characterSchema.getStatus());
        dto.setSpecies(characterSchema.getSpecies());
        dto.setType(characterSchema.getType());
        dto.setEpisode_count(characterSchema.getEpisode().length);
        dto.setOrigin(new OriginObjectSchema());
        dto.getOrigin().setName(locationSchema.getName());
        dto.getOrigin().setUrl(locationSchema.getUrl());
        dto.getOrigin().setDimension(locationSchema.getDimension());
        dto.getOrigin().setResidents(locationSchema.getResidents());
        Assertions.assertEquals(1,dto.getId());
        Assertions.assertEquals("Rick Sanchez",dto.getName());
        Assertions.assertEquals("Alive",dto.getStatus());
        Assertions.assertEquals("Human",dto.getSpecies());
        Assertions.assertEquals("",dto.getType());
        Assertions.assertEquals("Male",characterSchema.getGender());
        Assertions.assertEquals("https://rickandmortyapi.com/api/character/avatar/1.jpeg",characterSchema.getImage());
        Assertions.assertEquals("Citadel of Ricks",characterSchema.getLocation().getName());
        Assertions.assertEquals("https://rickandmortyapi.com/api/location/3",characterSchema.getLocation().getUrl());
        Assertions.assertEquals("https://rickandmortyapi.com/api/location/1",characterSchema.getUrl());
        Assertions.assertEquals(1,dto.getEpisode_count());
        Assertions.assertEquals("Earth (C-137)",characterSchema.getOrigin().getName());
        Assertions.assertEquals("",dto.getOrigin().getUrl());
        Assertions.assertEquals("",dto.getOrigin().getDimension());

    }

    @Test
    void originEmpty() {
        rMService = new RMService();
        LocationSchema locationSchema = new LocationSchema();
        locationSchema.setId(1);
        locationSchema.setName("Citadel of Ricks");
        locationSchema.setType("");
        locationSchema.setDimension("Dimension C-137");
        locationSchema.setUrl("https://rickandmortyapi.com/api/location/3");
        locationSchema.setResidents(new String[]{"https://rickandmortyapi.com/api/character/38"});
        rMService.originEmpty();
        Assertions.assertEquals(1,locationSchema.getId());
        Assertions.assertEquals("",locationSchema.getType());
        Assertions.assertEquals("Citadel of Ricks",locationSchema.getName());
        Assertions.assertEquals("Dimension C-137",locationSchema.getDimension());
        Assertions.assertEquals("https://rickandmortyapi.com/api/location/3",locationSchema.getUrl());
    }

    @Test
    void buildingSchema() {
        rMService = new RMService();
        CharacterSchema characterSchema = new CharacterSchema();
        characterSchema.setId(1);
        characterSchema.setName("Rick Sanchez");
        characterSchema.setStatus("Alive");
        characterSchema.setSpecies("Human");
        characterSchema.setType("");
        characterSchema.setGender("Male");
        characterSchema.setOrigin(new Origin());
        characterSchema.getOrigin().setName("Earth (C-137)");
        characterSchema.getOrigin().setUrl("https://rickandmortyapi.com/api/location/1");
        characterSchema.setLocation(new Location());
        characterSchema.getLocation().setName("Citadel of Ricks");
        characterSchema.getLocation().setUrl("https://rickandmortyapi.com/api/location/3");
        characterSchema.setImage("https://rickandmortyapi.com/api/character/avatar/1.jpeg");
        characterSchema.setEpisode(new String[]{""});
        characterSchema.setUrl("https://rickandmortyapi.com/api/location/1");
        LocationSchema locationSchema = new LocationSchema();
        locationSchema.setId(1);
        locationSchema.setName("Citadel of Ricks");
        locationSchema.setType("");
        locationSchema.setDimension("Dimension C-137");
        locationSchema.setUrl("https://rickandmortyapi.com/api/location/3");
        locationSchema.setResidents(new String[]{"https://rickandmortyapi.com/api/character/38"});

        RootObjectSchema dto = new RootObjectSchema();
        dto.setId(characterSchema.getId());
        dto.setName(characterSchema.getName());
        dto.setStatus(characterSchema.getStatus());
        dto.setSpecies(characterSchema.getSpecies());
        dto.setType(characterSchema.getType());
        dto.setEpisode_count(characterSchema.getEpisode().length);
        dto.setOrigin(new OriginObjectSchema());
        dto.getOrigin().setName(locationSchema.getName());
        dto.getOrigin().setUrl(locationSchema.getUrl());
        dto.getOrigin().setDimension(locationSchema.getDimension());
        dto.getOrigin().setResidents(locationSchema.getResidents());

        rMService.buildingSchema(characterSchema, locationSchema);
        Assertions.assertEquals(1,dto.getId());
        Assertions.assertEquals("Rick Sanchez",dto.getName());
        Assertions.assertEquals("Alive",dto.getStatus());
        Assertions.assertEquals("Human",dto.getSpecies());
        Assertions.assertEquals("",dto.getType());
        Assertions.assertEquals(1,dto.getEpisode_count());
        Assertions.assertEquals("Citadel of Ricks",dto.getOrigin().getName());
        Assertions.assertEquals("https://rickandmortyapi.com/api/location/3",dto.getOrigin().getUrl());
        Assertions.assertEquals("Dimension C-137",dto.getOrigin().getDimension());
    }
}