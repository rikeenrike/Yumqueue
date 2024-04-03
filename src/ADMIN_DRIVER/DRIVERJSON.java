
package ADMIN_DRIVER;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DRIVERJSON {
    static JSONObject folder;
    static JSONArray list;
    static JSONObject info;
    static JSONParser jsonParser;
    static {
        jsonParser = new JSONParser();
        folder = new JSONObject();
        list = new JSONArray();
        info = new JSONObject(); 
    }
    
   public static JSONArray reader() throws IOException, ParseException, org.json.simple.parser.ParseException{
        FileReader reader = new FileReader("src\\JSON_DATABASE\\DRIVERS_DETAILS.json");
        if (reader.ready()) {
            Scanner collect = new Scanner(reader);
            String line = "";
            while(collect.hasNext()){
                line = line + collect.nextLine();
            }
            if (!line.equals("")) {
                reader.close();
                FileReader reader2 = new FileReader("src\\JSON_DATABASE\\DRIVERS_DETAILS.json");
                folder = (JSONObject) jsonParser.parse(reader2);
                list = (JSONArray) folder.get("folder");
            }
        }
        reader.close();
        return list;
    }
    public static void writer() throws IOException {
        FileWriter writer = new FileWriter("src\\JSON_DATABASE\\DRIVERS_DETAILS.json");
        writer.write(folder.toJSONString());
        writer.close();
        
    } 
}
