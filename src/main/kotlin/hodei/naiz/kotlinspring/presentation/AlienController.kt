package hodei.naiz.kotlinspring.presentation

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.Firestore
import com.google.firebase.database.DatabaseReference

import hodei.naiz.kotlinspring.domain.Alien
import hodei.naiz.kotlinspring.persistance.AlienRepo
import hodei.naiz.kotlinspring.persistance.firestore.Either
import hodei.naiz.kotlinspring.persistance.firestore.FirestoreRepo
import hodei.naiz.kotlinspring.persistance.firestore.FirestoreRepoFactory
import hodei.naiz.kotlinspring.persistance.firestore.IRepo
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Hodei Eceiza
 * Date: 10/4/2021
 * Time: 23:31
 * Project: kotlinSpring
 * Copyright: MIT
 */
@RestController
@RequestMapping("aliens")
class AlienController(val alienRepo:IRepo<Alien>) {
    @PostMapping
    fun createAlien(@RequestBody alien: Alien): Either<String, String> =
      alienRepo.add(alien)

       // println(alien):

    @GetMapping
    fun getById(@RequestBody id:String): Either<String, Alien> = alienRepo.getById(id)


}



