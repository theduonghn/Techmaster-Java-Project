package vn.techmaster.bookonline.model;

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
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "published_year")
    private Integer year;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Price> prices = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Category> categories = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "publishing_company_id")
    private PublishingCompany publishingCompany;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToMany(mappedBy = "books")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> images = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBooks = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}