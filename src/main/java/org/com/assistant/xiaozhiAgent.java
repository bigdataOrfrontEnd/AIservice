package org.com.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "OllamaChatModel",
        chatMemoryProvider = ""
)
public interface xiaozhiAgent {
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}
