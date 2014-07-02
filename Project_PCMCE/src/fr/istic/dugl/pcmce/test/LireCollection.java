package fr.istic.dugl.pcmce.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LireCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "PCM/Comparison_of_BitTorrent_tracker_software.pcm" ;
		File fDir = new File(fileName);
		List<String> results = new ArrayList<String>();
		File[] files = fDir.listFiles(); // TODO: filter .pcm files

    	System.out.println("ceci est une collection");
		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}

	}

}
