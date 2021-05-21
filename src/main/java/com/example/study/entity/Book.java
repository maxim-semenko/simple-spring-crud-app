package com.example.study.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Book.
 */
@Builder(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Author should not be empty")
    @Size(min = 2, max = 40, message = "Author should be between 2 and 30 characters")
    private String author;

    @NotNull(message = "Author should not be empty")
    @Size(min = 2, max = 50, message = "Author should be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Pages should not be empty")
    @Min(value = 0, message="Pages should be greater than 1")
    private Integer pages;
}
