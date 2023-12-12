package com.gotreaux.twentythree;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {
    @Test
    void exampleOne() throws Exception {
        URL resource = Day7Test.class.getClassLoader().getResource("com/gotreaux/twentythree/day7.txt");

        Path path = Path.of(resource.toURI());

        Day7 day7 = new Day7(path);

        assertEquals(6440, day7.getWinnings());
    }
}