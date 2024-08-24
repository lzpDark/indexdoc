package com.github.lzpdark.indexdoc.mapper;

import com.github.lzpdark.indexdoc.entity.ResourceTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lzp
 */
@Mapper
public interface ResourceTaskMapper {

    int addResourceTask(ResourceTask resourceTask);

    List<ResourceTask> listResources();

    int deleteById(long id);
}
