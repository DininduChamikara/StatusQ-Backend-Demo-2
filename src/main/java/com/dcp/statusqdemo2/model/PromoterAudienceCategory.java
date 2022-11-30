package com.dcp.statusqdemo2.model;

import com.dcp.statusqdemo2.model.Promoter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class PromoterAudienceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @ManyToOne
    @JoinColumn(name="promoterId", referencedColumnName = "promoterId")
    @JsonManagedReference
    private Promoter promoterPromoterAudienceCategory;

    private String platform;
    private String categoryType;
    private String category;
    private int count;
}
