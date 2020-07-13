package de.mats.NimSpiel;

import de.mats.NimSpiel.game.Bot;
import de.mats.NimSpiel.game.Spielfeld;
import de.mats.NimSpiel.panels.Main;
import de.mats.NimSpiel.panels.Second;
import de.mats.NimSpiel.panels.Third;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {

    Main main;
    Second second;
    Third third;

    Bot bot = null;
    Spielfeld spielfeld;

    String P1 = "", P2 = "";

    public Window() {
        setTitle("NimSpiel");
        ArrayList<Image> images = new ArrayList<>();
        images.add(new ImageIcon(Window.class.getResource("/icon_20x20.png")).getImage());
        images.add(new ImageIcon(Window.class.getResource("/icon_40x40.png")).getImage());
        setIconImages(images);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        third = new Third(Window.this);
        second = new Second(Window.this, third);
        main = new Main(Window.this, second);
        setContentPane(main.$$$getRootComponent$$$());
        setFixedFrameSize();
        setLocationRelativeTo(null);
        setAutoRequestFocus(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String p2) {
        P2 = p2;
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    private void setFixedFrameSize() {
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setMaximumSize(new Dimension(getSize()));
        setResizable(false);
    }
}
