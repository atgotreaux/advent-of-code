package com.gotreaux.aoc.puzzles.year2022.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.springframework.lang.Nullable;

class Directory {
    private final String name;
    private final @Nullable Directory parent;
    private final Collection<File> files = new ArrayList<>();
    private final Collection<Directory> directories = new ArrayList<>();

    Directory(String name) {
        this.name = name;
        parent = null;
    }

    Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    private String getName() {
        return name;
    }

    Directory getParent() {
        return parent == null ? this : parent;
    }

    Directory getRoot() {
        var directory = this;
        while (!directory.equals(directory.getParent())) {
            directory = directory.getParent();
        }
        return directory;
    }

    void addFile(File file) {
        files.add(file);
    }

    void addDirectory(Directory directory) {
        directories.add(directory);
    }

    Directory getDirectory(String name) throws NoSuchElementException {
        return directories.stream()
                .filter(directory -> directory.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    Collection<Directory> getDirectories() {
        return directories.stream()
                .flatMap(
                        directory ->
                                Stream.concat(
                                        Stream.of(directory), directory.getDirectories().stream()))
                .toList();
    }

    int size() {
        return files.stream().mapToInt(File::size).sum()
                + directories.stream().mapToInt(Directory::size).sum();
    }
}
