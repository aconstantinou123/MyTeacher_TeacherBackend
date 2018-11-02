package com.myteacher.Teacher.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Teacher {

    @Id
    public ObjectId _id;
    public String firstName;
    public String lastName;
    public String email;

    public Teacher() {}

    public Teacher(ObjectId _id, String firstName, String lastName, String email){
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

