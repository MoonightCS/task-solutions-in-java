package refactoring.human;

/*
2.1. Извлечение подкласса.
2.1.1. Добавь класс Soldier в пакет human.
2.1.2. Избавься от поля isSoldier.
2.1.3. Перенеси в Soldier необходимые методы из Human.
2.1.4. Обнови сигнатуру конструктора Human.
2.2. Подъем тела конструктора.
2.2.1. Перенеси инициализацию полей name и age в подходящее место, добавь необходимые параметры в конструктор Human.
2.2.2. Добавь конструктор в класс Soldier.


 */

public class Soldier extends Human {

    public Soldier(String name, int age) {

        super(name, age);
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {
    }

}
