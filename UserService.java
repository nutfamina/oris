import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public void createUser(String name){
        User user = new User(0,name);
        repository.add(user);
        System.out.println("я создала пользователя :" + name);
    }

    public void findUser(int id){
        User user = repository.getById(id);
        if (user!= null){
            System.out.println("Нашелся с айди:" + user.id +"с именем"+ user.name);
        } else {
            System.out.println("Не нашелся");
        }
    }

    public void showAll() {
        System.out.println("Все пользователи:");
        for (User user : repository.getAll()) {
            System.out.println(" Айди:" + user.id + "Имя:" + user.name);
        }
    }

    public void deleteUser(int id){
        User user = repository.getById(id);
        if(user!= null){
            repository.deleteUser(id);
        }
    }

    public void updateUser(int id,String newName){
        repository.updateUser(id,newName);
        System.out.println("Обновили пользователя с айди"+id + "на другое имя :");
    }


}


