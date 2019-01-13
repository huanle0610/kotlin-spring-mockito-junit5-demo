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
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LoginControllerErrorTest {

    @InjectMocks
    lateinit var loginController: LoginController

    @Mock
    lateinit var loginService: LoginService

    var userForm = UserForm("foo", "bar")

    @Test
    fun testLoginError() {
        // Exercise
        val response = loginController.login(null)

        // Verify
        assertEquals("ERROR", response)
    }

    @Test
    fun testLoginException() {
        // Expectation
        `when`(loginService.login(MockitoHelper.any()))
                .thenThrow(IllegalArgumentException::class.java)

        // Exercise
        val response = loginController.login(userForm)

        // Verify
        assertEquals("ERROR", response)
    }

}