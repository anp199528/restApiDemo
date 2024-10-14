package com.example.restapidemo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "crudoperation")
public class CrudOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String className;  // 'class' is a reserved word in Java, so we use 'className' instead
    @Setter
    @Getter
    private Integer marks;
    @Setter
    @Getter
    private Integer year;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

