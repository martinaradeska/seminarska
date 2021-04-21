package veb.seminarska.service.impl;

import org.springframework.stereotype.Service;
import veb.seminarska.model.Book;
import veb.seminarska.model.Category;
import veb.seminarska.model.Publisher;
import veb.seminarska.model.exceptions.CategoryNotFoundException;
import veb.seminarska.model.exceptions.PublisherNotFoundException;
import veb.seminarska.repository.jpa.BookRepository;
import veb.seminarska.repository.jpa.CategoryRepository;
import veb.seminarska.repository.jpa.PublisherRepository;
import veb.seminarska.service.BookService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, PublisherRepository publisherRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public Optional<Book> save(String title, String authorName, Long categoryId, Long publisherId, String cover) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        Publisher publisher = this.publisherRepository.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException(publisherId));

        this.bookRepository.deleteByTitle(title);
        return Optional.of(this.bookRepository.save(new Book(title, authorName, category, publisher, cover)));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
