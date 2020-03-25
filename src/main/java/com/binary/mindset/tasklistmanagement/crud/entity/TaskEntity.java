package com.binary.mindset.tasklistmanagement.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
@Data
public class TaskEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
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
