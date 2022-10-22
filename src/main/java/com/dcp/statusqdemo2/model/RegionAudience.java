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
public class RegionAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @ManyToOne
    @JoinColumn(name="campaignId", referencedColumnName = "campaignId")
    private Campaign campaignRegionAudience;

    private String region;
}
