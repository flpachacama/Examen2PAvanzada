package ec.edu.espe.Examen.repository;

import ec.edu.espe.Examen.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
