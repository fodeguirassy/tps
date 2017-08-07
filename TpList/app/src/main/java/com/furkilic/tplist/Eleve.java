package com.furkilic.tplist;

public class Eleve {

    private String lastname;
    private String firstname;
    private Integer age;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }
}
