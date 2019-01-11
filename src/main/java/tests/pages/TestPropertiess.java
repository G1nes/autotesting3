package tests.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestPropertiess {

    private final Properties properties = new Properties();
    private static TestPropertiess INSTANCE =null;
    private TestPropertiess(){
        try{
            properties.load(new FileInputStream(new File("C:\\Program Files\\JavaLearning\\autotesting3\\settings.properties")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static TestPropertiess getInstance(){
        if (INSTANCE==null){
            INSTANCE = new TestPropertiess();
        }
        return INSTANCE;
    }
    public Properties getProperties(){
        return properties;
    }
}
