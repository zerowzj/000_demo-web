import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * @author wangzhj
 */
public class MyTest {

    @Test
    public void test(){
        JSONObject json = new JSONObject();

        json.put("key1", "sdfsdf");
        json.put("key2", 12);

        System.out.println(json.toString());

        Long l = 1200L;
        System.out.println(l/1000);

    }
}
