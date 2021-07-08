package com.ibm.expiryclient.web.client;


import com.ibm.expiryclient.model.ExpiryRequest;
import com.ibm.expiryclient.model.ExpiryResponse;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix = "expirydate", ignoreUnknownFields = true)
@Component
public class ExpiryClient {


    String API_PATH = "/DecisionService/rest/FiservPoC/ExpiryDateCalc";
    private String apihost;
    private final RestTemplate restTemplate;
    private String password = "";
    private String username = "";


    public ExpiryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.basicAuthentication(username, password).build();
    }

    public ExpiryResponse getExpiryDate(ExpiryRequest request){

        return restTemplate.postForObject(apihost + API_PATH, request, ExpiryResponse.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
