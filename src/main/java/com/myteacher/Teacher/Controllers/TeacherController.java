package com.myteacher.Teacher.Controllers;

import com.myteacher.Teacher.Models.Teacher;
import com.myteacher.Teacher.Repositories.TeacherRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

import static com.myteacher.Teacher.com.security.SecurityConstants.HEADER_STRING;
import static com.myteacher.Teacher.com.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders="*")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/persist-login", method = RequestMethod.GET)
    public ResponseEntity<String> handle(@CookieValue("userToken") String userToken){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HEADER_STRING, TOKEN_PREFIX + userToken);
        return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
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
