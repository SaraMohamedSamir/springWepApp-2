package sara.springFramework.springWepApp.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @OneToOne(mappedBy = "publisher")
  private Book book;

  public Publisher() {
  }

  public Publisher(String name) {
    this.name = name;
  }

  public Publisher(String name, Book book) {
    this.name = name;
    this.book = book;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Publisher)) return false;
    Publisher publisher = (Publisher) o;
    return Objects.equals(getId(), publisher.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Publisher{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", book=" + book +
        '}';
  }
}
