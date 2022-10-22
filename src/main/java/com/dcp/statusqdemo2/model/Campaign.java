package com.dcp.statusqdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Campaign {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaignId;
    private String platform;
    private int numberOfViews;
    private int viewsFromEachPromoter;
    private String paymentState;
    private String state;

    @OneToMany(mappedBy = "campaignEducationAudience")
    private Set<EducationAudience> educationAudiences;

}
