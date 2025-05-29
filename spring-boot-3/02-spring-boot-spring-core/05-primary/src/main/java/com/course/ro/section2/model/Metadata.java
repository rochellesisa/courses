package com.course.ro.section2.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class Metadata {

    private JsonObject data;
    private String type;

    public Metadata(String json, String type) {
        this.data = JsonParser.parseString(json).getAsJsonObject();
        this.type = type;
    }

}
