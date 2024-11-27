package com.gotreaux.aoc.exceptions;

import java.io.Serial;
import java.util.NoSuchElementException;

public class NoSuchPuzzleException extends NoSuchElementException {

    @Serial private static final long serialVersionUID = 8881628274237077013L;

    public NoSuchPuzzleException(int year, int day) {
        super("No puzzle of year '%d' and day '%d' found".formatted(year, day));
    }
}
