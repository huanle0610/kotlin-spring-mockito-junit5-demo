package com.example.demo.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@ExtendWith(MockitoExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceMockBeanTest {
    @MockBean
    private lateinit var mockUserService: UserService

    @Test
    fun testNameMock() {
        given(mockUserService.getUser("amtf1")).willReturn("amtf-by-mock")
        val name = mockUserService.getUser("amtf1")
        Assertions.assertEquals("amtf-by-mock", name)

        val age = mockUserService.getUserAge("amtf")
        Assertions.assertEquals(0, age)
    }
}
