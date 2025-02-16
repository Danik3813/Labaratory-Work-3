package com.chess.labaratorywork3.Figure;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class FiguresReader {
    private String fileName;

    public FiguresReader(String fileName) {
        this.fileName = fileName;
    }

    public void read(FigureList figureList) throws IOException {
        final int CELLS_COUNT = 8;
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Файл " + fileName + " не найден в ресурсах!");
        }

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = bufferedReader.readLine();
            for (int i = 0; i < CELLS_COUNT; i++){
                for (int j = 0; j < CELLS_COUNT; j++){
                    line = bufferedReader.readLine();
                    String[] el = line.split(" ");
                    String figureType = el[0];
                    String unicodeSymbol = el[1];
                    Boolean color = Boolean.parseBoolean(el[2]);
                    Figure figure = new Figure(color, unicodeSymbol, figureType);
                    figureList.addFigure(figure, i, j);
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
