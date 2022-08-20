package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity// DB가 해당객체를 인식가능
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Long getID() {
        return id;
    }

    public void patch(Article article) {
        if (article.title != null)
            this.title =article.title;
        if (article.content != null)
            this.content = article.content;
    }

}
