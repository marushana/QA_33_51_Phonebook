package tests;

import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304!"));

        }
    }

    @Test
    public void removeFirstContact(){

    }

    @Test
    public void removeAllContacts(){

    }
}
