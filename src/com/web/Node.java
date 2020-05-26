package com.web;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffrey Dang
 * Node class representing a node like object that consists of data of a SongOBject
 */
public class Node {
	List<Node> adjlist;
	boolean marked;
	SongObject song;
	Node edgeTo;
	
	
	
	/**
	 * Constructor for the node object
	 * @param song a SongObject
	 */
	Node(SongObject song){           //stores names
		this.song = song;
		this.adjlist=new ArrayList<>();	
	}
	
	/**
	 * Returns the name of the song in the Node
	 * @return String representing the name of the song
	 */
	public String getName(){
		String song_name = this.song.getSong();
		return song_name;
	}
	
	/**
	 * Adds a node to the adjacenecy list of the node
	 * @param adjNode adds the inputted node to the current node's adajacency list
	 */
	public void addAdj(Node adjNode) {
		this.adjlist.add(adjNode);
	}
	
	/**
	 * Returns a node with the same songObj
	 * @param song A songObj
	 * @return A new node with the data of a songObject
	 */
	public Node returnNode(SongObject song) {
		Node newnode = new Node(song);
		return newnode;
	}
	
	/**
	 * Returns the adjacency list of the current node
	 * @return List of Nodes
	 */
	public List<Node> returnAdj() {   //returns the adjacencyList
		return adjlist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
