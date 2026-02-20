import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        UserService service = context.getBean(UserService.class);

        System.out.println("Создаю людей:");
        service.createUser("Амина");
        service.createUser("Ляйсан");
        service.createUser("Даша");

        System.out.println("Смотрим всех пользователей:");
        service.showAll();

        System.out.println("Ищу человека с айди 2:");
        service.findUser(2);

        System.out.println("Меняем имя у номера 1:");
        service.updateUser(1, "Амина лучшая");

        System.out.println();

        System.out.println("Проверяем заново");
        service.showAll();

        System.out.println("Удаляем человека под номером 3:");
        service.deleteUser(3);

        System.out.println("Проверяем еще раз");
        service.showAll();
    }
}