package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"restaurant"} )
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String writer;

    @NotNull
    private int score;

    @NotEmpty
    private String comment;

//    private Long restaurantId;

    @JsonBackReference
    @ManyToOne
    private Restaurant restaurant;
}
