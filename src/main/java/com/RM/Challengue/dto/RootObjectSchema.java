package com.RM.Challengue.dto;

import lombok.Data;

@Data
public class RootObjectSchema {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episode_count;
    private OriginObjectSchema origin;


}
