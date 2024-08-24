package com.github.lzpdark.indexdoc.domain.crawler.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lzpdark.indexdoc.entity.ResourceTask;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * @author lzp
 */
public class ResourceTaskDeserializer extends JsonDeserializer<ResourceTask> {
    public ResourceTaskDeserializer() {
        super(custom());
    }

    private static ObjectMapper custom() {
        return new ObjectMapper();
    }
}
