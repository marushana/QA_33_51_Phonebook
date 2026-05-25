package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304!"));

        }
        app.getHelperContact().provideContacts();//if List of contacts less then 3 then add 3 contacts
    }

    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);

    }

    @Test
    public void removeAllContacts(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContactDisplayed());


    }
}
