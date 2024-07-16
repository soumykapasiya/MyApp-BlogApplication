package com.kapasiya.blogapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String author;

    @Column(length = 2255)
    private String content;

    private String topic;

    public Blog()
    {

    }

    public Blog(long id, String title, String author, String content, String topic) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}