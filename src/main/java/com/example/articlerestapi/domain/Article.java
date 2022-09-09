package com.example.articlerestapi.domain;

import com.sun.istack.NotNull;
import lombok.*;

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
    private Long id;
    private String articleTitle;
    private String articleContent;
    private LocalDate dateOfPublication;
    private String magazineName;
    private String authorFirstAndLastName;
    private Timestamp timestamp;

    public Article(Long id, LocalDate dateOfPublication, String magazineName, Timestamp timestamp) {
        this.id = id;
        this.dateOfPublication = dateOfPublication;
        this.magazineName = magazineName;
        this.timestamp = timestamp;
    }
}
