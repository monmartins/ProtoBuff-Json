package project;


import project.DummyObjectC.DummyObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.json.*;

public class Main {
	
	public static void main(String[] arg) {
		SerializeProto serializeProto = new SerializeProto();
		SerializeJson serializeJson = new SerializeJson();
		
		DummyObject john = DummyObject.newBuilder().setId(1234)
			    .setName("John Doe")
			    .setEmail("jdoe@example.com")
			    .build();
		serializeProto.serialize(john,"file.txt");
		//ProtoBuff
		//Deserialize
		DummyObject johnIn = serializeProto.deserialize("file.txt");
		int id = johnIn.getId();
		String name = johnIn.getName();
		String email = johnIn.getEmail();
		System.out.println("Using protobuff: ID-"+id+" Name-"+name+" Email-"+email);
		
		//Json
		//Serialize
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));
		serializeJson.serialize(obj,"file.json");

		System.out.print("Using json "+obj);
		//Json
		//Deserialize
		JSONObject objD = serializeJson.deserialize("file.json");
		System.out.print("objd -- "+objD);
	      
	      
	}
}
