package sara.springFramework.springWepApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String secondName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Author(){

  }

  public Author(String firstName, String secondName){
    this.firstName = firstName;
    this.secondName = secondName;
  }

  public Author(String firstName, String secondName, Set<Book> books){
    this.firstName = firstName;
    this.secondName = secondName;
    this.books = books;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
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
    if (!(o instanceof Author)) return false;
    Author author = (Author) o;
    return Objects.equals(getId(), author.getId());
  }

  @Override
  public int hashCode() {
    return
        Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", secondName='" + secondName + '\'' +
        ", books=" + books +
        '}';
  }
}
