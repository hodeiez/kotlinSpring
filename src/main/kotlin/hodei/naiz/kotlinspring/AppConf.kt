package hodei.naiz.kotlinspring

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
    @Value("\${firebase.database.url}")
    lateinit var firebaseDatabaseUrl:String


    @Bean
    fun initFirebase(): DatabaseReference {
        val options =FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream(firebaseConfigPath)))
            .setDatabaseUrl(firebaseDatabaseUrl)
            .build()
        FirebaseApp.initializeApp(options)
        return FirebaseDatabase.getInstance().getReferenceFromUrl(firebaseDatabaseUrl)
    }

}
