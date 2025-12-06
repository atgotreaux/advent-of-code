package com.gotreaux.aoc.utils.enums;

@FunctionalInterface
public interface LabeledEnum<L> {
    L getLabel();
}
