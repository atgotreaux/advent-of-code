package com.gotreaux.aoc.puzzles.year2020.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class PassportProcessingPuzzle extends Puzzle {

    public PassportProcessingPuzzle() {
        super(2020, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int requiredFieldPassports = 0;
        int validPassports = 0;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Map<String, String> fields = new HashMap<>(8);

        List<String> input = inputReader.getInputList();
        for (int i = 0; i <= input.size(); i++) {
            String line = i == input.size() ? "" : input.get(i);
            if (line.isEmpty()) {
                Passport passport =
                        new Passport(
                                fields.getOrDefault("byr", ""),
                                fields.getOrDefault("iyr", ""),
                                fields.getOrDefault("eyr", ""),
                                fields.getOrDefault("hgt", ""),
                                fields.getOrDefault("hcl", ""),
                                fields.getOrDefault("ecl", ""),
                                fields.getOrDefault("pid", ""),
                                fields.getOrDefault("cid", ""));
                if (validator.validate(passport, RequiredFields.class).isEmpty()) {
                    requiredFieldPassports++;
                }
                if (validator.validate(passport, ValidFields.class).isEmpty()) {
                    validPassports++;
                }
                fields.clear();
            } else {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNext()) {
                    String[] field = scanner.next().split(":");
                    fields.put(field[0], field[1]);
                }
                scanner.close();
            }
        }

        return new PuzzleOutput<>(requiredFieldPassports, validPassports);
    }
}
