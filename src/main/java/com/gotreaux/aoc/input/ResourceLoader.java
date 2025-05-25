package com.gotreaux.aoc.input;

import java.net.URISyntaxException;
import java.nio.file.Path;

public record ResourceLoader(String inputPath) {

    public Path load() {
        try {
            var resource = getClass().getClassLoader().getResource(inputPath);
            if (resource == null) {
                throw new IllegalStateException("Resource not found: %s".formatted(inputPath));
            }
            return Path.of(resource.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Invalid resource URI: %s".formatted(inputPath), e);
        }
    }
}
