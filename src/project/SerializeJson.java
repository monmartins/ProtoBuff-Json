package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;



public class SerializeJson {

	public void serialize(JSONObject obj, String path) {
        //Write JSON file
        try (FileWriter file = new FileWriter(path)) {
 
            file.write(obj.toString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public JSONObject deserialize(String path) {
		JSONTokener tok;
		try {
			tok = new JSONTokener(new FileReader(path));
			JSONObject obj = new JSONObject(tok.nextValue());
			return obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
