package com.chess.labaratorywork3.Engine;

public class ChessCellUtils {
    public void setColor(ChessCell chessCell, int chessLocationX, int chessLocationY){
        if (chessLocationX%2 == 0){
            if (chessLocationY%2 == 0) chessCell.setStyle("-fx-background-color: beige;");
            else chessCell.setStyle("-fx-background-color: #ac9362;");
        }
        else{
                if (chessLocationY%2 == 0) chessCell.setStyle("-fx-background-color: #ac9362;");
                else chessCell.setStyle("-fx-background-color: beige;");
            }
    }

    public void setSize(ChessCell chessCell, double STAGE_WIDTH, double STAGE_HEIGHT, int CELLS_COUNT){
        chessCell.setPrefSize(STAGE_WIDTH / CELLS_COUNT, STAGE_HEIGHT / CELLS_COUNT);
    }
}
