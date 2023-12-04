package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
    @Test
    void exampleOne() throws Exception {
        URL resource = Day1Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day4.txt");

        Path path = Path.of(resource.toURI());

        Day4 day4 = new Day4();

        assertEquals(13, day4.scratchcardPoints(path));
    }
}