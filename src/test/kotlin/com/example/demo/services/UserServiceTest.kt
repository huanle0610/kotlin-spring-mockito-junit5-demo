package com.example.demo.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun testName() {
        val name = userService.getUser("amtf1")
        Assertions.assertEquals("amtf", name)
    }
}
