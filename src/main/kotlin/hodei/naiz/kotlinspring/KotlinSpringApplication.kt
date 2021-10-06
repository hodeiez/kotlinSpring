package hodei.naiz.kotlinspring

import com.google.cloud.firestore.Firestore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinSpringApplication

fun main(args: Array<String>) {

    runApplication<KotlinSpringApplication>(*args)
}


