package com.gotreaux.aoc.puzzles.year2020.day4;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Scanner;

@ShellPuzzle(year = 2020, day = 4, title = "Passport Processing")
public class PassportProcessingPuzzle extends Puzzle {
    public PassportProcessingPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int validPassports = 0;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Passport passport = new Passport();

        for (String line : getInputProvider().getInputList()) {
            if (line.isEmpty()) {
                if (validator.validate(passport, RequiredFields.class).isEmpty()) {
                    validPassports++;
                }
                passport = new Passport();
            } else {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNext()) {
                    String[] field = scanner.next().split(":");
                    switch (field[0]) {
                        case String s when s.equals("byr") -> passport.setBirthYear(field[1]);
                        case String s when s.equals("iyr") -> passport.setIssueYear(field[1]);
                        case String s when s.equals("eyr") -> passport.setExpirationYear(field[1]);
                        case String s when s.equals("hgt") -> passport.setHeight(field[1]);
                        case String s when s.equals("hcl") -> passport.setHairColor(field[1]);
                        case String s when s.equals("ecl") -> passport.setEyeColor(field[1]);
                        case String s when s.equals("pid") -> passport.setPassportID(field[1]);
                        case String s when s.equals("cid") -> passport.setCountryID(field[1]);
                        default ->
                                throw new IllegalArgumentException(
                                        "Unexpected field '%s'".formatted(field[0]));
                    }
                }
                scanner.close();
            }
        }
        if (validator.validate(passport, RequiredFields.class).isEmpty()) {
            validPassports++;
        }

        return new PuzzleOutput<>(validPassports, 0);
    }
}
