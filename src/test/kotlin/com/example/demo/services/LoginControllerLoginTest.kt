/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.demo.services

import com.example.demo.LoginController
import com.example.demo.LoginService
import com.example.demo.UserForm
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LoginControllerLoginTest {

    // Mocking objects
    @InjectMocks
    lateinit var loginController: LoginController

    @Mock
    lateinit var loginService: LoginService

    // Test data
    var userForm = UserForm("foo", "bar")

    @Test
    fun testLoginOk() {
        // Setting expectations (stubbing methods)
        `when`(loginService.login(userForm)).thenReturn(true)

        // Exercise SUT
        val reseponseLogin = loginController.login(userForm)

        // Verification
        assertEquals("OK", reseponseLogin)
        verify<LoginService>(loginService).login(userForm)
        verifyNoMoreInteractions(loginService)
    }

    @Test
    fun testLoginKo() {
        // Setting expectations (stubbing methods)
        `when`(loginService.login(userForm)).thenReturn(false)

        // Exercise SUT
        val responseLogin = loginController.login(userForm)

        // Verification
        assertEquals("KO", responseLogin)
        verify<LoginService>(loginService).login(userForm)
        verifyZeroInteractions(loginService)
    }

}
