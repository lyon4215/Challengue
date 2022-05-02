package com.RM.Challengue.Service;

import com.RM.Challengue.dto.OriginObjectSchema;
import com.RM.Challengue.dto.RootObjectSchema;
import com.RM.Challengue.model.CharacterSchema;
import com.RM.Challengue.model.LocationSchema;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class RMService {
    private static Logger LOGGER = Logger.getLogger(RMService.class.getName());
    private static final String URL= "https://rickandmortyapi.com/api/character/";
    private static final String VACIO = "";

    public RootObjectSchema rMService(int id) {

        RestTemplate restTemplate = new RestTemplate();

        CharacterSchema resultCharacter = restTemplate.getForObject(URL + id,CharacterSchema.class);


        if(resultCharacter.getOrigin().getUrl().equals("")){
            return buildingSchema(resultCharacter,originEmpty());
        }else{
            LocationSchema resultLocation =
                    restTemplate.getForObject(resultCharacter.getOrigin().getUrl(),LocationSchema.class);
            return buildingSchema(resultCharacter,resultLocation);
        }

    }

    public LocationSchema originEmpty(){

        LocationSchema locationSchema = new LocationSchema();
        locationSchema.setName(VACIO);
        locationSchema.setDimension(VACIO);
        locationSchema.setUrl(VACIO);
        locationSchema.setResidents(new String[]{VACIO});

        return locationSchema;
    }

    public RootObjectSchema buildingSchema(CharacterSchema characterSchema, LocationSchema locationSchema){

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

        return dto;
    }


}
