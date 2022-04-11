package pl.charity.core.category;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
