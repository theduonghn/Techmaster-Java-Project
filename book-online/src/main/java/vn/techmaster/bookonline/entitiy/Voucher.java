package vn.techmaster.bookonline.entitiy;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "percent", nullable = false, updatable = false)
    private String percent;

    @Column(name = "min_price", nullable = false, updatable = false)
    private Long minPrice;

    @Column(name = "start_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "end_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "voucher_user", joinColumns = @JoinColumn(name = "voucher_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "vouchers")
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Voucher voucher = (Voucher) o;
        return id != null && Objects.equals(id, voucher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}