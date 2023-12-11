package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {
    @Test
    void exampleOne() throws Exception {
        URL resource = Day5Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day5.txt");

        Path path = Path.of(resource.toURI());

        Day5 day5 = new Day5(path);

        assertEquals(35, day5.lowestLocationNumber());
    }

    @Test
    void exampleTwo() throws Exception {
        URL resource = Day5Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day5.txt");

        Path path = Path.of(resource.toURI());

        Day5 day5 = new Day5(path);

        assertEquals(46, day5.lowestLocationNumberInRange());
    }
}