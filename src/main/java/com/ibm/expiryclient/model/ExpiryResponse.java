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
public class ExpiryResponse {
    private String expiryDate;
    private String __DecisionID__;
    private Date currentDate;
    private Messages messages;
    private String expiryDateStr;
}
