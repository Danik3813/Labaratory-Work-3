package com.chess.labaratorywork3;

import com.chess.labaratorywork3.Engine.ChessController;
import com.chess.labaratorywork3.Figure.Figure;
import com.chess.labaratorywork3.Figure.FigureList;
import com.chess.labaratorywork3.Figure.FiguresReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Application {

    @Override
    public void start(Stage chessStage) throws IOException {
        //Создание корневого элемента
        FXMLLoader fxmlLoader = new FXMLLoader();
        String FXML_URL = "ChessInterface.fxml";
        fxmlLoader.setLocation(getClass().getResource(FXML_URL));
        Parent root = fxmlLoader.load();
        chessStage.getIcons().add(new Image(getClass().getResourceAsStream("chessIco.png")));

        //Определение размеров окна
        final double STAGE_WIDTH = 800.0;
        final double STAGE_HEIGHT = 800.0;

        //Загрузка шахматного поля
        ChessController chessController = fxmlLoader.getController();
        chessController.initializeChessField(STAGE_WIDTH, STAGE_HEIGHT);

        //Загрузка фигур из файла
        FigureList figureList = new FigureList();
        final int CELLS_COUNT = 8;
        String fileName = "DefaultFigures.csv";
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Файл " + fileName + " не найден в ресурсах!");
        }

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = bufferedReader.readLine();
            for (int i = 0; i < CELLS_COUNT; i++){
                for (int j = 0; j < CELLS_COUNT; j++){
                    line = bufferedReader.readLine();
                    System.out.println(line);
                    String[] el = line.split(",");
                    String figureType = el[0];
                    String unicodeSymbol = el[1];
                    Boolean color = Boolean.parseBoolean(el[2]);
                    Figure figure = new Figure(color, unicodeSymbol, figureType);
                    figureList.addFigure(figure, i, j);
                }
            }
            for (int i = 0; i < CELLS_COUNT; i++){
                for (int j = 0; j < CELLS_COUNT; j++){
                    System.out.print(figureList.getFigure(i, j).getFigureType() + " ");
                }
                System.out.println();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        chessController.renderFigures(figureList);

        //Создание окна
        Scene chessScene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
        chessStage.setResizable(false);
        chessStage.setScene(chessScene);
        chessStage.setTitle("Шахматы");
        chessStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
