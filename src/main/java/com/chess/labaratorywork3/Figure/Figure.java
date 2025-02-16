package com.chess.labaratorywork3.Figure;

public class Figure {
    private Boolean color;
    private String unicodeSymbol;
    private String figureType;
//    private double x;
//    private double y;

    public Figure(Boolean color, String unicodeSymbol, String figureType) {
        this.color = color;
        this.unicodeSymbol = unicodeSymbol;
        this.figureType = figureType;
    }

//    public Figure(Boolean color, String unicodeSymbol, String figureType, double x, double y) {
//        this.color = color;
//        this.unicodeSymbol = unicodeSymbol;
//        this.figureType = figureType;
//        this.x = x;
//        this.y = y;
//    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    public void setUnicodeSymbol(String unicodeSymbol) {
        this.unicodeSymbol = unicodeSymbol;
    }

    public void setFigureType(String figureType){
        this.figureType = figureType;
    }

//    public void setX(double x) {
//        this.x = x;
//    }
//
//    public void setY(double y) {
//        this.y = y;
//    }

    public Boolean getColor() {
        return color;
    }

    public String getUnicodeSymbol() {
        return unicodeSymbol;
    }

    public String getFigureType() {
        return figureType;
    }

//    public double getX() {
//        return x;
//    }
//
//    public double getY() {
//        return y;
//    }
}
