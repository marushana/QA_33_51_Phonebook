package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304!"));

        }
    }
    @Test
    public void addNewContactSuccessAllFields(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("MOlly")
                .phone("45645613"+i)
                .email("molly"+i+"@gmail.com")
                .address("haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessRequiredFields(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("MOlly")
                .phone("45645613"+i)
                .email("molly"+i+"@gmail.com")
                .address("haifa")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }


}
