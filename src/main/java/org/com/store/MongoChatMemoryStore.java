package org.com.store;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.com.bean.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId){
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query=new Query(criteria);
        ChatMessages chatMessages = mongoTemplate.findOne(query, ChatMessages.class);
        if (chatMessages == null) {
            return new LinkedList<>();
        }
        String contentJson = chatMessages.getContent();
        return ChatMessageDeserializer.messagesFromJson(contentJson);
    }
    @Override
    public void updateMessages(Object o, List<ChatMessage> list) {

    }

    @Override
    public void deleteMessages(Object o) {

    }
}
