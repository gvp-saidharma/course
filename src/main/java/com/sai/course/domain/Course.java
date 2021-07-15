package com.sai.course.domain;

import javax.persistence.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "unique auto increment course id")
    private Integer id;

    @NotBlank
    @Size(max = 500)
    @ApiModelProperty(notes = "unique course name")
    private String courseName;

    @NotBlank
    @Size(max = 500)
    private Integer price;

    @NotBlank
    @Size(max = 500)
    private String createdBy;

    @NotBlank
    @Size(max = 500)
    private String description;

    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate = new Date();

    @PreUpdate
    public void setLastModifiedDate() {
        this.lastModifiedDate= new Date();
    }

}