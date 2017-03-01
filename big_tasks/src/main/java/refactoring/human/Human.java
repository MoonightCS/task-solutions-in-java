package refactoring.human;
/*
Рефакторинг (8)
        8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент
        создания объекта.
        8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с
        областью его использования.
        8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
        он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
        исключение.
        8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
        работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
        break.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    private static int nextId = 0;
    private int id;
    private List<Human> children = new ArrayList<>();
    protected int age;
    protected String name;

    public class Size {
        public int height;
        public int weight;
    }

    protected Size size;

    private BloodGroup bloodGroup;

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getPosition() {
        return "Человек";
    }

    @Override
    public void live() {

    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
}