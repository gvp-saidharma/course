package com.sai.course.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank @Size(max = 500)
    private String courseName;

    @NotBlank @Size(max = 500)
    private String cardNo;

    @NotBlank @Size(max = 500)
    private String cvv;

    @NotBlank @Size(max = 500)
    private String date;

    @NotBlank @Size(max = 500)
    private Integer price;

    @NotBlank @Size(max = 500)
    private String createdBy;

    @Basic(optional = false) @CreationTimestamp @Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @UpdateTimestamp @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate = new Date();

    @PreUpdate
    public void setLastModifiedDate() {
        this.lastModifiedDate= new Date();
    }

}