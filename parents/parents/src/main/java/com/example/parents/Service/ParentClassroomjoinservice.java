package com.example.parents.Service;

import com.example.parents.DTO.ParentJoinDTO;
import com.example.parents.Model.Classroom;
import com.example.parents.Model.User;
import com.example.parents.Repository.ClassroomRepo;
import com.example.parents.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

@Service
public class ParentClassroomjoinservice {
  @Autowired
    ClassroomRepo classroomRepo;

   @Autowired
   Userrepo userrepo;

    public Classroom joincclassroom(ParentJoinDTO pjd){
       Classroom classroom= classroomRepo.findByCode(pjd.getClassroomid()).orElseThrow(() -> new RuntimeException("Classroom not found"));
        System.out.println("Classroom ID: " + pjd.getUserid());

        User user = userrepo.findById(pjd.getUserid()).orElseThrow(() -> new RuntimeException("Teacher not found"));;

        classroom.addParent(user);
        classroomRepo.save(classroom);
        return classroom;

    }
}
