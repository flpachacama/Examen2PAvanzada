package ec.edu.espe.Examen.service;

import ec.edu.espe.Examen.entity.BookEntity;
import ec.edu.espe.Examen.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookEntity> findById(int id) {
        return bookRepository.findById(id);
    }

    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
