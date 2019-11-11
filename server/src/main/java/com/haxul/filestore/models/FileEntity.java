package com.haxul.filestore.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "files", uniqueConstraints = {@UniqueConstraint(columnNames = {"path"})})
public class FileEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(nullable = false, unique = true)
    @NotNull
    private String path;

    @Column
    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(columnDefinition = "boolean default false")
    private boolean isFavorites;

    @ManyToOne
    private UserEntity userEntity;

    public FileEntity() {}

    public FileEntity(String title, String path, boolean isFavorites, UserEntity userEntity) {
        this.title = title;
        this.path = path;
        this.isFavorites = isFavorites;
        this.userEntity = userEntity;
    }

    public FileEntity(String title, String path, UserEntity userEntity) {
        this.title = title;
        this.path = path;
        this.userEntity = userEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
