package veb.seminarska.service;

import veb.seminarska.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByTitle(String title);

    Optional<Book> save(String title, String authorName, Long category, Long publisher, String cover);

    void deleteById(Long id);
}
