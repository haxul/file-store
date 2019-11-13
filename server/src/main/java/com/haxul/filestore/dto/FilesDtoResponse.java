package com.haxul.filestore.dto;

import java.util.Date;

public class FilesDtoResponse {

    private int id;
    private String title;
    private String path;
    private Date created;
    private boolean isFavorites;

    public FilesDtoResponse(int id, String title, String path, Date created, boolean isFavorites) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.created = created;
        this.isFavorites = isFavorites;
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
}
