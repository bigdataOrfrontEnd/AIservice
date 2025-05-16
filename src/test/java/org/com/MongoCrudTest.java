package org.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class MongoCrudTest {
@Autowired
    private MongoTemplate mongoTemplate;
}
