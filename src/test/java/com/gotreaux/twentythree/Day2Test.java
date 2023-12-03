package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void exampleOne() throws Exception {
        URL resource = Day1Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day2.txt");

        Path path = Path.of(resource.toURI());

        Day2 day2 = new Day2();

        assertEquals(8, day2.possibleGames(path));
    }

    @Test
    void exampleTwo() throws Exception {
        URL resource = Day1Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day2.txt");

        Path path = Path.of(resource.toURI());

        Day2 day2 = new Day2();

        assertEquals(2286, day2.powerOfFewestCubes(path));
    }
}