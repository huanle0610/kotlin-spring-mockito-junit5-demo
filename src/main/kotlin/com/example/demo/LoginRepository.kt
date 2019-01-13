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

import org.springframework.stereotype.Repository
import java.util.*

@Repository
class LoginRepository {

    var users: MutableMap<String, String> = HashMap()

    init {
        // Users of the system are stored in this map (key=username,
        // value=password)
        users["user1"] = "p1"
        users["user2"] = "p3"
        users["user3"] = "p4"
    }

    fun login(userForm: UserForm): Boolean {
        println("LoginRepository.login $userForm")

        val username = userForm.username
        val password = userForm.password

        return users.keys.contains(username) && users[username] == password
    }

}
