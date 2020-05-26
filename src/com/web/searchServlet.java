/**
*  @author Namik Karaata
*  @date April 11, 2020 (Last Revised)
*  @file searchServlet.java
*/

package com.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
* @brief a java module to connect front-end and server-side scripting
*/
public class searchServlet extends HttpServlet {

	/**
	* @brief a method to recieve the user's search request, collect the user input and redirect it to result page
	* @params request HttpServletRequest done by the user from index.html to search for songs
	* @params response HttpServletResponse object
	* @throws IOException, ServletException (for more details please refer to official Oracle Java Servlet Documentation)
	*/
    public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

    	/**
    	 * get session to persist data during the application lifecycle
    	 */
    	HttpSession session = request.getSession();
    	
    	/**
    	 * get user inputs from HTML form element of the index.html
    	 */
    	int time = Integer.parseInt(request.getParameter("time"));
    	String artistName = request.getParameter("artistName");
    	String keyword = request.getParameter("keyword");
    	if(keyword.length() != 0) {
    		keyword = " ";
        	keyword += request.getParameter("keyword");
        	keyword += " ";
    	}
    	String acousticness = request.getParameter("acousticness");
    	String danceability = request.getParameter("danceability");
    	String energy = request.getParameter("energy");
    	String instrumentalness = request.getParameter("instrumentalness");
    	String liveleness = request.getParameter("liveleness");
    	String loudness = request.getParameter("loudness");
    	String speechiness = request.getParameter("speechiness");
    	String tempo = request.getParameter("tempo");
    	String valence = request.getParameter("valence");
    	
    	/**
    	 * add user input to ArrayList<String> to pass to result.jsp
    	 */
    	ArrayList<String> filters = new ArrayList<String>();
    	filters.add(artistName);
    	filters.add(keyword);
    	filters.add(acousticness);
    	filters.add(danceability);
    	filters.add(energy);
    	filters.add(instrumentalness);
    	filters.add(liveleness);
    	filters.add(loudness);
    	filters.add(speechiness);
    	filters.add(tempo);
    	filters.add(valence);
    	
    	/**
    	 * Change the name of the arraylist to which time user searches - 1 for indexing purposes
    	 */
    	int t = time - 1;
    	String searchTime = "list" + t;
    	
    	/**
    	 * Store the user input in a session to use later if the user makes multiple queries
    	 */
    	session.setAttribute(searchTime, filters);   	   	
    	
    	/**
    	 * Convert user input to string to check in the log of the result.jsp
    	 */
    	String userInput = " Artist Name is: " + artistName + " keyword is: " + keyword + "\n";
    	userInput += "Acousticness: " + acousticness + "\n Danceability: " + danceability
    			+ "\n Energy: " + energy + "\n Instrumentalness: " + instrumentalness
    			+ "\n Liveleness: " + liveleness + "\n Loudness: " + loudness + "\n Speechiness: " + 
    			speechiness + "\n Tempo: " + tempo + "\n Valence: " + valence;
    	    	
    	/**
    	 * Send data to result.jsp and redirect user to result.jsp page
    	 */
    	request.setAttribute("UserInput", userInput);
    	request.setAttribute("time", time);
    	request.setAttribute("input", filters);
    	request.getRequestDispatcher("/result.jsp").forward(request, response);
    	response.sendRedirect("/filtrack/result.jsp");
    	
	}
    

}
