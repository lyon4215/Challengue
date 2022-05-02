package com.RM.Challengue.model;

import lombok.Data;

@Data
public class LocationSchema {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private String[] residents;
    private String url;


}
