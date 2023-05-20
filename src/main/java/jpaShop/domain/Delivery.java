package jpaShop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipCode;
    private DeliveryStatus status;

    // Order 와 Delivery 1대1 관계
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
