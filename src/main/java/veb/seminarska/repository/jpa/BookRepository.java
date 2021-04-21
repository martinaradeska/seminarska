package veb.seminarska.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import veb.seminarska.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    void deleteByTitle(String title);

    Optional<Book> findByTitle(String title);
}