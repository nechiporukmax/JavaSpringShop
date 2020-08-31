package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String Name;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Product> Products = new ArrayList<>();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


}
