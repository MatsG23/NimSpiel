package de.mats.NimSpiel.panels;

import de.mats.NimSpiel.Window;
import de.mats.NimSpiel.game.Spielfeld;

import javax.swing.*;
import java.awt.*;

public class Second {

    Window window;
    Third third;

    private JPanel panel;
    private JTextField player1TextField, player2TextField;
    private JComboBox<Integer> anzahlReihenComboBox;
    private JButton weiterButton;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public Second(Window window, Third third) {
        this.window = window;
        this.third = third;
    }

    public JTextField getPlayer2TextField() {
        return player2TextField;
    }

    private void createUIComponents() {
        anzahlReihenComboBox = new JComboBox<>(new Integer[]{5, 6, 7, 8});
        weiterButton = new JButton();
        weiterButton.addActionListener(e -> {
            boolean Valid = true;
            if (player1TextField.getText().equals("")) {
                Valid = false;
            }
            if (player2TextField.getText().equals("")) {
                Valid = false;
            }

            if (!Valid) {
                JOptionPane.showMessageDialog(null, "Es trat ein Fehler auf. Überprüfe, ob du alle Textfelder ausgefüllt hast und fülle sie ggf. aus!", "Fehlerhafte Eingabe", JOptionPane.ERROR_MESSAGE);
            } else {
                JTextPane textPane = third.getTextPane1();
                Spielfeld spielfeld = new Spielfeld(Integer.parseInt(anzahlReihenComboBox.getSelectedItem().toString()));
                window.setSpielfeld(spielfeld);
                textPane.setText(spielfeld.render());
                JLabel POT = third.getPOT();
                POT.setText(player1TextField.getText() + " ist am Zug");
                window.setContentPane(third.$$$getRootComponent$$$());
                window.pack();
            }
            window.setP1(player1TextField.getText());
            window.setP2(player2TextField.getText());
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        player1TextField = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 300;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(player1TextField, gbc);
        player2TextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(player2TextField, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(anzahlReihenComboBox, gbc);
        weiterButton.setIcon(new ImageIcon(getClass().getResource("/arrow_right.png")));
        weiterButton.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(7, 0, 7, 0);
        panel.add(weiterButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Spieler 1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Spieler2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Anzahl Reihen");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(7, 0, 0, 0);
        panel.add(label3, gbc);
        label1.setLabelFor(player1TextField);
        label2.setLabelFor(player2TextField);
        label3.setLabelFor(anzahlReihenComboBox);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}