package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONManager {
    public static void saveJSONData(JSONObject jsonObject) throws IOException, ParseException {
        String fileUrl="./src/main/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(fileUrl));
        jsonArray.add(jsonObject);

        FileWriter fileWriter=new FileWriter(fileUrl);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
    public static JSONObject readJSONData() throws IOException, ParseException {
        String fileUrl="./src/main/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(fileUrl));
        return (JSONObject) jsonArray.get(jsonArray.size()-1);
    }
}
