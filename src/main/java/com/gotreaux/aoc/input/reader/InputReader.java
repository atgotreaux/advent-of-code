package com.gotreaux.aoc.input.reader;

import java.util.List;
import java.util.stream.Stream;

public interface InputReader {
    String getInputString();

    Stream<String> getInputStream();

    List<String> getInputList();
}
