/**
*  @author Mahmoud Anklis
*  @date April 10, 2020 
*  @file mainSearch.java
*/

package com.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
* @brief This module has 1 main function.
* It searches for a specific song title and artist and returns a list of the songs that match the search.
*/

public class mainSearch {

    /**
     * @brief Searches for a specified song title and artist.
     * @param String: songTitle
     * @param String: artist
     * @return An ArrayList of the songs that match the search done by BoyerMoore using the song title and artist.
     */
	public static ArrayList<SongObject> searchResult(String songTitle, String artist){
		File fileBase = new File("filtrack/src/com/web/acoustic_features.csv");		//File path
		String path = fileBase.getAbsolutePath();
//		String csvFile = path;
		String csvFile = "C:\\Users\\Yousam Asham\\Desktop\\FilTrack\\src\\com\\web\\acoustic_features.csv";
//		String csvFile = "/filtrack/acoustic_features.csv";
		BufferedReader br = null;
		String line = "";				//Initializing a String variable that will be used to store each line in the csv file
		String cvsSplitBy = ",";			//The delimiter used to split the csv file by
		ArrayList<SongObject> searchedSongs = new ArrayList<SongObject>();	//An arrayList of SongObejects that will include all the searched songs
		boolean SkipFirstLine = true;
		System.out.println("Loading...");
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				//Skip the first line
				if (!SkipFirstLine) {
					String[] OneSong = line.split(cvsSplitBy);		//An array of Strings that will store each category after splitting the line at each comma
					OneSong[1] = OneSong[1].replaceAll("[^\\x20-\\x7e]", "");	//This cleans/removes all the non-ASCII characters.

					//Create a SongObject using the components of the String array for each line (each line represents a song).
					SongObject thisSong = new SongObject(OneSong[0],OneSong[1],OneSong[2],OneSong[3],Double.parseDouble(OneSong[4]),Double.parseDouble(OneSong[5]),Double.parseDouble(OneSong[6]),Double.parseDouble(OneSong[7]),Double.parseDouble(OneSong[8]),Double.parseDouble(OneSong[9]),Double.parseDouble(OneSong[10]),Double.parseDouble(OneSong[11]),Double.parseDouble(OneSong[12]),Double.parseDouble(OneSong[13]),Double.parseDouble(OneSong[14]),Double.parseDouble(OneSong[15]),Double.parseDouble(OneSong[16]),OneSong[17],OneSong[18]);
					BoyerMoore search1 = new BoyerMoore(songTitle.toLowerCase());	//Create a BoyerMoore object and initialize it with whatever the song title is.
					BoyerMoore search2 = new BoyerMoore(artist.toLowerCase());	//Create a BoyerMoore object and initialize it with whatever the artist is.

					int index1 = search1.search(OneSong[1].toLowerCase());		//Returns the index of the search result of the song title from BoyerMoore algorithm.
					int index2 = search2.search(OneSong[3].toLowerCase());		//Returns the index of the search result of the artist name from BoyerMoore algorithm.

					//Check if both indexes are not negative, then add the current song to the final ArrayList.
					if(index1 != -1 && index2 != -1){
						searchedSongs.add(thisSong);
					}
				}
				SkipFirstLine = false;
			}
		} 
		//Exception Handling
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
		System.out.println("---------------------");
		int j = 1;
		for(SongObject song : searchedSongs){
			System.out.println(j + " " + song.toString());
			System.out.println();
			j++;
		}
		return searchedSongs;
	}
	public static void main(String[] args) {
		searchResult("tragedy", "bee gees");

	}

}
