package hodei.naiz.kotlinspring.persistance.firestore

import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore

/**
 * Created by Hodei Eceiza
 * Date: 10/7/2021
 * Time: 00:05
 * Project: kotlinSpring
 * Copyright: MIT
 */
 class FirestoreRepo <T>(var collection : CollectionReference, var classType: Class<T>) :IRepo<T>  {


    override fun add(data: T): Either<String, T> {
        return try{
            val futureResult =collection.add(data)
            val result=futureResult.get()
            Either.Right(collection.document(result.id).get().get().toObject(classType))
        } catch(e:Exception){
            Either.Left(e.message.toString())
        }
    }

    override fun getById(id: String): Either<String, T> {
       return try {
           val entry = collection.document(id).get().get()


           if (entry.exists()) Either.Right(entry.toObject(classType)) else Either.Left("$id not found")
       }
       catch(e:Exception){
           Either.Left(e.message.toString())
       }
    }

    override fun getAll(): Either<String, List<T>> {
       return try{
           Either.Right(collection.get().get().documents.map{a->a.toObject(classType)})
       }
       catch(e:Exception){
       Either.Left("Couldn't fetch: "+e.message)}
    }
}
