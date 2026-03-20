package com.example.demo.entity;

import java.util.Objects;

public class Student {
    private String Ref;
    private String firstname;
    private String lastname;
    private int age;
    public Student() {

    }

    public Student(String ref, String firstname, String lastname, int age) {
        Ref = ref;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(Ref, student.Ref) && Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Ref, firstname, lastname, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Ref='" + Ref + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
