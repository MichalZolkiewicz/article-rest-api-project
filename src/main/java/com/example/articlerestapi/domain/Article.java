package com.example.articlerestapi.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Article {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "ARTICLE_TITLE")
    private String articleTitle;

    @Column(name = "ARTICLE_CONTENT")
    private String articleContent;

    @Column(name = "DATE_OF_PUBLICATION")
    private LocalDate dateOfPublication;

    @Column(name = "MAGAZINE_NAME")
    private String magazineName;

    @Column(name = "AUTHOR")
    private String authorFirstAndLastName;

    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;

    public Article(Long id, LocalDate dateOfPublication, String magazineName, Timestamp timestamp) {
        this.id = id;
        this.dateOfPublication = dateOfPublication;
        this.magazineName = magazineName;
        this.timestamp = timestamp;
    }
}
