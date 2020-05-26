package com.web;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

/*
 * @author Jeffrey Dang
 * Dfs_song class controls the dfs algorithm through a given song_list
 * 
 */
public class Dfs_song {
	private Stack<Node> song_list;
	private ArrayList<String> pathlist;
	
	
	/*
	 * Processes through the path 
	 */
	public ArrayList<String> processPath() {
		for (Node x : song_list) {
//			System.out.print(x.name + ",");
			pathlist.add(x.getName());
		}
		return pathlist;
	}
	
	/*
	 * Constructor for a Dfs_song
	 */
	public Dfs_song() {
		song_list = new Stack<Node>();
		pathlist = new ArrayList<String>();
	}
	
	/*
	 * at given start and end Node, will run through till it finds the first path between the two Nodes in from a String
	 * @return returns ArrayList of String
	 */
	public ArrayList<String> dfs(Node start, Node end) {
		start.marked = true;
		song_list.push(start);
		if (start == end) {
			pathlist = processPath();
			return pathlist;
		}
		else {
			for (Node x : start.returnAdj()) {
				if (x.marked == false && x != null) {
					dfs(x,end);
				}
			}
		}
		song_list.pop();
		return pathlist;
		
		
	}

}
