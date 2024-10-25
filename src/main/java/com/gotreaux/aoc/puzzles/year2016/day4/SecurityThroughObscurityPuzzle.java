package com.gotreaux.aoc.puzzles.year2016.day4;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class SecurityThroughObscurityPuzzle extends Puzzle {

    public SecurityThroughObscurityPuzzle() {
        super(2016, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NumberFormatException {
        Collection<Room> rooms =
                inputProvider
                        .getInputStream()
                        .map(SecurityThroughObscurityPuzzle::parseRoom)
                        .toList();

        int sumOfRealRooms = rooms.stream().filter(Room::isValid).mapToInt(Room::sectorID).sum();

        int northPoleSectorID =
                rooms.stream()
                        .filter(room -> room.decryptName().equals("northpoleobjectstorage"))
                        .mapToInt(Room::sectorID)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        return new PuzzleOutput<>(sumOfRealRooms, northPoleSectorID);
    }

    private static Room parseRoom(String line) {
        int sectorID = 0;
        String checksum = "";
        StringBuilder encryptedName = new StringBuilder();

        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("-");
        while (scanner.hasNext()) {
            String roomPart = scanner.next();
            if (Character.isDigit(roomPart.charAt(0))) {
                sectorID = Integer.parseInt(roomPart.substring(0, 3));
                checksum = roomPart.substring(4, 9);
            } else {
                encryptedName.append(roomPart);
            }
        }
        scanner.close();

        return new Room(sectorID, checksum, encryptedName.toString());
    }
}
