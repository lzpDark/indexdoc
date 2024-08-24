package com.github.lzpdark.indexdoc.entity;

/**
 * @author lzp
 */
public enum TaskStateEnum {

    NOT_STARTED("NOT_STARTED"),
    IN_PROGRESS("IN_PROGRESS"),
    FINISHED("FINISHED"),
    ERROR("ERROR")
    ;

    private final String name;

    TaskStateEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
