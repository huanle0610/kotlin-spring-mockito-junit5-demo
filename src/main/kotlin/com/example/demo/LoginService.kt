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
package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("login service")
class LoginService {

    @Autowired
    private lateinit var loginRepository: LoginRepository
    private val usersLogged = ArrayList<String>()

    val userLoggedCount: Int
        get() = usersLogged.size

    fun login(userForm: UserForm): Boolean {
        println("LoginService.login $userForm")

        // Preconditions
        checkForm(userForm)

        // Same user cannot be logged twice
        val username = userForm.username
        if (usersLogged.contains(username)) {
            throw LoginException("$username already logged")
        }

        // Call to repository to make logic
        val login = loginRepository.login(userForm)
        if (login) {
            usersLogged.add(username)
        }
        return login
    }

    fun logout(userForm: UserForm) {
        println("LoginService.logout $userForm")

        // Preconditions
        checkForm(userForm)

        // Same user cannot be logged twice
        val username = userForm.username
        if (!usersLogged.contains(username)) {
            throw LoginException("$username not logged")
        }

        usersLogged.remove(username)
    }

    fun checkNothing() {
        println("LoginService.checkNothing 1")
        println("LoginService.checkNothing 2")

    }

    private fun checkForm(userForm: UserForm?) {
        assert(userForm != null)
        assert(userForm?.username != null)
        assert(userForm?.password != null)
    }

}