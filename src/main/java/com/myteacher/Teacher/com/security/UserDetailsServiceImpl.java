package com.myteacher.Teacher.com.security;

import com.myteacher.Teacher.Models.Teacher;
import com.myteacher.Teacher.Repositories.TeacherRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private TeacherRepository teacherRepository;

    public UserDetailsServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findByUsername(username);
        if (teacher == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(teacher.getUsername(), teacher.getPassword(), emptyList());
    }
}