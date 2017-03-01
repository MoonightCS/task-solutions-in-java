package refactoring.human;

public class Teacher extends UniversityPerson {
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {

        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void teach() {
    }


    @Override
    public String getPosition() {
        return "Преподаватель";
    }

    @Override
    public void live() {
        teach();
    }


}