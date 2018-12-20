package board;

import board.reader.BoardReader;
import board.reader.BoardReaderFactory;

import java.io.IOException;
import java.util.List;

public class Board {
    private final List<List<Integer>> board;

    public Board(String filePath) throws IOException {
        BoardReader reader = BoardReaderFactory.getReader(filePath);
        this.board = reader.parseBoard(filePath);
    }

    List<List<Integer>> getBoard() {
        return board;
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
