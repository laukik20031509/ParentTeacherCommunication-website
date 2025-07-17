package com.example.parents.DTO;

public class ParentJoinDTO {

    private String classroomid;
    private  String userid;
    public String getUserid() {
            return  userid;
    }
    public void setUserid(String teacherid) {
       this.userid = teacherid;
    }


    public String getClassroomid() {
        return classroomid;
    }
    public void setClassroomid(String classroomid) {
       this.classroomid = classroomid;
    }
}
