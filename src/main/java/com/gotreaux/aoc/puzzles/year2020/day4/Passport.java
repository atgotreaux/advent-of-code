package com.gotreaux.aoc.puzzles.year2020.day4;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

record Passport(
        @NotEmpty(groups = RequiredFields.class)
                @Min(value = 1920, groups = ValidFields.class)
                @Max(value = 2002, groups = ValidFields.class)
                String birthYear,
        @NotEmpty(groups = RequiredFields.class)
                @Min(value = 2010, groups = ValidFields.class)
                @Max(value = 2020, groups = ValidFields.class)
                String issueYear,
        @NotEmpty(groups = RequiredFields.class)
                @Min(value = 2020, groups = ValidFields.class)
                @Max(value = 2030, groups = ValidFields.class)
                String expirationYear,
        @NotEmpty(groups = RequiredFields.class)
                @Pattern(
                        regexp = "(1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in",
                        groups = ValidFields.class)
                String height,
        @NotEmpty(groups = RequiredFields.class)
                @Pattern(regexp = "#[0-9A-Fa-f]{6}", groups = ValidFields.class)
                String hairColor,
        @NotEmpty(groups = RequiredFields.class)
                @Pattern(regexp = "amb|blu|brn|gry|grn|hzl|oth", groups = ValidFields.class)
                String eyeColor,
        @NotEmpty(groups = RequiredFields.class)
                @Pattern(regexp = "\\d{9}", groups = ValidFields.class)
                String passportID,
        String countryID) {}
