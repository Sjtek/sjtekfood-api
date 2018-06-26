package nl.sjtek.food.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wouter on 13-11-16.
 */
public class Tag {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
