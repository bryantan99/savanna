package com.example.savanna.model;

public class Student {

    private String name;
    private String matricNo;

    public Student(String name, String matricNo) {
        this.name = name;
        this.matricNo = matricNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }
}
