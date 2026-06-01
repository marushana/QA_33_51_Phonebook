package tests;

import manager.DataProviderContact;
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
    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAllFields(Contact contact){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

//        Contact contact = Contact.builder()
//                .name("TonySuccess"+i)
//                .lastName("MOlly")
//                .phone("45645613"+i)
//                .email("molly"+i+"@gmail.com")
//                .address("haifa")
//                .description("friend")
//                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        //app.getHelperContact().getScreen("src/test/screenshots/screen - "+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test(dataProvider = "contactCSV", dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAllFieldsCSV(Contact contact){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

//        Contact contact = Contact.builder()
//                .name("TonySuccess"+i)
//                .lastName("MOlly")
//                .phone("45645613"+i)
//                .email("molly"+i+"@gmail.com")
//                .address("haifa")
//                .description("friend")
//                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        //app.getHelperContact().getScreen("src/test/screenshots/screen - "+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessRequiredFields(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        Contact contact = Contact.builder()
                .name("TonyRequired")
                .lastName("MOlly")
                .phone("45645613"+i)
                .email("molly"+i+"@gmail.com")
                .address("haifa")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("MOlly")
                .phone("4564561346546")
                .email("molly@gmail.com")
                .address("haifa")
                .description("wrong name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplay());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Tonuy")
                .lastName("")
                .phone("4564561346546")
                .email("molly@gmail.com")
                .address("haifa")
                .description("wrong last name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplay());
    }

    @Test(dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact){
//        Contact contact = Contact.builder()
//                .name("yuiuy")
//                .lastName("MOlly")
//                .phone("")
//                .email("molly@gmail.com")
//                .address("haifa")
//                .description("wrong phone")
//                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplay());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Phone not valid:"));
    }

    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("lkhphphpphp")
                .lastName("MOlly")
                .phone("4564561346546")
                .email("mollygmail.com")
                .address("haifa")
                .description("wrong email")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplay());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid:"));
    }

    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("hohhphhp")
                .lastName("MOlly")
                .phone("4564561346546")
                .email("molly@gmail.com")
                .address("")
                .description("wrong address")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplay());
    }

}
