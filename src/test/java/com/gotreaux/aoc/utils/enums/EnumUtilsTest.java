package com.gotreaux.aoc.utils.enums;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EnumUtilsTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(Character label, TestEnum expectedEnum) {
        assertEquals(expectedEnum, EnumUtils.of(TestEnum.class, label));
    }

    @ParameterizedTest
    @MethodSource("provideOfNullable")
    void ofNullable(Character label, @Nullable TestEnum expectedEnum) {
        assertEquals(expectedEnum, EnumUtils.ofNullable(TestEnum.class, label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> EnumUtils.of(TestEnum.class, 'X'));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of('A', TestEnum.FIRST),
                Arguments.of('B', TestEnum.SECOND),
                Arguments.of('C', TestEnum.THIRD));
    }

    private static Stream<Arguments> provideOfNullable() {
        return Stream.of(
                Arguments.of('A', TestEnum.FIRST),
                Arguments.of('B', TestEnum.SECOND),
                Arguments.of('C', TestEnum.THIRD),
                Arguments.of('X', null));
    }

    @NullMarked
    private enum TestEnum implements LabeledEnum<Character> {
        FIRST('A'),
        SECOND('B'),
        THIRD('C');

        private final Character label;

        TestEnum(Character label) {
            this.label = label;
        }

        @Override
        public Character getLabel() {
            return label;
        }
    }
}
