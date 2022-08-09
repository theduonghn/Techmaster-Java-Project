package vn.techmaster.bookonline.entitiy;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
Create this entity to add column `quantity`.
Many to many with additional column
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Setter(AccessLevel.NONE)
    @Column(name = "quantity", nullable = false, updatable = false)
    private Integer quantity;

}