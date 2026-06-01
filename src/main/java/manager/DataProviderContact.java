package manager;

import model.Contact;
import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastName("Gay")
                .email("Harry@gmail.com")
                .phone("132465646341")
                .address("hogsmite")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastName("Gay")
                .email("Harrypotter@gmail.com")
                .phone("132465646345")
                .address("hogsmite")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastName("Gay")
                .email("Harry@gmail.com")
                .phone("1324")
                .address("hogsmite")
                .description("friend")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastName("Gay")
                .email("Harrypotter@gmail.com")
                .phone("")
                .address("hogsmite")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastName("Gay")
                .email("Harrypor@gmail.com")
                .phone("lgflhglh")
                .address("hogsmite")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/main/resources/contact.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
