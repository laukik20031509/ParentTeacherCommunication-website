package com.example.parents.Repository;

import com.example.parents.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo  extends JpaRepository<Post,String> {
    List<Post> findByClassroom_Id(Long classroomId);
}
