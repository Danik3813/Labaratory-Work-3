package com.chess.labaratorywork3.Engine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

import com.chess.labaratorywork3.Figure.*;

public class ChessController {
    @FXML
    private Button newGameButton;
    @FXML
    private Button saveGameButton;
    @FXML
    private Button loadGameButton;
    @FXML
    private GridPane chessField;

    private final int CELLS_COUNT = 9;

    @FXML
    public void newGame(){

    }

    @FXML
    public void saveGame(){

    }

    @FXML
    public void loadGame(){

    }

    public void initializeChessField(double STAGE_WIDTH, double STAGE_HEIGHT){
        chessField.setPrefWidth(STAGE_WIDTH);
        chessField.setPrefHeight(STAGE_HEIGHT);

        //определение размера для нулевого столбца
        ColumnConstraints numbersColumn = new ColumnConstraints();
        numbersColumn.setPrefWidth(STAGE_WIDTH / CELLS_COUNT);
        chessField.getColumnConstraints().add(numbersColumn);

        //определение размера для нулевой строки
        RowConstraints lettersRow = new RowConstraints();
        lettersRow.setPrefHeight(STAGE_HEIGHT / CELLS_COUNT);
        chessField.getRowConstraints().add(lettersRow);

        //заполнение грид-сетки шахматными ячейками
        for (int i = 1; i < CELLS_COUNT; i++){
            for (int j = 1; j < CELLS_COUNT; j++){
                ChessCell chessCell = new ChessCell(i, j);
                ChessCellUtils chessCellUtils = new ChessCellUtils();
                chessCellUtils.setSize(chessCell, STAGE_WIDTH, STAGE_HEIGHT, CELLS_COUNT);
                chessCellUtils.setColor(chessCell, i, j);
                chessField.add(chessCell, i, j);
            }
        }
    }

    //рендеринг шахматных фигур
    public void renderFigures(FigureList figureList){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                String unicodeSymbol = figureList.getFigure(i, j).getUnicodeSymbol();

                // Декодируем HTML-энкодированный Unicode-символ
                if (unicodeSymbol.startsWith("&#x") && unicodeSymbol.endsWith(";")) {
                    int codePoint = Integer.parseInt(unicodeSymbol.substring(3, unicodeSymbol.length() - 1), 16);
                    unicodeSymbol = new String(Character.toChars(codePoint));
                }

                Label chessLabel = new Label(unicodeSymbol);
                chessField.add(chessLabel, j + 1, i + 1);
            }
        }
    }

}
