package com.kapasiya.blogapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogId;

    private String title;

    private String author;

    private String content;

    private String topic;

    public Blog()
    {

    }

    public Blog(long blogId, String title, String author, String content, String topic) {
        this.blogId = blogId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}