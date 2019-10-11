package sara.springFramework.springWepApp.repository;

import org.springframework.data.repository.CrudRepository;
import sara.springFramework.springWepApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
