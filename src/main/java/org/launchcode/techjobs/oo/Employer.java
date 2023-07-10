package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer {

    private int id;
    private static int nextId = 1;
    //static can be used by referencing the class name without creating an object.
    private String value;

    public Employer() {
        id = nextId;
        nextId++;
    }

    public Employer(String value) {
        this();
        //this() is used to call a constructor within the same class.
        //doing so makes initializing id a default behavior
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
