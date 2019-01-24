package board;

import board.reader.BoardReader;
import board.reader.BoardReaderFactory;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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

    public boolean isValid(){
        int i = 0;
        int j = 1;
        Iterator<List<Integer>> itRow = board.iterator();
        Iterator<List<Integer>> itCol = board.iterator();
        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5, 6 ,7 ,8 ,9, null);

        //rows helper methods eventually...
        if(board.contains(nums)) {
            return false;
        }else{
            while (itRow.hasNext()) {
                if (board.get(i).get(0).equals(board.get(i).get(j))) {
                    return false;
                }
                j++;
                if (j == 9) {
                    i++;
                    j = 1;
                    itRow.next();
                }
                if (i == 9) {
                    break;
                }
                while (board.get(i).get(0) == null) {
                    i++;
                    itRow.next();
                }
            }

            i = 0;
            j = 1;

            //columns should make helper methods
            while (itCol.hasNext()) {
                if (board.get(0).get(i).equals(board.get(j).get(i))) {
                    return false;
                }
                j++;
                if (j == 9) {
                    i++;
                    j = 1;
                    itCol.next();
                }
                if (i == 9) {
                    break;
                }
                while (board.get(j).get(0) == null || board.get(0).get(i) == null) {
                    if (board.get(0).get(i) == null) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }

            //3x3 still incomplete...
            /**for (int k = 0; k < 9; k += 3) { //Row
                for (int l = 0; l < 9; l += 3) { //Column
                    for (int m = 1; m < 3; m++) { //row
                        System.out.println(board.get(k).get(0) + " board.getk.get0 " + board.get(k) + " equals " + board.get(k).get(m));
                        if (board.get(k).get(0) == null) {
                            while (m <= 2) {
                                m++;
                                break;
                            }
                        } else if (board.get(k).get(0).equals(board.get(k).get(m))) {
                            return false;
                        }
                        for (int n = 1; n < 3; n++) { //column
                            System.out.println(board.get(0).get(l) + " board.get0.getl " + board.get(0) + " equals " + board.get(n).get(l));
                            if (board.get(0).get(l) == null) {
                                n++;
                                while (n <= 2) {
                                    n++;
                                    break;
                                }
                            } else if (board.get(0).get(l).equals(board.get(n).get(l))) {
                                return false;
                            }
                        }
                    }
                }
            }*/

        }
        return true;
    }

    public boolean isSolved(){
        if(!board.contains(null)){
            return false;
        }
        return true;
    }
}