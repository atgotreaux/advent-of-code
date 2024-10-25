package com.gotreaux.aoc.puzzles.year2015.day16;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class AuntSuePuzzle extends Puzzle {

    public AuntSuePuzzle() {
        super(2015, 16);
    }

    @Override
    public PuzzleOutput<?, ?> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NoSuchElementException {
        List<Aunt> aunts = inputProvider.getInputStream().map(AuntSuePuzzle::parseAunt).toList();

        MFCSAM mfcsam = new MFCSAM(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

        Aunt matchingAunt = aunts.stream().filter(mfcsam::matches).findFirst().orElseThrow();
        Aunt matchingRangeAunt =
                aunts.stream().filter(mfcsam::matchesRange).findFirst().orElseThrow();

        return new PuzzleOutput<>(matchingAunt.id(), matchingRangeAunt.id());
    }

    private static Aunt parseAunt(String input) {
        String[] parts = input.replace(":", "").replace(",", "").split(" ");
        int length = parts.length;

        int id = Integer.parseInt(parts[1]);
        Map<Attribute, Integer> attributes = new EnumMap<>(Attribute.class);
        for (int i = 2; i < length; i += 2) {
            Attribute attribute = Attribute.valueOf(parts[i].toUpperCase(Locale.getDefault()));
            attributes.put(attribute, Integer.parseInt(parts[i + 1]));
        }

        return new Aunt(id, attributes);
    }
}
