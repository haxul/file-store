package com.haxul.filestore.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;

public class PutRequestDto {

    @Size(max = 250)
    private String title;

    private Boolean isPopular;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsPopular() {
        return isPopular;
    }

    public void setPopular(Boolean popular) {
        isPopular = popular;
    }
}
