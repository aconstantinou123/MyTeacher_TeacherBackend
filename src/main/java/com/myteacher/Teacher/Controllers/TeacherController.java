package com.myteacher.Teacher.Controllers;

import com.myteacher.Teacher.Models.Teacher;
import com.myteacher.Teacher.Repositories.TeacherRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")

public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Teacher> getAllTeachers() {

        return repository.findAll();
    }

    @RequestMapping(value="/username/{username}", method = RequestMethod.GET)
    public Teacher getTeacherByEmail(@PathVariable("username") String username) {

        System.out.println("teacher retrieved");
        return repository.findByUsername(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Teacher getTeacherById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyTeacherById(@PathVariable("id") ObjectId id, @Valid @RequestBody Teacher teacher) {
        teacher.set_id(id);
        repository.save(teacher);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
//        teacher.set_id(ObjectId.get());
//        repository.save(teacher);
//        return teacher;
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
