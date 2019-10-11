package sara.springFramework.springWepApp.repository;

import org.springframework.data.repository.CrudRepository;
import sara.springFramework.springWepApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
