package nl.hu.inno.clouddeploy.monolith;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Protester {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Protester(){}
    public Protester(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void update(String name) {
        this.name = name;
    }
}
