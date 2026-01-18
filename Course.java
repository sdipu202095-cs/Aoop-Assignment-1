package com.example.demo.model;

public class Course {
    private String code;
    private String name;
    private int credits;
    private String instructor;

    public Course() {}

    public Course(String code, String name, int credits, String instructor) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
