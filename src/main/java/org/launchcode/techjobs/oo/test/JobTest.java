package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


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


}
