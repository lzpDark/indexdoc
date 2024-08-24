package com.github.lzpdark.indexdoc.config;

import com.github.lzpdark.indexdoc.domain.crawler.service.Crawler;
import com.github.lzpdark.indexdoc.domain.crawler.service.RestCrawler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzp
 */
@Configuration
public class CrawlerConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Crawler crawler() {
        return new RestCrawler(restTemplate());
    }
}
