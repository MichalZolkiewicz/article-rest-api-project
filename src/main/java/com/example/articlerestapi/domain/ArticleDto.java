package com.example.articlerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Long userId;
    private Date dateOfPublication;
    private String magazineName;
    private Timestamp timestamp;
}
