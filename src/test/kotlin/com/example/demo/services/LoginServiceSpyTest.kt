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

import com.example.demo.LoginRepository
import com.example.demo.LoginService
import com.example.demo.UserForm
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class LoginServiceSpyTest {

    @InjectMocks
    lateinit var loginService: LoginService

    @Spy
    lateinit var loginRepository: LoginRepository

    var userOk = UserForm("user1", "p1")
    var userKo = UserForm("foo", "bar")

    @Test
    fun testLoginOk() {
        assertTrue(loginService.login(userOk))
    }

    @Test
    fun testLoginKo() {
        assertFalse(loginService.login(userKo))
    }

}
