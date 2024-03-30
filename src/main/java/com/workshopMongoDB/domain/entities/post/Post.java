package com.workshopMongoDB.domain.entities.post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Objects;

@Document
public class Post {

    @Id
    private String id;
    private Instant instant;

    private String title;

    private String body;

    public Post() {
    }

    public Post(String id, Instant instant, String title, String body) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(instant, post.instant) && Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instant, title);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", instant=" + instant +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
