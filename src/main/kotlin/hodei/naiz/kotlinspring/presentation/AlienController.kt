package hodei.naiz.kotlinspring.presentation

import com.google.api.core.ApiFuture
import com.google.firebase.database.DatabaseReference

import hodei.naiz.kotlinspring.domain.Alien
import hodei.naiz.kotlinspring.persistance.AlienRepo
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
class AlienController(val alienRepo: AlienRepo) {
    @PostMapping
    fun createAlien(@RequestBody alien: Alien) =
        println("empty")
    @GetMapping
    fun getAliens(): List<Alien> =alienRepo.findAll()
}


