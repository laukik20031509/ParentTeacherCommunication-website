package com.example.parents.DTO;

import org.springframework.stereotype.Component;

@Component
public class Classroomdto {
private String  teacherid;
private String classroomname;

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }
}
