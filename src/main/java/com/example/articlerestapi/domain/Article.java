package com.example.articlerestapi.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TABLE")
public class Article {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
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
