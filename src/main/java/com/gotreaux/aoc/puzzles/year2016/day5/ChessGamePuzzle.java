package com.gotreaux.aoc.puzzles.year2016.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

@ShellPuzzle(year = 2016, day = 5, title = "How About a Nice Game of Chess?")
public class ChessGamePuzzle extends Puzzle {
    public ChessGamePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, String> solve()
            throws IOException, URISyntaxException, NoSuchAlgorithmException {
        String doorID = getInputProvider().getInputString();

        String nextCharPassword =
                findPassword(
                        doorID, s -> s.startsWith("00000"), (s, i) -> i, s -> s.codePointAt(5));

        String nextPositionPassword =
                findPassword(
                        doorID,
                        s -> s.startsWith("00000") && HexFormat.fromHexDigit(s.codePointAt(5)) < 8,
                        (s, i) -> HexFormat.fromHexDigit(s.codePointAt(5)),
                        s -> s.codePointAt(6));

        return new PuzzleOutput<>(nextCharPassword, nextPositionPassword);
    }

    private static String findPassword(
            String doorID,
            Predicate<String> shouldAppend,
            ToIntBiFunction<String, Integer> appendIndex,
            ToIntFunction<String> appendChar)
            throws NoSuchAlgorithmException {
        Map<Integer, Integer> positionMapping = new HashMap<>(8);

        MessageDigest md = MessageDigest.getInstance("MD5");
        int number = 0;
        while (positionMapping.size() < 8) {
            String input = doorID + number;
            md.update(input.getBytes(Charset.defaultCharset()));
            String hash = HexFormat.of().formatHex(md.digest());

            if (shouldAppend.test(hash)) {
                positionMapping.putIfAbsent(
                        appendIndex.applyAsInt(hash, positionMapping.size()),
                        appendChar.applyAsInt(hash));
            }

            number++;
        }

        return positionMapping.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
