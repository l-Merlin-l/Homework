package ru.geekbrains.Lesson.Lesson5;

public class Employee {
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    Employee(String surname,String name, String middleName, String position, String email, String phoneNumber, int salary, int age){
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee(){
        System.out.println("Сотрудник " +
                "\nФИО: " + surname + " " + name + " " + middleName +
                "\nДолжность: " + position +
                "\nemail: " + email +
                "\nТелефон: " + phoneNumber +
                "\nЗарплата: " + salary +
                "\nВозраст: " + age);
    }

    public int getAge(){
        return this.age;
    }
}
