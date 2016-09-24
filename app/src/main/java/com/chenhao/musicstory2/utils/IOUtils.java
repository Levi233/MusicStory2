package com.chenhao.musicstory2.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {
	public static String getFileData(File file) {
		String info = "";
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while((line = bfr.readLine()) != null){
				info += line;
			}
			bfr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}
}
