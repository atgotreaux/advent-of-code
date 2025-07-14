package com.gotreaux.aoc.puzzles.year2024.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FilesystemTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(CharSequence input, List<String> expectedDiskMap, int expectedMaxFileId) {
        var filesystem = Filesystem.of(input);

        assertEquals(expectedDiskMap, filesystem.diskMap());
        assertEquals(expectedMaxFileId, filesystem.maxFileId());
    }

    @ParameterizedTest
    @MethodSource("provideDefragmentBlocks")
    void defragmentBlocks(CharSequence input, List<String> expectedDiskMap, int expectedMaxFileId) {
        var filesystem = Filesystem.of(input);
        var defragmentedFilesystem = filesystem.defragmentBlocks();

        assertEquals(expectedDiskMap, defragmentedFilesystem.diskMap());
        assertEquals(expectedMaxFileId, defragmentedFilesystem.maxFileId());
    }

    @ParameterizedTest
    @MethodSource("provideDefragmentFiles")
    void defragmentFiles(CharSequence input, List<String> expectedDiskMap, int expectedMaxFileId) {
        var filesystem = Filesystem.of(input);
        var defragmentedFilesystem = filesystem.defragmentFiles();

        assertEquals(expectedDiskMap, defragmentedFilesystem.diskMap());
        assertEquals(expectedMaxFileId, defragmentedFilesystem.maxFileId());
    }

    @Test
    void defragmentBlocksChecksum() {
        var filesystem = Filesystem.of("2333133121414131402");

        filesystem = filesystem.defragmentBlocks();

        assertEquals(1928L, filesystem.getChecksum());
    }

    @Test
    void defragmentFileChecksum() {
        var filesystem = Filesystem.of("2333133121414131402");

        filesystem = filesystem.defragmentFiles();

        assertEquals(2858L, filesystem.getChecksum());
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "12345",
                        List.of(
                                "0", ".", ".", "1", "1", "1", ".", ".", ".", ".", "2", "2", "2",
                                "2", "2"),
                        2),
                Arguments.of(
                        "90909",
                        List.of(
                                "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1",
                                "1", "1", "1", "1", "1", "2", "2", "2", "2", "2", "2", "2", "2",
                                "2"),
                        2),
                Arguments.of(
                        "2333133121414131402",
                        List.of(
                                "0", "0", ".", ".", ".", "1", "1", "1", ".", ".", ".", "2", ".",
                                ".", ".", "3", "3", "3", ".", "4", "4", ".", "5", "5", "5", "5",
                                ".", "6", "6", "6", "6", ".", "7", "7", "7", ".", "8", "8", "8",
                                "8", "9", "9"),
                        9));
    }

    private static Stream<Arguments> provideDefragmentBlocks() {
        return Stream.of(
                Arguments.of(
                        "12345",
                        List.of(
                                "0", "2", "2", "1", "1", "1", "2", "2", "2", ".", ".", ".", ".",
                                ".", "."),
                        2),
                Arguments.of(
                        "90909",
                        List.of(
                                "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1",
                                "1", "1", "1", "1", "1", "2", "2", "2", "2", "2", "2", "2", "2",
                                "2"),
                        2),
                Arguments.of(
                        "2333133121414131402",
                        List.of(
                                "0", "0", "9", "9", "8", "1", "1", "1", "8", "8", "8", "2", "7",
                                "7", "7", "3", "3", "3", "6", "4", "4", "6", "5", "5", "5", "5",
                                "6", "6", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".",
                                ".", ".", "."),
                        9));
    }

    private static Stream<Arguments> provideDefragmentFiles() {
        return Stream.of(
                Arguments.of(
                        "12345",
                        List.of(
                                "0", ".", ".", "1", "1", "1", ".", ".", ".", ".", "2", "2", "2",
                                "2", "2"),
                        2),
                Arguments.of(
                        "90909",
                        List.of(
                                "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1",
                                "1", "1", "1", "1", "1", "2", "2", "2", "2", "2", "2", "2", "2",
                                "2"),
                        2),
                Arguments.of(
                        "2333133121414131402",
                        List.of(
                                "0", "0", "9", "9", "2", "1", "1", "1", "7", "7", "7", ".", "4",
                                "4", ".", "3", "3", "3", ".", ".", ".", ".", "5", "5", "5", "5",
                                ".", "6", "6", "6", "6", ".", ".", ".", ".", ".", "8", "8", "8",
                                "8", ".", "."),
                        9));
    }
}
