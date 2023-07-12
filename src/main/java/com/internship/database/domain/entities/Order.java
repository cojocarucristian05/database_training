package com.internship.database.domain.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_receive")
    private Boolean paymentReceive;

    @Column(name = "status")
    private String status;

    @Column(name = "value")
    private Double value;

    @ManyToMany
    private List<Product> products;
}
