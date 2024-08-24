package com.github.lzpdark.indexdoc.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lzp
 */
@Mapper
public interface TaskStateMapper {

    int getIdFromName(String name);

    String getNameFromId(int id);
}
