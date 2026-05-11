package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }

    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        User user = new User().setEmail("maru"+i+"@gmail.com").setPassword("P$ok132135435");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactDisplayed());
    }
    @Test(description = "for example")
    public void registrationWrongEmail(){
        Random random = new Random();
        int i = random.nextInt();
        User user = new User().setEmail("maru"+i+"gmail.com").setPassword("Pokrob&123456");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

    @Test
    public void registrationNoEmail(){
        User user = new User().setEmail("").setPassword("Pokrob&123456");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

    @Test
    public void registrationWrongPassword(){
        Random random = new Random();
        int i = random.nextInt();
        User user = new User().setEmail("ma"+i+"@gmail.ru").setPassword("pok123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("$"));

    }

    @Test
    public void registrationNoPassword(){
        Random random = new Random();
        int i = random.nextInt();
        User user = new User().setEmail("ma"+i+"@gmail.ru");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("$"));

    }

    @Test
    public void registrationExistUser(){
        Random random = new Random();
        int i = random.nextInt();
        User user = new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }


}
