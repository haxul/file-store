package com.haxul.filestore.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;

public class PutRequestDto {

    @Size(max = 250)
    private String title;

    private String isPopular;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopular() {
        return isPopular;
    }

    public void setPopular(String popular) {
        isPopular = popular;
    }
}
