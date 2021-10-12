package hodei.naiz.kotlinspring.persistance.firestore

/**
 * Created by Hodei Eceiza
 * Date: 10/6/2021
 * Time: 23:31
 * Project: kotlinSpring
 * Copyright: MIT
 */

interface IRepo <T>{

    fun add(data: T): Either<String, T>
    fun getById(id:String): Either<String,T>
    fun getAll(): Either<String, List<T>>
}

