package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {
    @Test
    void exampleOne() throws Exception {
        URL resource = Day3Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day3.txt");

        Path path = Path.of(resource.toURI());

        Day3 day3 = new Day3();

        assertEquals(4361, day3.sumOfParts(path));
    }

    @Test
    void exampleTwo() throws Exception {
        URL resource = Day3Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day3.txt");

        Path path = Path.of(resource.toURI());

        Day3 day3 = new Day3();

        assertEquals(467835, day3.sumOfGearRatios(path));
    }
}