package com.github.mikhaylichenkoilya.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private final JPanel buttonPanel = new JPanel();
    private final JButton[][] buttons = new JButton[3][3];
    private final Field field = new Field(this);

    public GUI() {
        var frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                var button = new JButton();
                buttons[row][col] = button;
                button.addActionListener(new ButtonListener());
                button.setActionCommand(row + " " + col);
                buttonPanel.add(button);
                button.setFont(new Font("Ink Free", Font.BOLD, 120));
                button.setFocusable(false);
            }
        }

        frame.add(buttonPanel);

    }

    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] tokens = e.getActionCommand().split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            field.makeTurn(row, col);
        }
    }
}
