package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job test = new Job();
        Job testTwo = new Job();
        assertNotEquals(test, testTwo);

    }


    //testing the constructor correctly assigns both the class and value of each field.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test.getName() instanceof String);
        assertEquals(test.getName(), "Product tester");

        assertTrue(test.getEmployer() instanceof Employer);
        assertEquals(test.getEmployer().getValue(), "ACME");

        assertTrue(test.getLocation() instanceof Location);
        assertEquals(test.getLocation().getValue(), "Desert");

        assertTrue(test.getPositionType() instanceof PositionType);
        assertEquals(test.getPositionType().getValue(), "Quality control");

        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(test.getCoreCompetency().getValue(), "Persistence");


    }

    //two Job objects are considered equal if they have the same id value.
    //even if one or more of the other fields differ.
    // not equal if id does not match no matter if other fields are identical

    @Test
    public void testJobsForEquality() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job testTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
assertFalse(test.equals(testTwo));

//using assertFalse and .equals to make sure the ids of both objects are not identical
// since id needs to be different each time a new object is created.
//id field gets assigned a unique value and the class does not contain a setId method so it cannot be changed.

    }


    //using Test-Driven Development to build toString method
    // when passed a Job object, it should return a string that contains a blank line before
    // and after the job information
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(test.toString().charAt(0), '\n');
        assertEquals(test.toString().charAt(test.toString().length() - 1), '\n');


    }


    //the string contains a label for each field, followed by the data stored in that field.
    //each field should have its own line
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

assertEquals(test.toString(), "ID: " + test.getId() + '\n' +
        "Name: " + test.getName() + '\n' +
        "Employer: " + test.getEmployer() + '\n' +
        "Location: " + test.getLocation() + "\n" +
        "Position Type: " + test.getPositionType() + '\n' +
        "Core Competency: " + test.getCoreCompetency() + '\n');
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        assertEquals(test.toString(), "\nID: " + test.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence\n"
        );
    }


    @Test
    public void testToStringOnlyContainingIdField() {
        Job test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
assertEquals(test.toString(), "OOPS! This job does not seem to exist");

    }
}

