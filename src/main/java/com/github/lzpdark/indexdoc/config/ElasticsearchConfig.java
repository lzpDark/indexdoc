package com.github.lzpdark.indexdoc.config;

import org.apache.http.conn.ssl.TrustStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * @author lzp
 */
@Configuration
public class ElasticsearchConfig extends  ElasticsearchConfiguration{

    // https://medium.com/@reachansari/how-to-avoid-ssl-validation-in-spring-boot-resttemplate-3876a7fc2c4a
    @Override
    public ClientConfiguration clientConfiguration() {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }

        return ClientConfiguration.builder()
                .connectedTo("es01:9200")
                .usingSsl(sslContext)
                .withBasicAuth("elastic", "123456")
                .build();
    }
}
