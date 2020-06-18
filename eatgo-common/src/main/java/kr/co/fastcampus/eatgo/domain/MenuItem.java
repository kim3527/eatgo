package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"restaurant"})
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long menuItemRestaurantId;

    private String name;

    @Transient
    private boolean destroy;

    @JsonBackReference
    @ManyToOne
    private Restaurant restaurant;
}
