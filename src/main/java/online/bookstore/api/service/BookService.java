package online.bookstore.api.service;

import online.bookstore.api.domain.author.AuthorRepository;
import online.bookstore.api.domain.book.BookRepository;
import online.bookstore.api.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
    }
}
