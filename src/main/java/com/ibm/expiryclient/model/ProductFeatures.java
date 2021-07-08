package com.ibm.expiryclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductFeatures {
    private int cardExpiryTerm;
    private int authorisationDailyLimit;
}
