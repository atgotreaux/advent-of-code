package com.gotreaux.aoc.input.reader;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public record StringInputReader(String inputString) implements InputReader {

    @Override
    public String getInputString() {
        return inputString;
    }

    @Override
    public Stream<String> getInputStream() {
        return Stream.of(inputString);
    }

    @Override
    public List<String> getInputList() {
        return Collections.singletonList(inputString);
    }
}
