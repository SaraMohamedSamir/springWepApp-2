package sara.springFramework.springWepApp.repository;

import org.springframework.data.repository.CrudRepository;
import sara.springFramework.springWepApp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
