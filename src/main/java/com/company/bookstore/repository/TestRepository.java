package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRepository {

    List<Author> motor = new ArrayList<>();

    public TestRepository() {
        seedDataStore();
    }

    private void seedDataStore() {
        Author a1 = new Author();
        a1.setFirstName("John");
        a1.setLastName("Bobby");
        a1.setStreet("123 Lincoln");
        a1.setCity("Philly");
        a1.setState("Pennsylvania");
        a1.setId(1);
        this.motor.add(a1);
    }

    public Author getMotorcycleById(int id){
        for (Author m : this.motor) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }


}
