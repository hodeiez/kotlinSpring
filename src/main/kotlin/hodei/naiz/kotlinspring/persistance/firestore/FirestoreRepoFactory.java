package hodei.naiz.kotlinspring.persistance.firestore;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import hodei.naiz.kotlinspring.domain.Alien;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by Hodei Eceiza
 * Date: 10/7/2021
 * Time: 21:10
 * Project: kotlinSpring
 * Copyright: MIT
 */
public class FirestoreRepoFactory {
    private Function<String, CollectionReference> getCollectionReference;

    private final static Map<Class<?>, String> collectionMap = Map.of(
            Alien.class, "Aliens"

    );

    public FirestoreRepoFactory(Firestore firestore){
        getCollectionReference = collectionPath -> firestore.collection(collectionPath);
    }

    private FirestoreRepoFactory(DocumentReference document){
        getCollectionReference = collectionPath -> document.collection(collectionPath);
    }

    public FirestoreRepoFactory FromDocument(Class<?> classType, String documentId){
        String collectionName = collectionMap.get(classType);
        DocumentReference documentReference = getCollectionReference.apply(collectionName).document(documentId);
        return new FirestoreRepoFactory(documentReference);
    }

    public <T> IRepo<T> GetRepository(Class<T> classType){
        String collectionName = collectionMap.get(classType);
        return new FirestoreRepo<T>(getCollectionReference.apply(collectionName), classType);
    }
}
