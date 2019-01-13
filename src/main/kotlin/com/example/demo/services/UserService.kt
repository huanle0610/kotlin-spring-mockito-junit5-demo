package com.example.demo.services

import com.example.demo.getClassForLogging
import com.example.demo.getLogger
import org.springframework.stereotype.Service


@Service("user service")
class UserService {
    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(getClassForLogging(javaClass))
    }

//    companion object {
//        private val logger = LoggerFactory.getLogger(UserService::class.java)
//    }

//    private val logger = LoggerFactory.getLogger(javaClass)

    fun getUser(name: String): String {
        logger.info("getUser: $name")
        return "amtf"
    }

    fun getUserAge(name: String): Int {
        logger.info("getUserAge: $name")
        return 12
    }

    fun getUserAge(): Int {
        logger.info("getUserAge: empty")
        return 13
    }
}