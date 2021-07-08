package com.ibm.expiryclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpiryRequest {
    private ProductFeatures productFeatures;
    private Product product;
    private String __DecisionID__;
    private Party party;
    private Date currentDate;
}
