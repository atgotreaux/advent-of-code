package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void exampleOne() throws Exception {
        URL resource = Day1Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day1part1.txt");

        Path path = Path.of(resource.toURI());

        Day1 day1 = new Day1();

        assertEquals(day1.calibrationValue(path), 142);
    }

    @Test
    void exampleTwo() throws Exception {
        URL resource = Day1Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day1part2.txt");

        Path path = Path.of(resource.toURI());

        Day1 day1 = new Day1();

        assertEquals(day1.calibrationValue(path), 281);
    }
}