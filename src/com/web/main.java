/**
*  @author Abdullah Abdul Maksoud
*  @date April 10, 2020 (Last Revised)
*  @file main.java
*/

package com.web;

/*
 * Code SOURCE:  https://www.baeldung.com/java-csv-file-array
 * 				 https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 * 				 https://howtodoinjava.com/java/collections/arraylist/convert-arraylist-to-array/
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
* @brief Small main class to run some tests for the MergeSort class
*/

public class main {

    /**
    * @brief main method to run some tests for the MergeSort class
    * @param command line arguments
    */
	public static void main(String[] args) {
		
		String csvFile = "acoustic_features.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<SongObject> AllSongs = new ArrayList<>();
		boolean SkipFirstLine = true;
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (!SkipFirstLine) {
					String[] OneSong = line.split(cvsSplitBy);
					SongObject thisSong = new SongObject(OneSong[0],OneSong[1],OneSong[2],OneSong[3],Double.parseDouble(OneSong[4]),Double.parseDouble(OneSong[5]),Double.parseDouble(OneSong[6]),Double.parseDouble(OneSong[7]),Double.parseDouble(OneSong[8]),Double.parseDouble(OneSong[9]),Double.parseDouble(OneSong[10]),Double.parseDouble(OneSong[11]),Double.parseDouble(OneSong[12]),Double.parseDouble(OneSong[13]),Double.parseDouble(OneSong[14]),Double.parseDouble(OneSong[15]),Double.parseDouble(OneSong[16]),OneSong[17],OneSong[18]);
					AllSongs.add(thisSong);
				}
				SkipFirstLine = false;
			}

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//Eg for mahmoud (searching)
		//sort the array lex. with respect to album
		SongObject[] ArrayOfSongs = AllSongs.toArray(new SongObject[AllSongs.size()]);
		MergeSort.sort(ArrayOfSongs, "album");

		
		//Eg for the use of filter system
		//sort the array with following preferences array
		String[] pref = {"Low","No Preference","Low","High","Low","Low","High","Low", "No Preference"};
		MergeSort.sort(ArrayOfSongs, pref);

	}

}
