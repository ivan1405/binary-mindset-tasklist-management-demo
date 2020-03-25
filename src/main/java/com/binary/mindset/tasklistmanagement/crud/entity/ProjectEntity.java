package com.binary.mindset.tasklistmanagement.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "projects")
@Data
public class ProjectEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "last_modified")
    private Timestamp lastModified;

    @PrePersist
    protected void onCreate() {
        createdOn = lastModified = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        lastModified = new Timestamp(System.currentTimeMillis());
    }
}
