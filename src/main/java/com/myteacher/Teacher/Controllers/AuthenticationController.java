package com.myteacher.Teacher.Controllers;

import com.myteacher.Teacher.Models.Teacher;
import com.myteacher.Teacher.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders="*")
public class AuthenticationController {

    private TeacherRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthenticationController(TeacherRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody Teacher teacher) {
        teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
        repository.save(teacher);
    }

}

