package vn.techmaster.bookonline.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(mappedBy = "shop")
    private Set<Book> books = new LinkedHashSet<>();

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Enumerated
    @Column(name = "status", nullable = false)
    private Status status;

    @OneToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private User owner;

}