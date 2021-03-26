package se.stridsberg.lenaszoo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Animal {

    private UUID id;
    private String type;
    private String name;

    // TODO Undersök @JsonProperty - bara för att skriva till java eller också tvärtom?
    public Animal(@JsonProperty("id") UUID id,
                  @JsonProperty("type") String type,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
