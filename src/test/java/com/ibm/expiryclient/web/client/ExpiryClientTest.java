package com.ibm.expiryclient.web.client;

import com.ibm.expiryclient.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExpiryClientTest {

    @Autowired
    ExpiryClient expiryClient;

    @Test
    void testSomething() throws ParseException {

        String dobStr="14/09/2005";
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobStr);

        String currentDateStr ="16/06/2021";
        Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(currentDateStr);

        ProductFeatures features = ProductFeatures.builder()
                .cardExpiryTerm(36)
                .authorisationDailyLimit(1500)
                .build();

        Product product = Product.builder()
                .productID("101")
                .productName("SomeCard")
                .businessUnitLocation("UK")
                .ageRestrictionActive(true)
                .ageRestrictionThreshold(12)
                .ageRestrictionLimit(18)
                .build();

        Party party = Party.builder()
                .dateOfBirth(dob)
                .nationality("UK")
                .build();

        ExpiryRequest request = ExpiryRequest.builder()
                .__DecisionID__("Happy")
                .currentDate(currentDate)
                .productFeatures(features)
                .product(product)
                .party(party)
                .build();

        ExpiryResponse response = expiryClient.getExpiryDate(request);
        assertNotNull(response);

        System.out.println(response);

    }


}