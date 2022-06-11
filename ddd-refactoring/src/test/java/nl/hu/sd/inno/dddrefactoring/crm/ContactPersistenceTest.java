package nl.hu.sd.inno.dddrefactoring.crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContactPersistenceTest {

    @Autowired
    private EntityManager entities;

    private Contact c;

    @BeforeEach
    public void setup(){
        c = new Contact();
        c.setCity("Utrecht");
        c.setHouseNumber("42B");
        c.setFirstName("Test");
    }

    @Test
    public void canPersistContact() {
        this.entities.persist(c);
        this.entities.flush();
        this.entities.clear();

        assertEquals(c, this.entities.find(Contact.class, c.getId()));
    }
}
