package com.gotreaux.aoc.input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

public interface InputProvider {
    String getInputString() throws IOException, URISyntaxException;

    Stream<String> getInputStream() throws IOException, URISyntaxException;

    List<String> getInputList() throws IOException, URISyntaxException;
}
