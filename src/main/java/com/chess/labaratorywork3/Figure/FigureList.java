package com.chess.labaratorywork3.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureList {
    private List<List<Figure>> figureList;

    public FigureList(){
        figureList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            figureList.add(new ArrayList<>());  // Создаем 8 пустых строк
        }
    }

    public Figure getFigure(int i, int j){
        return figureList.get(i).get(j);
    }

    public void addFigure(Figure figure, int i, int j){
        while (figureList.get(i).size() <= j) {
            figureList.get(i).add(null);  // Заполняем пустыми значениями до нужного индекса
        }
        figureList.get(i).set(j, figure); // Устанавливаем фигуру
    }
}
