package com.homeloan.homeloan.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

import java.io.Serializable;

@Builder
public class ErrorEvent implements Serializable {
    private String id;
    private HttpStatusCode code;
    private String description;
    private String created;
    private String source;

    public ErrorEvent(String id, HttpStatusCode code, String description, String created, String source) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.created = created;
        this.source = source;
    }
}
