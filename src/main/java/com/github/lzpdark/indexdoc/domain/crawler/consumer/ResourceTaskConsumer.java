package com.github.lzpdark.indexdoc.domain.crawler.consumer;

import com.github.lzpdark.indexdoc.domain.crawler.service.Crawler;
import com.github.lzpdark.indexdoc.domain.crawler.service.Indexer;
import com.github.lzpdark.indexdoc.entity.ResourceTask;
import com.github.lzpdark.indexdoc.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * @author lzp
 */
@Component
@Slf4j
public class ResourceTaskConsumer {

    @Autowired
    private Crawler crawler;

    @Autowired
    private Indexer indexer;

    @KafkaListener(
            id = Constants.CONSUMER_ID_CRAWLER,
            topics = Constants.TOPIC_RESOURCE_TASK
    )
    public void listen(ResourceTask task, Acknowledgment acknowledgment) {
        log.info("received event: {}", task.toString());
        String url = task.getUrl();
        String content;
        try {
            content = crawler.fetch(url);
        } catch (Exception e) {
            log.error("crawler url failed, url:{}", url, e);
            acknowledgment.acknowledge();
            return;
        }
        indexer.indexContent(url, content);
        acknowledgment.acknowledge();
        log.info("event ack");
    }
}
