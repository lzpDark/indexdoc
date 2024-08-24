package com.github.lzpdark.indexdoc.domain.manage.web;

import com.github.lzpdark.indexdoc.domain.manage.dto.NewResourceResponse;
import com.github.lzpdark.indexdoc.domain.manage.dto.NewUrlRequest;
import com.github.lzpdark.indexdoc.domain.manage.service.KeyGenerator;
import com.github.lzpdark.indexdoc.entity.ResourceTask;
import com.github.lzpdark.indexdoc.entity.TaskStateEnum;
import com.github.lzpdark.indexdoc.mapper.ResourceTaskMapper;
import com.github.lzpdark.indexdoc.mapper.TaskStateMapper;
import com.github.lzpdark.indexdoc.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * @author lzp
 */
@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceTaskMapper resourceTaskMapper;
    @Autowired
    private TaskStateMapper taskStateMapper;
    @Autowired
    private KafkaTemplate<Integer, ResourceTask> template;

    @PostMapping("")
    public Object addResource(@RequestBody NewUrlRequest request) {
        if(!isUrlValid(request.getUrl())) {
            throw new RuntimeException("invalid url");
        }
        ResourceTask task = new ResourceTask();
        long id = KeyGenerator.getNext();
        task.setId(id);
        task.setTaskState(taskStateMapper.getIdFromName(TaskStateEnum.NOT_STARTED.getName()));
        task.setUrl(request.getUrl());
        task.setLanguage(request.getLanguage());
        try {
            if (resourceTaskMapper.addResourceTask(task) < 1) {
                throw new RuntimeException("affect 0 rows.");
            }
        } catch (Exception e) {
            log.error("add resource failed.", e);
            throw new RuntimeException("add failed");
        }

        // notify
        template.send(Constants.TOPIC_RESOURCE_TASK, task);
        return new NewResourceResponse(id);
    }

    private boolean isUrlValid(String url) {
        if(StringUtils.isEmpty(url)) {
            return false;
        }
        return url.startsWith("http://") || url.startsWith("https://");
    }

    @GetMapping("")
    public Object listResources() {
        return resourceTaskMapper.listResources();
    }

    @DeleteMapping("{id}")
    public Object deleteResource(@PathVariable("id") Long id) {
        return resourceTaskMapper.deleteById(id);
    }

}
