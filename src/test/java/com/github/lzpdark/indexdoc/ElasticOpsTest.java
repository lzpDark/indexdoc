package com.github.lzpdark.indexdoc;

import com.github.lzpdark.indexdoc.domain.search.entity.ResourceDoc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

/**
 * @author lzp
 */
@SpringBootTest
public class ElasticOpsTest {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Test
    public void test() {
        ResourceDoc resourceDoc = new ResourceDoc();
        resourceDoc.setUrl("https://github.com/lzpdark");
        resourceDoc.setContent("<p>hahahahahh lzdpark empty</p>");
        elasticsearchOperations.save(resourceDoc);
    }
}
