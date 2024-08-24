package com.github.lzpdark.indexdoc.domain.crawler.service;

import org.springframework.web.client.RestTemplate;

/**
 * @author lzp
 */
public class RestCrawler implements Crawler {

    private final RestTemplate restTemplate;

    public RestCrawler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetch(String url) {
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }
}
