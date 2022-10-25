package com.dcp.statusqdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @OneToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User userReview;

    private int ratingCount;
    private Date date;
    private String description;
    private String state;
}
