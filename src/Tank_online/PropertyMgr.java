package Tank_online;

import java.io.IOException;
import java.util.Properties;

//配置信息管理
public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));//config是当前目录下的配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        else return props.get(key);
    }

}
