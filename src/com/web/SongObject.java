/**
*  @author Abdullah Abdul Maksoud
*  @date April 11, 2020 (Last Revised)
*  @file SongObject.java
*/


package com.web;

/**
* @brief ADT for one song
*/

public class SongObject {

	private final String id;
	private final String song;
	private final String album;
	private final String artist;
	
	private final double acousticness;
	private final double danceability;
	private final double duration;
	private final double energy;
	private final double instrumental;
	private final double key;
	
	
	private final double liveness;
	private final double loudness;
	private final double mode;
	private final double speechiness;
	private final double tempo;
	
	private final double time_sign;
	private final double valence;
	private final String album_id;
	private final String date;
	private double Quality = 0.0;
	
	/**
    * @brief Constructor of the ADT
    * @param id is the id of a song
    * @param song is the name of a song
    * @param album is the album of a song
    * @param artist is the song's artist
    * @param acousticness is the acousticness of a song
    * @param danceability is the danceability of a song
    * @param duration is the duration of a song
    * @param energy is the energy of a song
    * @param instrumental is the instrumental of a song
    * @param key is the key of a song
    * @param liveness is the liveness of a song
    * @param loudness is the loudness of a song
    * @param mode is the mode of a song
    * @param speechiness is the speechiness of a song
    * @param tempo is the tempo of a song
    * @param time_sign is the time_sign of a song
    * @param valence is the valence of a song
    * @param album_id is the album_id of a song
    * @param date is the date the song was made
    */

	public SongObject(String id, String song, String album, String artist, double acousticness, double danceability,double duration,double energy,double instrumental,double key,double liveness,double loudness ,double mode,double speechiness, double tempo, double time_sign, double valence, String album_id, String date) {
		this.id = id;
		this.song = song;
		this.album = album;
		this.artist = artist;
		
		this. acousticness = acousticness;
		this. danceability = danceability;
		this. duration = duration;
		this. energy = energy;
		this. instrumental = instrumental;
		this. key = key;
		
		
		this. liveness = liveness;
		this. loudness = loudness;
		this. mode = mode;
		this. speechiness = speechiness;
		this. tempo = tempo;
		
		this. time_sign = time_sign;
		this. valence = valence;
		this. album_id = album_id;
		this. date = date;
		
		
		
	}

	/**
    * @brief sets the quality based on the given prefrences
    * @param Prefrences is an array of String which gives the preferecnes of the user
    */
	public void SetQuality(String[] Prefrences) {
		this.Quality = FilterSystem.Quality(this, Prefrences[0], Prefrences[1], Prefrences[2], Prefrences[3], Prefrences[4], Prefrences[5], Prefrences[6], Prefrences[7], Prefrences[8]);
	}
	
	/**
    * @brief getter for quality
    * @return the current value of quality
    */	
	public double getQuality() {
		return this.Quality;
	}
	
	/**
    * @brief getter for id
    * @return the id of the song
    */	
	public String getId() {
		return id;
	}

	/**
    * @brief getter for song (song name)
    * @return the name of the song
    */	
	public String getSong() {
		return song;
	}


	/**
    * @brief getter for album
    * @return the album of the song
    */	
	public String getAlbum() {
		return album;
	}


	/**
    * @brief getter for artist
    * @return the artist's name of the song
    */	
	public String getArtist() {
		return artist;
	}


	/**
    * @brief getter for acousticness
    * @return the acousticness of the song
    */	
	public double getAcousticness() {
		return acousticness;
	}


	/**
    * @brief getter for danceability
    * @return the danceability of the song
    */	
	public double getDanceability() {
		return danceability;
	}


	/**
    * @brief getter for duration
    * @return the duration of the song
    */
	public double getDuration() {
		return duration;
	}


	/**
    * @brief getter for energy
    * @return the energy of the song
    */
	public double getEnergy() {
		return energy;
	}


	/**
    * @brief getter for instrumental
    * @return the instrumental of the song
    */
	public double getInstrumental() {
		return instrumental;
	}


	/**
    * @brief getter for key
    * @return the key of the song
    */
	public double getKey() {
		return key;
	}


	/**
    * @brief getter for liveness
    * @return the liveness of the song
    */
	public double getLiveness() {
		return liveness;
	}


	/**
    * @brief getter for loudness
    * @return the loudness of the song
    */
	public double getLoudness() {
		return loudness;
	}


	/**
    * @brief getter for mode
    * @return the mode of the song
    */
	public double getMode() {
		return mode;
	}


	/**
    * @brief getter for speechiness
    * @return the speechiness of the song
    */
	public double getSpeechiness() {
		return speechiness;
	}


	/**
    * @brief getter for tempo
    * @return the tempo of the song
    */
	public double getTempo() {
		return tempo;
	}


	/**
    * @brief getter for time_sign
    * @return the time_sign of the song
    */
	public double getTime_sign() {
		return time_sign;
	}


	/**
    * @brief getter for valence
    * @return the valence of the song
    */
	public double getValence() {
		return valence;
	}


	/**
    * @brief getter for album_id
    * @return the album_id of the song
    */
	public String getAlbum_id() {
		return album_id;
	}


	/**
    * @brief getter for date
    * @return the date the song was made
    */
	public String getDate() {
		return date;
	}

	/**
    * @brief toString method for the ADT
    * @return A string that contains all the information of the song
    */
	public String toString() {
		return "SongObject [id=" + id + ", song=" + song + ", album=" + album + ", artist=" + artist + ", acousticness="
				+ acousticness + ", danceability=" + danceability + ", duration=" + duration + ", energy=" + energy
				+ ", instrumental=" + instrumental + ", key=" + key + ", liveness=" + liveness + ", loudness="
				+ loudness + ", mode=" + mode + ", speechiness=" + speechiness + ", tempo=" + tempo + ", time_sign="
				+ time_sign + ", valence=" + valence + ", album_id=" + album_id + ", date=" + date + ", Quality="
				+ Quality + "]";
	}





}
