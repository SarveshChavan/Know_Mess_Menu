package com.example.mess_system;

public class newfile2 {
    Integer at, am;
    String name, id;

    public newfile2(String id, String name,Integer at, Integer am ) {
        this.at = at;
        this.am = am;
        this.name = name;
        this.id = id;
    }

    public Integer getAt() {
        return at;
    }

    public void setAt(Integer at) {
        this.at = at;
    }

    public Integer getAm() {
        return am;
    }

    public void setAm(Integer am) {
        this.am = am;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}