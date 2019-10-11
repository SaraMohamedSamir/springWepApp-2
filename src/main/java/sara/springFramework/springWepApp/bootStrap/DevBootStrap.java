package sara.springFramework.springWepApp.bootStrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sara.springFramework.springWepApp.model.Author;
import sara.springFramework.springWepApp.model.Book;
import sara.springFramework.springWepApp.model.Publisher;
import sara.springFramework.springWepApp.repository.AuthorRepository;
import sara.springFramework.springWepApp.repository.BookRepository;
import sara.springFramework.springWepApp.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData(){

    //Eric
    Author eric = new Author("Eric", "Evans");
    Publisher publisherA = new Publisher("1234");
    Book  ddd = new Book("Domain Driven Design", publisherA,"Harper Collins");
    connectAndSaveData(eric, publisherA, ddd);

    //Rod
    Author rod = new Author("Rod", "Johnson");
    Publisher publisherB = new Publisher("23444");
    Book noEJB = new Book("J2EE Development without EJB", publisherB, "Wrox" );
    connectAndSaveData(rod, publisherB, noEJB);

  }

  private void connectAndSaveData(Author author, Publisher publisher, Book book) {
    author.getBooks().add(book);
    book.getAuthors().add(author);

    authorRepository.save(author);
    publisherRepository.save(publisher);
    bookRepository.save(book);
  }
}
