package vn.techmaster.bookonline.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Enumerated
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(name = "year_of_death")
    private Integer yearOfDeath;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new LinkedHashSet<>();
}