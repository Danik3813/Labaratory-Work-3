package com.chess.labaratorywork3.Engine;

import javafx.scene.layout.Pane;

public class ChessCell extends Pane {
    private int cellLocationX;
    private int cellLocationY;

    public ChessCell(int cellLocationX, int cellLocationY){
        this.cellLocationX = cellLocationX;
        this.cellLocationY = cellLocationY;
    }

    public void setCellLocationX(int cellLocationX){
        this.cellLocationX = cellLocationX;
    }

    public void setCellLocationY(int cellLocationY){
        this.cellLocationY = cellLocationY;
    }

    public int getCellLocationX(){
        return cellLocationX;
    }

    public int getCellLocationY(){
        return cellLocationY;
    }

}
