package org.crudDemo.model;

public class Manager {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private  String name;

    private  String email;
    private long number;
    private  int age;

    public Manager(int id, String name, String email, long number, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.age = age;
    }


    public Manager() {
        super();
    }

}
