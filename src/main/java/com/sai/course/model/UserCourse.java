package com.sai.course.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCourse {
    private String courseName;
    private String createdBy;
    private String description;

    public UserCourse(String courseName, String createdBy,String description) {
        this.courseName = courseName;
        this.createdBy = createdBy;
        this.description = description;
    }
}
