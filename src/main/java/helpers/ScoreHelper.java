package helpers;

import models.Board;
import models.Coordinates;
import models.FieldState;

public class ScoreHelper {
    public static int calculateScore(Board board) {
        int score = 0;

        // Rows
        for (int i = 0; i < 5; ++i) {
            score += calculateRowScore(board, i);
        }

        // Cols
        for (int i = 0; i < 5; ++i) {
            score += calculateColScore(board, i);
        }

        // First diagonal
        score += calculateFirstDiagonalScore(board);

        // Second diagonal
        score += calculateSecondDiagonalScore(board);

        return score;
    }

    // Only for vertical or horizontal line
    private static int calculateLineScore(Board board, Coordinates beginCoordinates, Coordinates endCoordinates) {
        int score = 0;
        int positiveNumOfFields = 0;
        int negativeNumOfFields = 0;

        /*
            Integer.compare will return:
            -1 if endCoordinates.getRow() < beginCoordinates.getRow()
            0 if endCoordinates.getRow() == beginCoordinates.getRow()
            1 if endCoordinates.getRow() > beginCoordinates.getRow()
         */
        int rowChange = Integer.compare(endCoordinates.getRow(), beginCoordinates.getRow());
        int colChange = Integer.compare(endCoordinates.getCol(), beginCoordinates.getCol());

        for(int i = beginCoordinates.getRow(), j = beginCoordinates.getCol(); i < 5 && j < 5; i += rowChange, j += colChange) {
            FieldState fieldState = board.getFieldState(i, j);
            if (fieldState == FieldState.EMPTY) {
                continue;
            }

            if (fieldState == FieldState.X) {
                ++positiveNumOfFields;
            } else {
                ++negativeNumOfFields;
            }
        }

        // Return 0 if at least 1 our mark and 1 enemy's
        if (positiveNumOfFields > 0 && negativeNumOfFields > 0) {
            return 0;
        }

        // Each X mark gives +1 point
        score += positiveNumOfFields;

        if (positiveNumOfFields == 5 ) { score += 100; }

        // Each O mark gives -1 point
        score -= negativeNumOfFields;
        if (negativeNumOfFields == 5 ) { score -= 100; }

        return score;
    }

    private static int calculateRowScore(Board board, int rowNum) {
        return calculateLineScore(board, new Coordinates(rowNum, 0), new Coordinates(rowNum, 4));
    }

    private static int calculateColScore(Board board, int colNum) {
        return calculateLineScore(board, new Coordinates(0, colNum), new Coordinates(4, colNum));
    }

    // First diagonal - top left to bottom right
    private static int calculateFirstDiagonalScore(Board board) {
        int score = 0;
        int positiveNumOfFields = 0;
        int negativeNumOfFields = 0;

        for(int i = 0; i < 5 ; i += 1) {
            FieldState fieldState = board.getFieldState(i, i);
            if (fieldState == FieldState.EMPTY) {
                continue;
            }

            if (fieldState == FieldState.X) {
                ++positiveNumOfFields;
            } else {
                ++negativeNumOfFields;
            }
        }

        // Return 0 if at least 1 our mark and 1 enemy's
        if (positiveNumOfFields > 0 && negativeNumOfFields > 0) {
            return 0;
        }

        // Each X mark gives +1 point
        score += positiveNumOfFields;

        // Each O mark gives -1 point
        score -= negativeNumOfFields;

        return score;
    }

    // First diagonal - top left to bottom right
    private static int calculateSecondDiagonalScore(Board board) {
        int score = 0;
        int positiveNumOfFields = 0;
        int negativeNumOfFields = 0;

        for(int i = 4; i >= 0 ; i -= 1) {
            FieldState fieldState = board.getFieldState(4-i, i);
            if (fieldState == FieldState.EMPTY) {
                continue;
            }

            if (fieldState == FieldState.X) {
                ++positiveNumOfFields;
            } else {
                ++negativeNumOfFields;
            }
        }

        // Return 0 if at least 1 our mark and 1 enemy's
        if (positiveNumOfFields > 0 && negativeNumOfFields > 0) {
            return 0;
        }

        // Each X mark gives +1 point
        score += positiveNumOfFields;

        // Each O mark gives -1 point
        score -= negativeNumOfFields;

        return score;
    }
}
