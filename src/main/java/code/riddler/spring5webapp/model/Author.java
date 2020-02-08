package code.riddler.spring5webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by: CodeRiddler
 */

@Entity
public class Author{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastname;

    @ManyToMany (mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Author(){

    }

    public Author(String firstname, String lastname){
        this.firstName = firstname;
        this.lastname = lastname;
    }

    public Author(String firstname, String lastname, Set<Book> books){
        this.firstName = firstname;
        this.lastname = lastname;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author)) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", books='" + getBooks() + "'" +
            "}";
    }

}