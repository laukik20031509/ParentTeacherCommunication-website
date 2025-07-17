package com.example.parents.Repository;

import com.example.parents.Model.Classroom;
import com.example.parents.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom,Long> {
    Optional<Classroom> findByCode(String code);
    List<Classroom> findByTeacher(User teacher);
    List<Classroom> findByParentsIn(List<User> parents);
}
