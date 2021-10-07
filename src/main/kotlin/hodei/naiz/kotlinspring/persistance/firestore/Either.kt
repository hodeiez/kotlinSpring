package hodei.naiz.kotlinspring.persistance.firestore

/**
 * Created by Hodei Eceiza
 * Date: 10/6/2021
 * Time: 23:40
 * Project: kotlinSpring
 * Copyright: MIT
 */

sealed class Either <A, B>{
   data class Left<A,B>(val left:A) :Either<A,B>()
    class Right<A,B>(val right: Any?) : Either<A, B>()

}




