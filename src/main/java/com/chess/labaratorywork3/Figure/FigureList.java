package com.chess.labaratorywork3.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureList {
    private List<List<Figure>> figureList;

    public FigureList(int CELLS_COUNT){
        figureList = new ArrayList<>();
        for (int i = 0; i < CELLS_COUNT; i++) {
            figureList.add(new ArrayList<>());
        }
    }

    public Figure getFigure(int i, int j){
        return figureList.get(i).get(j);
    }

    public void addFigure(Figure figure, int i, int j){
        figureList.get(i).add(j, figure); // Устанавливаем фигуру
    }
}
