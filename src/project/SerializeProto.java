package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import project.DummyObjectC.DummyObject;

public class SerializeProto {
	private FileOutputStream output;
	
	FileOutputStream serialize(DummyObjectC.DummyObject out, String path){
		try {
			output = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out.writeTo(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}

	public DummyObject deserialize(String path) {
		try {
			return DummyObject.parseFrom(new FileInputStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
