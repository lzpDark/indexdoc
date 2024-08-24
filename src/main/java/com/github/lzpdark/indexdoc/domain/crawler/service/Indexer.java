package com.github.lzpdark.indexdoc.domain.crawler.service;

import com.github.lzpdark.indexdoc.domain.search.entity.ResourceDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

/**
 * @author lzp
 */
@Component
public class Indexer {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public void indexContent(String url, String content) {
        ResourceDoc resourceDoc = new ResourceDoc();
        resourceDoc.setUrl(url);
        resourceDoc.setContent(content);
        elasticsearchOperations.save(resourceDoc);
    }
}
