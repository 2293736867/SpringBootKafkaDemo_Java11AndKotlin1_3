package com.test

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestApplicationTests {

    @Autowired
    private val producer:Producer? = null

    @Test
    fun contextLoads() {
        for(i in 0..1000)
        {
            val id = (i + 1).toLong()
            val name = java.util.UUID.randomUUID().toString()
            val num = (0..100000).random()
            producer!!.send(Entity(id,name,num))
        }
    }
}
