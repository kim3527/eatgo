package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"menuItemList","reviewList"} )
@Accessors(chain = true)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    private Long categoryId;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Review> reviewList;


    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<MenuItem> menuItemList;
}
