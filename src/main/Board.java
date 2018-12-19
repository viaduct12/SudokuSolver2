package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class Board {
    private List<List<Integer>> board;

    Board(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        this.board = Files.lines(path).map(s -> s.chars().mapToObj(value -> {
            if (value == '.') {
                return null;
            } else {
                return Character.getNumericValue(value);
            }
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (List<Integer> row : this.board) {
            StringBuilder rowString = new StringBuilder();
            for (Integer item : row) {
                if (item == null) {
                    rowString.append('.');
                } else {
                    rowString.append(item.toString());
                }
            }

            boardString.append(rowString);
            boardString.append("\n");
        }

        return boardString.toString();
    }
}
