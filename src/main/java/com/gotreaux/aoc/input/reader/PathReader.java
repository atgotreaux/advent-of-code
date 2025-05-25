package com.gotreaux.aoc.input.reader;

import java.io.IOException;
import java.nio.file.Path;

@FunctionalInterface
interface PathReader<T> {
    T read(Path path) throws IOException;
}
