package com.gotreaux.aoc.input.writer;

import java.io.IOException;
import java.net.URISyntaxException;

@FunctionalInterface
public interface InputWriter {
    void write(String input) throws IOException, URISyntaxException;
}
