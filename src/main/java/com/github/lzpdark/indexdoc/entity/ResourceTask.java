package com.github.lzpdark.indexdoc.entity;

/**
 * @author lzp
 */
public class ResourceTask {
    private Long id;
    private Integer taskState; // not-start, in-progress, done, error
    private String url;
    private String language;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ResourceTask{" +
                "id=" + id +
                ", taskState=" + taskState +
                ", url='" + url + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
