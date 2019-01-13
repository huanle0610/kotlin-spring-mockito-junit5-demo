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
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LoginControllerBDDTest {

    @InjectMocks
    lateinit var loginController: LoginController

    @Mock
    lateinit var loginService: LoginService

    var userForm = UserForm("foo", "bar")

    @Test
    fun testLoginOk() {
        given(loginService.login(userForm)).willReturn(true)
        given(loginService.checkNothing()).willCallRealMethod()
        assertEquals("OK", loginController.login(userForm))
        loginService.checkNothing()
    }

    @Test
    fun testLoginKo() {
        given(loginService.login(userForm)).willReturn(false)
        assertEquals("KO", loginController.login(userForm))
    }

    @Test
    fun testLoginError() {
        assertEquals("ERROR", loginController.login(null))
    }

    @Test
    fun testLoginException() {
        given(loginService.login(MockitoHelper.any()))
                .willThrow(IllegalArgumentException::class.java)
        assertEquals("ERROR", loginController.login(userForm))
    }

}