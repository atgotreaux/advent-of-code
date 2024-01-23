package com.gotreaux.aoc.input;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public record StringInputProvider(String inputString) implements InputProvider {

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
