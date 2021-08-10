package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double currentprice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    //Transient entity fields are fields that do not participate in persistence
    // and their values are never stored in the database (similar to transient fields in
    // Java that do not participate in serialization).
    // Static and final entity fields are always considered to be transient.
    @Transient
    private int quantity=1;
    @ManyToOne
    private Category category;

}
