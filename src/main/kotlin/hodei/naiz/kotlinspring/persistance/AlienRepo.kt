package hodei.naiz.kotlinspring.persistance

import hodei.naiz.kotlinspring.domain.Alien
import hodei.naiz.kotlinspring.persistance.firestore.FirestoreRepo
import hodei.naiz.kotlinspring.persistance.firestore.IRepo
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Hodei Eceiza
 * Date: 10/4/2021
 * Time: 23:25
 * Project: kotlinSpring
 * Copyright: MIT
 */
interface AlienRepo : IRepo<Alien>{

}
