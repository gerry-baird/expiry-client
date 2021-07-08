package com.ibm.expiryclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String productID;
    private String productName;
    private String businessUnitLocation;
    private boolean ageRestrictionActive;
    private int ageRestrictionLimit;
    private int ageRestrictionThreshold;
}
