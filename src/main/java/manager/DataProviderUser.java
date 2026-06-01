package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marushana@yandex.ru", "Pokrov1304!"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        list.add(new Object[]{"art276@art.com", "$Art1$2$3456789"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("marushana@yandex.ru").setPassword("Pokrov1304!")});
        list.add(new Object[]{new User().setEmail("sonya@gmail.com").setPassword("Ss12345$")});
        list.add(new Object[]{new User().setEmail("art276@art.com").setPassword("$Art1$2$3456789")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/testData - Лист1.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] all = line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }



}
