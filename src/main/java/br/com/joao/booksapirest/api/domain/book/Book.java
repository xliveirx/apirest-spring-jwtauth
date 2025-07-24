package br.com.joao.booksapirest.api.domain.book;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer totalPages;
    @Enumerated(EnumType.STRING)
    private Status status;
}
