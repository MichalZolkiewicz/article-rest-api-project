package com.example.articlerestapi.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

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
    private Date dateOfPublication;
    private String magazineName;
    private String authorFirstAndLastName;
    private Timestamp timestamp;

    public Article(Long id, Date dateOfPublication, String magazineName, Timestamp timestamp) {
        this.id = id;
        this.dateOfPublication = dateOfPublication;
        this.magazineName = magazineName;
        this.timestamp = timestamp;
    }
}
