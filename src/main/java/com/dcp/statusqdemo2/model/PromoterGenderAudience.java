package com.dcp.statusqdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterGenderAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @ManyToOne
    @JoinColumn(name="promoterId", referencedColumnName = "promoterId")
    private Promoter promoterPromoterGenderAudience;

    private String platform;
    private int malePercentage;
    private int femalePercentage;
}
