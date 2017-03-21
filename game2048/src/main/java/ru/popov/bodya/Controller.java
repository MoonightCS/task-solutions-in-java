package ru.popov.bodya;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private static final int WINNING_TILE = 2048;


    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame() {
        model.score = 0;
        model.maxTile = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
            resetGame();
        } else if (!model.canMove()) {
            view.isGameLost = true;
        } else if (!view.isGameLost && !view.isGameWon) {
            if (KeyEvent.VK_LEFT == e.getKeyCode()) model.left();
            else if (KeyEvent.VK_RIGHT == e.getKeyCode()) model.right();
            else if (KeyEvent.VK_UP == e.getKeyCode()) model.up();
            else if (KeyEvent.VK_DOWN == e.getKeyCode()) model.down();
            else if (KeyEvent.VK_Z == e.getKeyCode()) model.rollback();
            else if (KeyEvent.VK_R == e.getKeyCode()) model.randomMove();
            else if (KeyEvent.VK_A == e.getKeyCode()) model.autoMove();
            else view.repaint();

            if (WINNING_TILE == model.maxTile) {
                view.isGameWon = true;
            }
        }

        view.repaint();
    }


}
