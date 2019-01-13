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

import com.example.demo.LoginException
import com.example.demo.LoginRepository
import com.example.demo.LoginService
import com.example.demo.UserForm
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LoginServiceTest {

    @InjectMocks
    lateinit var loginService: LoginService

    @Mock
    lateinit var loginRepository: LoginRepository

    var userForm = UserForm("foo", "bar")

    @Test
    fun testLoginOk() {
        `when`(loginRepository.login(MockitoHelper.any())).thenReturn(true)
        assertTrue(loginService.login(userForm))
        verify<LoginRepository>(loginRepository, atLeast(1)).login(userForm)
    }

    @Test
    fun testLoginKo() {
        `when`(loginRepository.login(MockitoHelper.any())).thenReturn(false)
        assertFalse(loginService.login(userForm))
        verify<LoginRepository>(loginRepository, times(1)).login(userForm)
    }

    @Test
    fun testLoginTwice() {
        `when`(loginRepository.login(userForm)).thenReturn(true)
        assertThrows(LoginException::class.java) {
            loginService.login(userForm)
            loginService.login(userForm)
        }
    }

}