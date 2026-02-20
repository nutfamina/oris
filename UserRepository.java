import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class UserRepository {

    public ArrayList<User> users = new ArrayList<>();
    public int counterId = 1;

    public void add(User user){
        user.id = counterId;
        counterId++;
        users.add(user);
    }

    public ArrayList<User> getAll(){
        return users;
    }

    public User getById(int id){
        for(User user : users){
            if (user.id == id){
                return user;
            }
        }
        return null;
    }

    public void updateUser(int id,String newName){
            User user = getById(id);
            if (user != null){
                user.name = newName;
            }
        }

    public void deleteUser(int id){
        User user = getById(id);
        if (user!= null){
            users.remove(user);
        }
    }
}


