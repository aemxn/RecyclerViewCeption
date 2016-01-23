package com.aimanbaharum.recyclerviewception.model;

import java.util.ArrayList;

/**
 * Created by cliqers on 23/1/2016.
 */
public class ParentChild {
    String header;
    ArrayList<Child> child;

    public ParentChild() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList<Child> getChild() {
        return child;
    }

    public void setChild(ArrayList<Child> child) {
        this.child = child;
    }
}
