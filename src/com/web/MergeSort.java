/**
*  @author Abdullah Abdul Maksoud
*  @date April 10, 2020 (Last Revised)
*  @file MergSort.java
*/

package com.web;

/**
* @brief This module has 2 main functionalities
* Sorting a given array of SongObject lexicographically or
* Sorting a given array of SongObject based on Preferences
*/
public class MergeSort {

	//instance variable
	private static SongObject[] aux;
	
	/* The one used for searching
	 * To use, call: sort(arrayToBeSorted, "album" or "artist") and will sort based on what is given
	 */
	 
    /**
     * @brief Checks if the first SongObject is less than the second SongObject lexicographically.
     * @param obj1 the first SongObject.
     * @param obj2 the second SongObject.
     * @param WithRespectTo a string which is either album or artist.
     * @return true if obj1 is lexicographically less than obj2 with respect to the given string (WithRespectTo), false otherwise
     */
	private static boolean less(SongObject obj1, SongObject obj2, String WithRespectTo) {

		if (WithRespectTo.equals("album"))
			return obj1.getAlbum().toLowerCase().compareTo(obj2.getAlbum().toLowerCase()) < 0;
		
		return obj1.getArtist().toLowerCase().compareTo(obj2.getArtist().toLowerCase()) < 0;
	}

    /**
     * @brief sorts the given array of SongObject based on the given quality.
     * @param a an array of SongObject to be sorted.
     * @param WithRespectTo a string which is either album or artist.
     */	
	public static void sort(SongObject[] a, String WithRespectTo) { 
		int N = a.length;
		aux = new SongObject[N];
		for (int sz = 1; sz < N; sz = sz+sz) {
			for (int lo = 0; lo < N-sz; lo += sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1), WithRespectTo);   
			}
		}
	}

    /**
     * @brief merge method used by the sort method (the previous sort method).
     * @param a an array of SongObject to be sorted.
     * @param low the starting index.
     * @param mid the middle index.
     * @param high the ending index (can't go past this index).
     * @param WithRespectTo a string which is either album or artist.
     */	
	private static void merge (SongObject[] a, int low, int mid, int high, String WithRespectTo) {
		int i = low;
		int j = mid+1;
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid)	a[k] = aux[j++];
			else if (j > high)	a[k] = aux[i++];
			else if (less(aux[j], aux[i], WithRespectTo))  a[k] = aux[j++];
			else		a[k] = aux[i++];

		}
	}

	/*
 	 * The next part is the merge sort used in the filtering system
 	 * To use call: sort(arrayToBeSorted, ArrayofStringsThatRepresentPreferences).
 	 * Each entry of the array will be low,high,or No Preference about this quality.
 	 * 
 	 * Definitions:
 	 * No preference: means they don't care about this quality at all (no weight)
 	 * Low: they want this quality to be low
 	 * High: means they want this quality to be high
 	 */


	/**
     * @brief Checks if the first SongObject is less than the second SongObject based on the Preferences set by the user.
     * @param obj1 the first SongObject.
     * @param obj2 the second SongObject.
     * @param Preferences a string array where each entry is either Low, No Prefrence, or High.
     * @return true if obj1 is less than obj2 quality wise baed on the given Preferences, false otherwise
     */
	private static boolean compQuality(SongObject obj1, SongObject obj2, String[] Preferences) {
		obj1.SetQuality(Preferences);
		obj2.SetQuality(Preferences);		
		return obj1.getQuality() < obj2.getQuality();
	}

    /**
     * @brief sorts the given array of music based  on quality, the Preferences will be given as an array.
     * @param a an array of SongObject to be sorted.
     * @param Preferences a string array where each entry is either Low, No Prefrence, or High.
     */
	public static void sort(SongObject[] a, String[] Preferences) { 
		int N = a.length;
		aux = new SongObject[N];
		for (int sz = 1; sz < N; sz = sz+sz) {
			for (int lo = 0; lo < N-sz; lo += sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1), Preferences);   
			}
		}

	}
	
    /**
     * @brief merge method used by the sort method (the previous sort method).
     * @param a an array of SongObject to be sorted.
     * @param low the starting index.
     * @param mid the middle index.
     * @param high the ending index (can't go past this index).
     * @param Preferences a string array that has the Preferences of the user.
     */	
	private static void merge (SongObject[] a, int low, int mid, int high, String[] Preferences) {
		int i = low;
		int j = mid+1;
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid)	a[k] = aux[j++];
			else if (j > high)	a[k] = aux[i++];
			else if (compQuality(aux[j], aux[i], Preferences))  a[k] = aux[j++];
			else		a[k] = aux[i++];

		}
	}


}