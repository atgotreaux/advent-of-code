package com.gotreaux.aoc.input;

import java.util.List;
import java.util.stream.Stream;

public interface InputProvider {
    String getInputString() throws Exception;

    Stream<String> getInputStream() throws Exception;

    List<String> getInputList() throws Exception;
}
