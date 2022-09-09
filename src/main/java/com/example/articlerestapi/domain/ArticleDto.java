package com.example.articlerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Long userId;
    private LocalDate dateOfPublication;
    private String magazineName;
    private Timestamp timestamp;
}
