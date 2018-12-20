package main.board;

import main.board.reader.BoardReader;
import main.board.reader.BoardReaderFactory;
import main.board.reader.SdkBoardReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<List<Integer>> board;

    public Board(String filePath) throws IOException {
        BoardReader reader = BoardReaderFactory.getReader(filePath);
        this.board = reader.parseBoard(filePath);
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
