package net.mdsgene.admin.generatedproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserToSurvey {

	public static boolean checkKey(String key, String keyFilePath) {
	    // Read the keys.txt file and check if the key exists
	    File file = new File(keyFilePath);
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line;
	        boolean keyFound = false;
	        while ((line = br.readLine()) != null) {
	            if (line.equals(key)) {
	                keyFound = true;
	                break;
	            }
	        }

	        return keyFound;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}