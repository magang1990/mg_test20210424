package com.mg.json;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.List;

/**
 * @author mg
 * @date 2024-08-29
 */
public class Test01 {
    public static void main(String[] args) {
        KafkaEvent<List<User>> event = new KafkaEvent<>(
                "test",
                CollectionUtil.newArrayList(new User("mg",1),
                        new User("ml",2)));
        KafkaEvent<String> parseObject = JSON.parseObject(JSON.toJSONString(event), new TypeReference<KafkaEvent<String>>() {
        });
        String body = parseObject.getBody();
        List<User> lists = JSON.parseArray(body, User.class);

    }
}

class KafkaEvent<T> {

    private String eventType;

    private T body;

    public KafkaEvent() {
    }

    public KafkaEvent(String eventType, T body) {
        this.eventType = eventType;
        this.body = body;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
