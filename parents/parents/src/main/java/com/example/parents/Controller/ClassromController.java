package com.example.parents.Controller;

import com.example.parents.DTO.Classroomdto;
import com.example.parents.DTO.ParentJoinDTO;
import com.example.parents.Model.Classroom;
import com.example.parents.Model.User;
import com.example.parents.Repository.Userrepo;
import com.example.parents.Service.ClassroomService;
import com.example.parents.Service.ParentClassroomjoinservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ClassromController {
   @Autowired
    ClassroomService classroomService;
@Autowired
ParentClassroomjoinservice parentClassroomjoinservice;


@GetMapping("/showallClassrooms/{id}")
public ResponseEntity<List<Classroom>> getAllClassrooms(@PathVariable String id){

    List<Classroom> clp=new ArrayList<>();
    clp=classroomService.findAll(id);
    return new ResponseEntity<>(clp,HttpStatus.OK);
}



    @CrossOrigin(origins = "http://localhost:5173")
@PostMapping("/createclassroom")
public ResponseEntity<String> createClassroom(@RequestBody Classroomdto request) {
        String response=classroomService.createclassroom(request);
        return new ResponseEntity<String>(response, HttpStatus.OK);



    }

@PostMapping("/joinClassroom")
    public ResponseEntity<Classroom> createClassroom(@RequestBody ParentJoinDTO request) {
        Classroom response= parentClassroomjoinservice.joincclassroom(request);
        return new ResponseEntity<Classroom>(response, HttpStatus.OK);



    }


}
