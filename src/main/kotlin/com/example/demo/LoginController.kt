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

class LoginController {
    var loginService = LoginService()

    fun login(userForm: UserForm?): String {
        println("LoginController.login $userForm")

        return try {
            if (userForm == null) {
                "ERROR"
            } else if (loginService.login(userForm)) {
                "OK"
            } else {
                "KO"
            }
        } catch (e: Exception) {
            "ERROR"
        }

    }

    fun logout(userForm: UserForm) {
        println("LoginController.logout $userForm")

        loginService.logout(userForm)
    }

}
