package daos;

import com.google.firebase.cloud.FirestoreClient;
import objects.User;
import service.FirebaseInitialize;

import java.util.concurrent.ExecutionException;

public class UserDao {
    private static final String TABLE_NAME = "users";

    public UserDao(){

    }

    public String addUser(FirebaseInitialize database, User user) throws ExecutionException, InterruptedException {
        return database.addElement(user, TABLE_NAME, user.getId());
    }
}
