package com.gotreaux.aoc.puzzles.year2024.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

record Filesystem(List<String> diskMap, int maxFileId) {

    private static final String EMPTY_BLOCK = ".";

    static Filesystem of(CharSequence input) {
        List<String> diskMap = new ArrayList<>(input.length());

        var fileId = 0;
        var isFile = true;
        for (var inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            var blockId = isFile ? String.valueOf(fileId++) : EMPTY_BLOCK;
            var blockSize = Character.digit(input.charAt(inputIndex), 10);
            for (var blockIndex = 0; blockIndex < blockSize; blockIndex++) {
                diskMap.add(blockId);
            }
            isFile = !isFile;
        }

        return new Filesystem(diskMap, fileId - 1);
    }

    Filesystem defragmentBlocks() {
        List<String> defragmentedDiskMap = new ArrayList<>(diskMap);

        var freeIndexStart = 0;
        for (var fileIndex = defragmentedDiskMap.size() - 1; fileIndex >= 0; fileIndex--) {
            if (!defragmentedDiskMap.get(fileIndex).equals(EMPTY_BLOCK)) {
                for (var freeIndex = freeIndexStart; freeIndex < fileIndex; freeIndex++) {
                    if (defragmentedDiskMap.get(freeIndex).equals(EMPTY_BLOCK)) {
                        defragmentedDiskMap.set(freeIndex, defragmentedDiskMap.get(fileIndex));
                        defragmentedDiskMap.set(fileIndex, EMPTY_BLOCK);
                        freeIndexStart = freeIndex + 1;
                        break;
                    }
                }
            }
        }

        return new Filesystem(defragmentedDiskMap, maxFileId);
    }

    Filesystem defragmentFiles() {
        List<String> defragmentedDiskMap = new ArrayList<>(diskMap);

        var freeIndexStart = 0;
        for (var fileId = maxFileId; fileId >= 0; fileId--) {
            var start = defragmentedDiskMap.indexOf(String.valueOf(fileId));
            var end = defragmentedDiskMap.lastIndexOf(String.valueOf(fileId));
            var blockSize = end - start + 1;

            var freeSpace = 0;
            var freeSpaceNotFound = true;
            for (var freeIndex = freeIndexStart; freeIndex < start; freeIndex++) {
                if (defragmentedDiskMap.get(freeIndex).equals(EMPTY_BLOCK)) {
                    freeSpace++;
                    if (freeSpaceNotFound) {
                        freeIndexStart = freeIndex;
                        freeSpaceNotFound = false;
                    }
                    if (freeSpace == blockSize) {
                        for (var blockIndex = 0; blockIndex < blockSize; blockIndex++) {
                            defragmentedDiskMap.set(
                                    freeIndex - blockSize + blockIndex + 1, String.valueOf(fileId));
                            defragmentedDiskMap.set(start + blockIndex, EMPTY_BLOCK);
                        }
                        break;
                    }
                } else {
                    freeSpace = 0;
                }
            }
        }

        return new Filesystem(defragmentedDiskMap, maxFileId);
    }

    long getChecksum() {
        return IntStream.range(0, diskMap.size())
                .filter(i -> !diskMap.get(i).equals(EMPTY_BLOCK))
                .mapToLong(i -> i * Long.parseLong(diskMap.get(i)))
                .sum();
    }
}
