package com.gotreaux.aoc.utils.enums;

import java.util.Arrays;
import org.jspecify.annotations.Nullable;

public final class EnumUtils {

    private EnumUtils() {}

    public static <E extends Enum<E> & LabeledEnum<L>, L> E of(Class<E> enumClass, L label) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(constant -> constant.getLabel().equals(label))
                .findFirst()
                .orElseThrow();
    }

    public static <E extends Enum<E> & LabeledEnum<L>, L> @Nullable E ofNullable(
            Class<E> enumClass, L label) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(constant -> constant.getLabel().equals(label))
                .findFirst()
                .orElse(null);
    }
}
