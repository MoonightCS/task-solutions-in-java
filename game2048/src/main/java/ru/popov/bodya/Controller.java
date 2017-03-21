package ru.popov.bodya;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
Тебе же, предстоит закончить реализацию класса Controller.

Для начала нам понадобится конструктор, он будет принимать один параметр типа Model, инициализировать поле model, а также сохранять в поле view новый объект типа View с текущим контроллером(this)
в качестве параметра конструктора.

Далее, нам нужен метод resetGame, который позволит вернуть игровое поле в начальное состояние. Необходимо обнулить счет, установить флаги isGameWon и isGameLost у представления в false и вызывать метод
resetGameTiles у модели.

Добавим приватную константу int WINNING_TILE = 2048. Она будет определять вес плитки при достижении которого игра будет считаться выигранной.

Ну а теперь, самое главное! Для того чтобы иметь возможность обрабатывать пользовательский ввод, необходимо переопределить метод keyPressed с одним параметром типа KeyEvent.

Логика метода должна быть следующей:
1. Если была нажата клавиша ESC — вызови метод resetGame.
2. Если метод canMove модели возвращает false — установи флаг isGameLost в true.
3. Если оба флага isGameLost и isGameWon равны false — обработай варианты движения:
а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;
б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;
в) для клавиши KeyEvent.VK_UP вызови метод up у модели;
г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.
4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.
5. В самом конце, вызови метод repaint у view.

P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.

Также добавим в метод keyPressed класса Controller вызов метода rollback по нажатию на клавишу Z (код — KeyEvent.VK_Z).

 */

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
