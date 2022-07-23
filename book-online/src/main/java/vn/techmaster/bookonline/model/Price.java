package vn.techmaster.bookonline.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "start_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "end_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;
}