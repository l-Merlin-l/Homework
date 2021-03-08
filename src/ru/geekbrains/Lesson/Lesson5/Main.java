package ru.geekbrains.Lesson.Lesson5;

public class Main {
    private static Employee [] employee;
    private static final int SIZE_EMPLOYEE = 5;
    private static final int MIN_AGE = 40;

    public static void main(String[] args) {
        initEmployee();

        for(Employee person: employee){
            if(person.getAge() >= MIN_AGE){
                person.printEmployee();
            }
        }
    }

    private static void initEmployee() {
        employee = new Employee[SIZE_EMPLOYEE];

        employee[0] = new Employee("Кравченко", "Игорь", "Владимирович", "Инженер-программист",
                "oymerlinyo@gmail.com", "+375336420342",
                850, 24);
        employee[1] = new Employee("Кулик", "Василий", "Владимирович", "Охранник",
                "vasya@gmail.com", "+375331234567",
                700, 55);
        employee[2] = new Employee("Дыленок", "Ольга", "Владимировна", "Кассир",
                "olga@gmail.com", "+375333333333",
                650, 29);
        employee[3] = new Employee("Королев", "Анатолий", "Павлович", "Бармен",
                "tolya@gmail.com", "+375334444444",
                1000, 21);
        employee[4] = new Employee("Андриалович", "Инна", "Васильевна", "Преподаватель",
                "inna@gmail.com", "+375335555555",
                1100, 25);
    }
}
