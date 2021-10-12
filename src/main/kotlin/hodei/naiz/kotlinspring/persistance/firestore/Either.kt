package hodei.naiz.kotlinspring.persistance.firestore

import org.apache.catalina.connector.Response
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.servlet.function.ServerResponse.ok

/**
 * Created by Hodei Eceiza
 * Date: 10/6/2021
 * Time: 23:40
 * Project: kotlinSpring
 * Copyright: MIT
 */

sealed class Either <A, B>{
    abstract fun result(): Any?


    class Left<A,B>(val left:A) :Either<A,B>(){
        override fun result(): A {
           return left
        }
    }
    class Right<A,B>(val right: Any?) : Either<A, B>(){
        override fun result(): Any? {
            return right
        }
    }
}




