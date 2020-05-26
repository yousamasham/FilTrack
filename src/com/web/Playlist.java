package com.web;

import java.util.ArrayList;

/**
 * @author Jeffrey Dang
 * Playlist class responsible for finding the most closely related songs a given playlist
 */
public class Playlist {
	public ArrayList<SongObject> playlist;
	private static double benchmark_quality;
	
	/**
	 * OneSongSearch using one song object and then uses qualities of that song based on the inputted preferences and based on the given a list of SongObject
	 * will return the top num_wanted amount of songs in form of a Array List of SongObject
	 * @param first_song the song that is being benchmarked against
	 * @param songlist ArrayList of SongObject
	 * @param int number of wanted songs
	 * @param String[] string array of preferences based on user inputs
	 * @return returns ArrayList of SongObject that have the closest calculated Quality from the first_song quality
	 */
	public static ArrayList<SongObject> OneSongSearch(SongObject first_song, ArrayList<SongObject> songlist,int num_wanted,String[] arr_preferences){
		ArrayList<SongObject> recommend_list = new ArrayList<SongObject>();
		first_song.SetQuality(arr_preferences);
		benchmark_quality = first_song.getQuality();
		for (SongObject x : songlist) {
			x.SetQuality(arr_preferences);
			if(recommend_list.size() < num_wanted) {
				recommend_list.add(x);
				continue;
			}
			if(NearQuality(benchmark_quality,recommend_list.get(0).getQuality()) < NearQuality(benchmark_quality,x.getQuality())) {
				recommend_list.remove(0);
				recommend_list.add(x);
				InsertionSort(recommend_list);  //possibly make the modified insertion better by only doing insertion sort on the first element
			}
		}
//		MergeSort.sort(a, preferences_arr);
		
		return recommend_list;
	}
	
	/**
	 * Calculates difference between two doubles
	 * @param compareQuality a double value
	 * @param newQuality a double value
	 */
	private static double NearQuality(double compareQuality, double newQuality) {
		return Math.abs(compareQuality - newQuality);
	}
	
	/**
	 * Insertion sort based on the benchmark_quality, the closer a song the higher is it on the list is it put
	   @param songlist a given song list
	 */
	private static void InsertionSort(ArrayList<SongObject> songlist) {  //creating a top num_wanted function needs a sorting algorithm, but for small sizes insertion sort is best
		for (int i = 1; i < songlist.size(); i++) {
			double compare_quality = songlist.get(i).getQuality();
			SongObject compare_song = songlist.get(i);
			int j = i - 1;            //value to left
			
			while (NearQuality(benchmark_quality,songlist.get(j).getQuality()) > NearQuality(benchmark_quality,compare_quality) && j > 0) {
				songlist.set(j + 1, songlist.get(j));
				j = j - 1;
			}
			songlist.set(j + 1,compare_song);
			
		}
	}
	
	/**
	 * toNode creates a Node structure for each song in song_list and puts into another ArrayList
	 * @param song_list a given song_list
	 */
	public static ArrayList<Node> toNode(ArrayList<SongObject> song_list){
		ArrayList<Node> node_list = new ArrayList<Node>();
		for (SongObject song : song_list) {
			Node song_node = new Node(song);
			node_list.add(song_node);
		}
		return node_list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
	
	}

}
