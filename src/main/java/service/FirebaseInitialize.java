package service;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirebaseInitialize {

    public FirebaseInitialize() throws IOException {
        initialize();
    }

    @PostConstruct
    public void initialize() throws IOException {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://projet-uf-dev-logiciel.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    public String addElement(Object element, String tableName, String elementID) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = firestore.collection(tableName).document(elementID).set(element);
        return "[" + tableName + "] " + elementID + " - " + writeResultApiFuture.get().getUpdateTime().toString();
    }
}
