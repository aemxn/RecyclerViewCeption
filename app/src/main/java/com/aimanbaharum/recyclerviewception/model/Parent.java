package com.aimanbaharum.recyclerviewception.model;

/**
 * Created by cliqers on 23/1/2016.
 */
public class Parent {

    String parent_header;

    public Parent() {
    }

    public String getParent_header() {
        return parent_header;
    }

    public void setParent_header(String parent_header) {
        this.parent_header = parent_header;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parent_header='" + parent_header + '\'' +
                '}';
    }
}
