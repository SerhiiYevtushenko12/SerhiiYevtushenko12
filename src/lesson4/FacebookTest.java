package lesson4;

public class FacebookTest {

    public static void main(String[] args) throws InterruptedException {
        FacebookLogicService service = new FacebookLogicService();
        FacebookUser user = new FacebookUser(
                "Tony",
                "Hawk",
                "TonyHawk@gmail.com",
                "TonyHawk98",
                "Female",
                16, 4, 30
        );
        service.signUp(user);
    }
}
