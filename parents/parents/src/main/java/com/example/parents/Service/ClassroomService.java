package com.example.parents.Service;

import com.example.parents.DTO.Classroomdto;
import com.example.parents.Model.Classroom;
import com.example.parents.Model.User;
import com.example.parents.Repository.ClassroomRepo;
import com.example.parents.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

@Service
public class ClassroomService {

    @Autowired
    private Userrepo userpo;

    @Autowired
    private ClassroomRepo classroomrepo;

    public String createclassroom(Classroomdto  request){
        User teacher=userpo.findById(request.getTeacherid()).orElseThrow(()->new RuntimeException("Teacher Not Found"));

        Classroom classroom=new Classroom();
        classroom.setName(request.getClassroomname());
        classroom.setTeacher(teacher);
        classroom.setCode(generateRandomCode());
        classroomrepo.save(classroom);

  return generateRandomCode();
    }


    private String generateRandomCode() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase(); // e.g. "A1B2C3"
    }

    public List<Classroom> findAll(String id){
        User user=userpo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        List<Classroom> clp=new ArrayList<>();

        if(user.getRole().equals("Parent")){
            clp=classroomrepo.findByParentsIn(List.of(user));
        }
        else {
            clp = classroomrepo.findByTeacher(user);
        }
        return clp;


    }
}
