package com.workshopMongoDB.domain.entities.post;

import java.time.Instant;

public class PostOutput {

    private String id;
    private Instant instant;

    private String title;

    private String body;

    public PostOutput() {
    }

    public PostOutput(String id, Instant instant, String title, String body) {
        this.id = id;
        this.instant = instant;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
