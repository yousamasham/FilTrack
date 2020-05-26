/**
*  @author Abdullah Abdul Maksoud
*  @date April 11, 2020 (Last Revised)
*  @file FilterSystem.java
*/

package com.web;

/**
* @brief This module has 1 method that updates the quality of a given object based on the user preferences.
* @detail Only acousticness, danceability, energy, instrumental, liveness, loudness, speechiness, Tempo, and Valence are considered when
*  updating the quality of a given object.
*  each quality can either be Low, High, or No Preference.
*/

public class FilterSystem {

    /**
    * @brief updates the quality of a given object based on the user preferences.
    * @param object the SongObject that will be updated
    * @param acousticness the prefered acousticness
    * @param danceability the prefered danceability
    * @param energy the prefered energy
    * @param instrumental the prefered instrumental
    * @param liveness the prefered liveness
    * @param loudness the prefered loudness
    * @param speechiness the prefered speechiness
    * @param Tempo the prefered Tempo
    * @param Valence the prefered Valence
    * @return the calculated quality of the given object based on the given prefrences.
    */
	public static double Quality(SongObject object, String acousticness, String danceability, String energy, String instrumental, String liveness, String loudness, String speechiness, String Tempo, String Valence) {
		
		double Quality = 0.0;
		if (acousticness.equals("Low")) Quality = -(object.getAcousticness()/0.996);
		else if (acousticness.equals("High")) Quality = (object.getAcousticness()/0.996);
		
		if (danceability.equals("Low")) Quality = Quality - (object.getDanceability()/0.988);
		else if (danceability.equals("High")) Quality = Quality + (object.getDanceability()/0.988);
		
		if (energy.equals("Low")) Quality = Quality - (object.getEnergy());
		else if (energy.equals("High")) Quality = Quality + (object.getEnergy());
		
		if (instrumental.equals("Low")) Quality = Quality - (object.getInstrumental());
		else if (instrumental.equals("High")) Quality = Quality + (object.getInstrumental());
		
		if (liveness.equals("Low")) Quality = Quality - (object.getLiveness());
		else if (liveness.equals("High")) Quality = Quality + (object.getLiveness());
		
		if (loudness.equals("Low")) Quality = Quality - (object.getLoudness()/3.744);
		else if (loudness.equals("High")) Quality = Quality + (object.getLoudness()/3.744);
		
		if (speechiness.equals("Low")) Quality = Quality - (object.getSpeechiness()/0.968);
		else if (speechiness.equals("High")) Quality = Quality + (object.getSpeechiness()/0.968);
		
		if (Tempo.equals("Low")) Quality = Quality - (object.getTempo()/247.824);
		else if (Tempo.equals("High")) Quality = Quality + (object.getTempo()/247.824);
		
		if (Valence.equals("Low")) Quality = Quality - (object.getValence());
		else if (Valence.equals("High")) Quality = Quality + (object.getValence());
		
		return ((Quality/9)*100);
	}
	
	
	
	
}

