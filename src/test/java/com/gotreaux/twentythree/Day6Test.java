package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {
    @Test
    void exampleOne() throws Exception {
        URL resource = Day6Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day6.txt");

        Path path = Path.of(resource.toURI());

        Day6 day6 = new Day6(path);

        assertEquals(288, day6.getWinningRaces());
    }

    @Test
    void exampleTwo() throws Exception {
        URL resource = Day6Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day6.txt");

        Path path = Path.of(resource.toURI());

        Day6 day6 = new Day6(path);

        assertEquals(71503, day6.getWinningRacesWithKerning());
    }
}