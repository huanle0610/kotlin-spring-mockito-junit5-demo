package com.example.demo.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import org.mockito.Mockito.`when` as mockWhen

@ExtendWith(MockitoExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceMockTest {
    @Mock
    private lateinit var mockUserService: UserService

    @Test
    fun testNameMock() {
        given(mockUserService.getUser("amtf1")).willReturn("amtf-by-mock")
        val name = mockUserService.getUser("amtf1")
        Assertions.assertEquals("amtf-by-mock", name)

        val age = mockUserService.getUserAge("amtf")
        Assertions.assertEquals(0, age)

        mockWhen(mockUserService.getUserAge()).thenCallRealMethod()
        Assertions.assertEquals(13, mockUserService.getUserAge())
    }

    @Test
    fun localMock() {
        val localMockUserService = Mockito.mock(UserService::class.java)
        mockWhen(localMockUserService.getUser("amtf1")).thenReturn("1111")

        val userCount = localMockUserService.getUser("amtf1")

        Assertions.assertEquals("1111", userCount)
        Mockito.verify<UserService>(localMockUserService).getUser("amtf1")

        Assertions.assertEquals("1111", localMockUserService.getUser("amtf1"))
        Assertions.assertEquals(0, localMockUserService.getUserAge("amtf1"))

        mockWhen(localMockUserService.getUserAge(MockitoHelper.any())).thenCallRealMethod()
        Assertions.assertEquals(12, localMockUserService.getUserAge("test1"))

        mockWhen(localMockUserService.getUserAge()).thenCallRealMethod()
        Assertions.assertEquals(13, localMockUserService.getUserAge())


        Mockito.verify<UserService>(localMockUserService, Mockito.times(2)).getUser("amtf1")
    }
}
