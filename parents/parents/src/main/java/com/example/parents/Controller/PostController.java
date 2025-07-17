package com.example.parents.Controller;

import com.example.parents.DTO.PostDTO;
import com.example.parents.Model.Post;
import com.example.parents.Repository.ClassroomRepo;
import com.example.parents.Repository.PostRepo;
import com.example.parents.Service.PostServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class PostController {

    @Autowired
    private ClassroomRepo  classroomRepo;
    @Autowired
    private PostRepo  postRepo;



    @GetMapping("/showallposts/{classroomId}")
    public ResponseEntity<List<Post>> getPostsByClassroom(@PathVariable Long classroomId) {
        List<Post> posts = postRepo.findByClassroom_Id(classroomId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/createposts")
    public ResponseEntity<Post>Createpost(@RequestBody PostDTO postDTO) {
        PostServic    postServic = new PostServic();
        Post p=postServic.createPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);


    }
}
