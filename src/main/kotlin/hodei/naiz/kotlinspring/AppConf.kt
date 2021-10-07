package hodei.naiz.kotlinspring

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import hodei.naiz.kotlinspring.domain.Alien
import hodei.naiz.kotlinspring.persistance.AlienRepo
import hodei.naiz.kotlinspring.persistance.firestore.FirestoreRepo
import hodei.naiz.kotlinspring.persistance.firestore.FirestoreRepoFactory
import hodei.naiz.kotlinspring.persistance.firestore.IRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

/**
 * Created by Hodei Eceiza
 * Date: 10/4/2021
 * Time: 22:48
 * Project: kotlinSpring
 * Copyright: MIT
 */
@Configuration
class AppConf{
    @Value("\${firebase.config.path}")
    lateinit var firebaseConfigPath:String


    @Bean
    fun initFirebase(): Firestore {
        val options =FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream(firebaseConfigPath)))
            .build()
        FirebaseApp.initializeApp(options)
        return FirestoreClient.getFirestore()
    }
    @Bean
    fun startRepo(firestore:Firestore): FirestoreRepoFactory{
        return FirestoreRepoFactory(firestore)
    }
    @Bean
    fun alienRepo():IRepo<Alien>{
        return startRepo(initFirebase()).GetRepository(Alien::class.java)
    }
}
