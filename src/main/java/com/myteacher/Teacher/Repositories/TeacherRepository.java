package com.myteacher.Teacher.Repositories;

import com.myteacher.Teacher.Models.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Teacher findBy_id(ObjectId id);

}