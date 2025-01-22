package ec.edu.espe.Examen.controller;

import ec.edu.espe.Examen.entity.BookEntity;
import ec.edu.espe.Examen.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<BookEntity> findall(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> findById(@PathVariable int id){
        return bookService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public BookEntity save(@RequestBody BookEntity bookEntity){
        return bookService.save(bookEntity);
    }

    @PutMapping("/{id}")
    public Optional<ResponseEntity<BookEntity>> update(@PathVariable int id, @RequestBody BookEntity bookEntity){
        return Optional.of(bookService.findById(id).map(exist -> {
            bookEntity.setId(id);
            return ResponseEntity.ok(bookService.save(bookEntity));
        }).orElse(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(bookService.findById(id).isPresent()){
            bookService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
