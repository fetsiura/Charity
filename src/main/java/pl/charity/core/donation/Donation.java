package pl.charity.core.donation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.charity.core.category.Category;
import pl.charity.core.institution.Institution;
import pl.charity.core.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@Table(name = "Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="category_id")
    private Set<Category> categories;
//
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    private boolean delivered;
    private LocalDateTime createTime;


}
