package br.com.joao.booksapirest.api.repository;

import br.com.joao.booksapirest.api.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
