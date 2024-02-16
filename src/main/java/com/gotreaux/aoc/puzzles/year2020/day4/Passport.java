package com.gotreaux.aoc.puzzles.year2020.day4;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

class Passport {
    @NotNull(groups = RequiredFields.class)
    @Min(value = 1920, groups = ValidFields.class)
    @Max(value = 2002, groups = ValidFields.class)
    @SuppressWarnings("UnusedVariable")
    private String birthYear;

    @NotNull(groups = RequiredFields.class)
    @Min(value = 2010, groups = ValidFields.class)
    @Max(value = 2020, groups = ValidFields.class)
    @SuppressWarnings("UnusedVariable")
    private String issueYear;

    @NotNull(groups = RequiredFields.class)
    @Min(value = 2020, groups = ValidFields.class)
    @Max(value = 2030, groups = ValidFields.class)
    @SuppressWarnings("UnusedVariable")
    private String expirationYear;

    @NotNull(groups = RequiredFields.class)
    @SuppressWarnings("UnusedVariable")
    private String height;

    @NotNull(groups = RequiredFields.class)
    @SuppressWarnings("UnusedVariable")
    private String hairColor;

    @NotNull(groups = RequiredFields.class)
    @SuppressWarnings("UnusedVariable")
    private String eyeColor;

    @NotNull(groups = RequiredFields.class)
    @SuppressWarnings("UnusedVariable")
    private String passportID;

    @SuppressWarnings("UnusedVariable")
    private String countryID;

    void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    void setHeight(String height) {
        this.height = height;
    }

    void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    void setCountryID(String countryID) {
        this.countryID = countryID;
    }
}
