package hodei.naiz.kotlinspring.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Hodei Eceiza
 * Date: 10/4/2021
 * Time: 23:23
 * Project: kotlinSpring
 * Copyright: MIT
 */
@Entity
data class Alien (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long=0,
    val name:String,
    val planet:String?

)
