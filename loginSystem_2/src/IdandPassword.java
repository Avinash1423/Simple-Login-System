import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class IdandPassword {

    static HashMap<String,String> loginInfo=new HashMap<String,String>();
    static String filepath=System.getProperty("user.dir")+"\\src\\loginInfo.properties.txt";
    public IdandPassword(){

    }

  static  protected HashMap<String,String> getLoginInfo(){
      Properties properties= new Properties();


        FileInputStream fis;

        try {
            fis = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fis);

            for(String key:properties.stringPropertyNames())
                loginInfo.put(key,properties.getProperty(key));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return loginInfo;

    }

    static protected void addNewUser(String newName,String newPassword){



        Properties properties=new Properties();

        FileOutputStream fos;
        FileInputStream fis;


        try {
            fis=new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        properties.setProperty(newName,newPassword);
        try {
             fos=new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.store(fos,"new accounts");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }


}



