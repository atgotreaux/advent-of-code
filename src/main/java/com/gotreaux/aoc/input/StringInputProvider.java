package com.gotreaux.aoc.input;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StringInputProvider implements InputProvider {

    private final String input;

    public StringInputProvider(String input) {
        this.input = input;
    }

    @Override
    public String getInputString() {
        return input;
    }

    @Override
    public Stream<String> getInputStream() {
        return Stream.of(input);
    }

    @Override
    public List<String> getInputList() {
        return Collections.singletonList(input);
    }
}
