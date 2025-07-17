package com.example.parents.Service;

import com.example.parents.DTO.PostDTO;
import com.example.parents.Model.Classroom;
import com.example.parents.Model.Post;
import com.example.parents.Model.User;
import com.example.parents.Repository.ClassroomRepo;
import com.example.parents.Repository.PostRepo;
import com.example.parents.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServic {
    @Autowired
    PostRepo postRepo;
    @Autowired
    ClassroomRepo classroomRepo;
    @Autowired
   private  Userrepo userRepo;
    public Post createPost(PostDTO dto){

        Post pos = new Post();
        pos.setContent(dto.getContent());
        // Safe to assign nulls
        pos.setImageUrl(dto.getImageUrl());
        pos.setPdfUrl(dto.getPdfUrl());
        User teacher = userRepo.findById(dto.getTeacherId()).orElseThrow();
        Classroom classroom = classroomRepo.findById(dto.getClassroomId()).orElseThrow();
        pos.setTeacher(teacher);
        pos.setClassroom(classroom);

        postRepo.save(pos);
        return pos;
    }
}