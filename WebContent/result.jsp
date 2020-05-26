<%
	/**
	*  @author Namik Karaata
	*  @date April 11, 2020 (Last Revised)
	*  @file result.jsp
	*/
%>
<%@ page import="java.util.*, com.web.*" %>

<html>

<head>
<link rel="stylesheet" type="text/css" href="css/result.css">
</head>

<body>
	<header>
	<h1 align="center">Filtrack Results</h1>
	</header>
	
	<p>
		Here are your inputs:
	</p>

	<%
		/**
		*  Get the user input from the searchServlet.java and display back to the user
		*/
		HttpSession ses = request.getSession();
		ArrayList<String> input = (ArrayList<String>) request.getAttribute("input");
		String[] params = {"Artist Name: ", "Keyword: ", "Acousticness: ", "Danceability: ", 
				"Energy: ", "Instrumentalness: ", "Liveleness: ", "Loudness: ", "Speechiness: ",
				"Tempo: ", "Valence: "};
		
		int time = (Integer) request.getAttribute("time");
		for(int i = time-1; i >= 0; i--){
			String t = "list" + i;
			ArrayList<String> in = (ArrayList<String>) ses.getAttribute(t);
			out.print("<ul>");
			for(int j = 0; j < in.size(); j++){
				out.print("<li>" + params[j] + in.get(j));
			}
			out.print("</ul>");
		}
		
	%>
	
	<p>
		Here are our top 25 song recommendations:
	</p>
	
	<%
		/**
		* ****************Search algorithm**********************
		* Calling Search algorithm to find songs that match user input of artist name or keyword then generate a song recommendation
		* list of the top 25 matches
		*/
		String artistName = input.get(0);
		String keyWord = input.get(1);
		ArrayList<SongObject> recommendation;
		recommendation = mainSearch.searchResult(keyWord, artistName);
		
	
		/**
		* **************Merge Sort Algorithm**************************
		* Calling merge sort algorithm to sort the recommended songs based on user preferences (e.g energy: from high to low)
		*/
		ArrayList<String> prefs = new ArrayList<String>(input.subList(2, 11));
		SongObject[] recArr = recommendation.toArray(new SongObject[recommendation.size()]);
		String[] pref = prefs.toArray(new String[prefs.size()]);
		MergeSort.sort(recArr, pref);
		
		/**
		* N to only return the top 25 matches or less
		*/
		int N = 25;
		if(N > recArr.length){
			N = recArr.length;
		}
		
		out.print("<ol>");
		for(int i = 0; i < N; i++){
			out.print("<li>" + recArr[i].getSong() + ", by: " + recArr[i].getArtist() + ", Album: " + recArr[i].getAlbum()
					+ ", Release Date: " + recArr[i].getDate());
		}
		out.print("</ol>");
		
		/**
		* ***********Graph Algorithm****************************
		* Calling the graph algorithm to generate a playlist for the user
		*/
		if(recommendation.size() == 0){
			out.print("<br> No songs find please make another search!");
		}else{
			ArrayList<SongObject> play = new ArrayList<SongObject>();
			for(int i = time-1; i >= 0; i--){
				String t = "list" + i;
				ArrayList<String> in = (ArrayList<String>) ses.getAttribute(t);
				play.addAll(mainSearch.searchResult(in.get(1), in.get(0)));
			}
			ArrayList<SongObject> graphRec = Playlist.OneSongSearch(play.get(0), play, N*time, pref);
			out.println("Here is the playlist: ");
			out.println("<br> Playlist is the optimal way to listen the recommended songs.");
			out.println("<br> Tip: To get a better playlist make multiple searches!");
			out.print("<ol>");
			for(int i = 0; i < graphRec.size(); i++){
				out.print("<li>" + graphRec.get(i).getSong() + ", by: " + graphRec.get(i).getArtist() +
						", Album: " + graphRec.get(i).getAlbum()
						+ ", Release Date: " + graphRec.get(i).getDate());
			}
			out.print("</ol>");
			
			/**
			* Convert to percentages and display the average of the qualities in the playlist
			*/
			ArrayList<Node> nodes = Playlist.toNode(graphRec);
			Graph g = new Graph(nodes);
			g.link();
			out.print("Here are some fun facts about your playlist: ");
			out.print("<p>");
			out.print("Average acousticness: " + (int) (100 * g.getAvgAcousticness()) + "% Average danceability: " + (int) (100 * g.getAvgDanceability()) + "%");
			out.print("<br> Average energy: " + (int) (100 * g.getAvgEnergy()) + "% Average instrumentalness: " + (int) (100 * g.getAvgInstrumental()) + "%");
			out.print("<br> Average liveleness: " + (int) (100 * g.getAvgLiveness()) + "% Average speechiness: " + (int) (100 * g.getAvgSpeechiness()) + "%");
			out.print("<br> Average valence: " + (int) (100 * g.getAvgValence()) + "%");
			out.print("</p>");
		}
	%>
	
	<div id="newSearch">
	<a href="index.html">Make Another Search</a>
	</div>
	
		<footer>
        	FilTrack is developed by Group 2.<br>
        	Copyright FilTrack 2020 &copy;
        </footer>

</body>
</html> 