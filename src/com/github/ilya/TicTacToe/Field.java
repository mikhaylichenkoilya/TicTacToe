package com.github.ilya.TicTacToe;

import javax.swing.*;

public class Field {
    private char[][] field;
    private final GUI gui;
    private boolean xTurn = true;

    public Field(GUI gui) {
        resetField();
        this.gui = gui;
    }

    public char[][] getField() {
        return field;
    }

    public void resetField() {
        this.field = new char[3][3];
    }

    public void makeTurn(int row, int col) {
        if (xTurn) {
            setX(row, col);
        } else {
            setO(row, col);
        }
    }

    private void setX(int row, int col) {
        set(row, col, 'X');
    }

    private void setO(int row, int col) {
        set(row, col, 'O');
    }

    private void set(int row, int col, char value) {
        if (field[row][col] == 0) {
            field[row][col] = value;
            gui.getButton(row, col).setText(String.valueOf(value));
            xTurn = !xTurn;

            if (checkWin()) {
                JOptionPane.showInputDialog(gui.getButtonPanel(),
                        "Win!!!", null);
            }
        }

    }

    private boolean checkWin() {
        return checkRows() || checkCols() || checkDiagonals();
    }

    private boolean checkDiagonals() {
        return field[1][1] != 0 && (field[0][0] == field[1][1] && field[1][1] == field[2][2]
                || field[0][2] == field[1][1] && field[1][1] == field[2][0]);
    }

    private boolean checkCols() {
        for (int col = 0; col < 3; col++) {
            if (field[0][col] != 0 && field[0][col] == field[1][col] && field[1][col] == field[2][col]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            if (field[row][0] != 0 && field[row][0] == field[row][1] && field[row][1] == field[row][2]) {
                return true;
            }
        }
        return false;
    }

    public char getCell(int row, int col) {
        return field[row][col];
    }
}
