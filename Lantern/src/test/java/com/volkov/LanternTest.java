package com.volkov;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;

public class LanternTest {
    Lantern lantern1;
    @Before
    public void setUp() {
        lantern1 = new Lantern("BigBen", 3,3, "red");
    }
    @Test
    public void batteryCheck() {
        assertThat (lantern1.batteryInside, is(3));
    }
    @Test
    public void capacityCheck() {
        assertThat (lantern1.batteryCapacity, is(3));
    }
    @Test
    public void nameCheck() {
        assertThat (lantern1.name,  equalToIgnoringWhiteSpace("BigBen"));
    }
    @Test
    public void colorCheck() {
        assertThat (lantern1.color,  equalToIgnoringWhiteSpace("red"));
    }
    @Test
    public void featureCheckNoFeature() {
        assertThat (lantern1.feature,  equalToIgnoringWhiteSpace("No extra feature"));
    }
    @Test
    public void featureCheckHaveFeature() {
        Lantern lantern1 = new Lantern("BigBen", 3,3, "red","flashing");
        assertThat (lantern1.feature,  equalToIgnoringWhiteSpace("flashing"));
    }
}
