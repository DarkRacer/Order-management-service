package ru.neoflex.ec.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private Long orderNumber;

    @Column
    private Date orderDate;

    @Column
    private Long customerId;

    @Column
    private Long productId;

    @Column
    private String productName;

    @Column
    private double price;

    @Column
    private int count;

    @Column
    private double sum;
}
