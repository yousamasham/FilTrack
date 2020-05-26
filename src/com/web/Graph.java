package com.web;
import java.util.ArrayList;

/**
 * @author Jeffrey Dang
 * Graph class representing a graph comprised of Nodes with SongObject data
 * 
 */
public class Graph {
	ArrayList<Node> node_list;
	double avg_acousticness = 0.0;
	double avg_danceability = 0.0;
	double avg_energy = 0.0;
	double avg_instrumental = 0.0;
	double avg_liveness = 0.0;
	double avg_loudness = 0.0;
	double avg_mode = 0.0;
	double avg_speechiness = 0.0;
	double avg_tempo = 0.0;
	double avg_valence = 0.0;

	/**
	 * Constructor of Graph class
	 * @param song_list An ArrayList of Nodes
	 */
	public Graph (ArrayList<Node> song_list){
		this.node_list = song_list;   //instantiate with a given node_list "be a node list that ran through the Playlist.java"
	}
	
	/**
	 * Links all the nodes within the song_list, should be called before any other methods are called
	 */
	public void link() {    //links all nodes in the song_list by adding all them to the adjlist, assumed that we link the playlist before calling any other methods
		for (int i = 0 ; i < node_list.size() - 1; i++) {
			node_list.get(i).addAdj(node_list.get(i+1)); //adds the next node in the song_list to the adjancency list
		}
	}
	
	/**
	 * Sets the average acousticness quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgAcousticness() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getAcousticness();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_acousticness = total/num_song;
	}
	
	/**
	 * Returns the average acousticness quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgAcousticness() {
		if (this.avg_acousticness == 0.0) {
			this.setAvgAcousticness();
		}
		return avg_acousticness;
	}
	
	/**
	 * Sets the average danceability quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgDanceability() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getDanceability();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_danceability = total/num_song;
	}
	
	/**
	 * Returns the average danceability quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgDanceability() {
		if (this.avg_danceability == 0.0) {
			this.setAvgDanceability();
		}
		return avg_danceability;
	}
	
	/**
	 * Sets the average energy quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgEnergy() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getEnergy();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_energy = total/num_song;
	}
	
	/**
	 * Returns the average energy quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgEnergy() {
		if (this.avg_energy == 0.0) {
			this.setAvgEnergy();
		}
		return avg_energy;
	}
	
	/*8
	 * Sets the average instrumental quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgInstrumental() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getInstrumental();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_instrumental = total/num_song;
	}
	
	/**
	 * Returns the average energy quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgInstrumental() {
		if (this.avg_instrumental == 0.0) {
			this.setAvgInstrumental();
		}
		return avg_instrumental;
	}
	
	/**
	 * Sets the average liveness quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgLiveness() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getLiveness();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_liveness = total/num_song;
	}
	
	/**
	 * Returns the average liveness quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgLiveness() {
		if (this.avg_liveness == 0.0) {
			this.setAvgLiveness();
		}
		return avg_liveness;
	}
	
	/**
	 * Sets the average loudness quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgLoudness() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getLoudness();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_loudness = total/num_song;
	}
	
	/**
	 * Returns the average loudness quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgLoudness() {
		if (this.avg_loudness == 0.0) {
			this.setAvgLoudness();
		}
		return avg_loudness;
	}
	
	/**
	 * Sets the average mode quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgMode() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getMode();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_mode = total/num_song;
	}
	
	/**
	 * Returns the average mode quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgMode() {
		if (this.avg_mode == 0.0) {
			this.setAvgMode();
		}
		return avg_mode;
	}
	
	/**
	 * Sets the average speechiness quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgSpeechiness() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getSpeechiness();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_speechiness = total/num_song;
	}
	
	/**
	 * Returns the average speechiness quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgSpeechiness() {
		if (this.avg_speechiness == 0.0) {
			this.setAvgSpeechiness();
		}
		return avg_speechiness;
	}
	
	/**
	 * Sets the average tempo quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgTempo() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getTempo();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_tempo = total/num_song;
	}
	
	/**
	 * Returns the average tempo quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgTempo() {
		if (this.avg_tempo == 0.0) {
			this.setAvgTempo();
		}
		return avg_tempo;
	}
	
	/**
	 * Sets the average valence quality in the graph, going through the each node/songObject in the list
	 */
	public void setAvgValence() {
		double total = 0;
		int num_song = 0;
		Node cur_node = node_list.get(0);
		while(!(cur_node.adjlist.isEmpty())) {
			total += cur_node.song.getValence();
			cur_node = cur_node.adjlist.get(0);
			num_song++;
		}
		this.avg_valence = total/num_song;
	}
	
	/**
	 * Returns the average valence quality in the graph, going through the each node/songObject in the list
	 * @return a double value
	 */
	public double getAvgValence() {
		if (this.avg_valence == 0.0) {
			this.setAvgValence();
		}
		return avg_valence;
	}


	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
