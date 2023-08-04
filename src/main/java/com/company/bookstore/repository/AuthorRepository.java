package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> auth = new ArrayList<>();

    private void seedDataStore() {
        Author a1 = new Author();
        a1.setFirstName("John");
        a1.setLastName("Bobby");
        a1.setStreet("123 Lincoln");
        a1.setCity("Philly");
        a1.setState("Pennsylvania");
        a1.setId(1);
        this.auth.add(a1);
    }

    public default List<Author> getAuthors(){
        return this.auth;
    }
}
