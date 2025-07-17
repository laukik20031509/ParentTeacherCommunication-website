package com.example.parents.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Classroom {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
     private String name;
     private  String code;
      @ManyToOne
    private  User teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<User> getParents() {
        return parents;
    }

    public void setParents(List<User> parents) {
        this.parents = parents;
    }

    @ManyToMany
    private List<User> parents= new ArrayList<>();

    public void addParent(User parent) {
        if (parent != null && !parents.contains(parent)) {
            parents.add(parent);
        }
    }






}
