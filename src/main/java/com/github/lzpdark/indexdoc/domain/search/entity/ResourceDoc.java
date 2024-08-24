package com.github.lzpdark.indexdoc.domain.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * @author lzp
 */
@Data
@Document(indexName = "resource_doc", createIndex = true)
//@Setting(settingPath = "analyzer-html.json")
public class ResourceDoc {
    @Id
    private String url;

    @WriteOnlyProperty
    @Field(name = "content", type = FieldType.Text, analyzer = "html_analyzer")
    private String content;
}
