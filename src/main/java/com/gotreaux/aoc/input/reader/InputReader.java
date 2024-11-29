package com.gotreaux.aoc.input.reader;

import java.util.List;
import java.util.stream.Stream;

public interface InputReader {
    String getInputString() throws Exception;

    Stream<String> getInputStream() throws Exception;

    List<String> getInputList() throws Exception;
}
