package com.ibm.expiryclient.web.client;


import com.ibm.expiryclient.model.ExpiryRequest;
import com.ibm.expiryclient.model.ExpiryResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


@ConfigurationProperties(prefix = "expirydate", ignoreUnknownFields = true)
@Component
public class ExpiryClient {

    private RestTemplate restTemplate;
    String API_PATH = "/DecisionService/rest/FiservPoC/ExpiryDateCalc";

//    @Value("${expirydate.apihost}")
    private String apihost;
    private String password = "";
    private String username = "";

    public ExpiryClient(){

    }

    @PostConstruct
    private void configure() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
        {
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
            {
                return true;
            }
        }).build();


        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(username, password);
        provider.setCredentials(AuthScope.ANY, credentials);

        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .setSslcontext(sslContext)
                .setDefaultCredentialsProvider(provider)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        this.restTemplate = new RestTemplate(requestFactory);
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
