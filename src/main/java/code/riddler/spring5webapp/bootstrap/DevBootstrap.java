package code.riddler.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import code.riddler.spring5webapp.model.Author;
import code.riddler.spring5webapp.model.Book;
import code.riddler.spring5webapp.model.Publisher;
import code.riddler.spring5webapp.repositories.AuthorRepository;
import code.riddler.spring5webapp.repositories.BookRepository;
import code.riddler.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Publisher harperCollins = new Publisher();
        harperCollins.setName("Harper Collins");
        publisherRepository.save(harperCollins);

        Publisher worx = new Publisher();
        worx.setName("Worx");
        publisherRepository.save(worx);

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE DEvelopment without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}