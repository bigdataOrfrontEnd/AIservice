package org.com;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.com.assistant.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class AIServiceTest {
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllama() {
        //创建AIService
        Assistant assistant = AiServices.create(Assistant.class, ollamaChatModel);
        //调用service的接口
        String answer = assistant.chat("java");
        //输出结果
        System.out.println(answer);
    }
}
