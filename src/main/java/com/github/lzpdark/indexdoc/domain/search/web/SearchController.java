package com.github.lzpdark.indexdoc.domain.search.web;

import com.github.lzpdark.indexdoc.domain.search.dto.ResourceResponse;
import com.github.lzpdark.indexdoc.domain.search.entity.ResourceDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.NoSuchIndexException;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lzp
 */
@RestController
@RequestMapping("/searches")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class SearchController {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @GetMapping("")
    public List<ResourceResponse> search(@RequestParam("q") String q) {
        Criteria criteria = new Criteria("content").contains(q);
        CriteriaQuery query = new CriteriaQuery(criteria);
        SearchHits<ResourceDoc> searchHits = null;
        try {
            searchHits = elasticsearchOperations.search(query, ResourceDoc.class);
        } catch (NoSuchIndexException e) {
            log.info("index not found");
            return List.of();
        }
        List<SearchHit<ResourceDoc>> hitList = searchHits.getSearchHits();
        return hitList.stream()
                .map(SearchHit::getContent)
                .map(s -> {
                    ResourceResponse resourceResponse = new ResourceResponse();
                    resourceResponse.setUrl(s.getUrl());
                    return resourceResponse;
                })
                .collect(Collectors.toList());
    }
}
