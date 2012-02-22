<%-- 
    Document   : addRemoveStats
    Created on : Nov 3, 2011, 6:19:30 PM
    Author     : Simon Fanner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="Connection.ConnectionManager" import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Admin - Add Remove Stats</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/addRemoveStats.css">
        <link rel="stylesheet" href="css/tableTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="js/ajaxAddRemoveStats.js"></SCRIPT>

    </head>

    <body onload="displayGoalsResult(), displayFinalScore(), displayGameStatus()">
        <div class="header row">
            <div id="header">
                <h1>Admin - Edit Stats</h1>
            </div>
        </div>

        <div class="body row scroll-y">
            <div id="fm-submit" style="padding-top:0em; height:30px; border-bottom: 6px double #000">
                <ul id="menu">
                    <li><img src="images/Menu-icon.png" >
                        <ul id="fullMenu">
                            <li><form action="homeButtonServlet" method="post"><button type="submit">Home</button></form></li>
                            <form id="adminform" action="adminController">
                                <input type="hidden" id="menuSeason" name="Season" value="<% out.println(request.getParameter("season")); %>">
                                <li><button name="buttonPressed" value="Add/Remove Team" type="submit">Add/Remove Team</button></li>
                                <li><button name="buttonPressed" value="Add/Remove User" type="submit">Add/Remove User</button></li>
                                <li><button name="buttonPressed" value="Edit Rosters" type="submit">Edit Rosters</button></li>
                                <li><button name="buttonPressed" value="Edit Schedule" type="submit">Edit Schedule</button></li>
                                <li><button type="submit" value="Update Stats" name="buttonPressed">Update Stats</button></li>
                                <li><button type="submit" value="Post Announcement" name="buttonPressed">Post Announcement</button></li>
                            </form>
                            <li><form action="LogoutServlet" method="post"><button type="submit">Logout</button></form></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div id="container">

                <form name="homeTeamStats">

                    <fieldset>
                        <legend>Home Team Stats</legend>

                        <div id="fm-opt">
                            <label><h3>Goal:</h3></label>
                            <select id="homeGoalScorer" name="homeGoalScorer"><option value="">Select Player</option>
                                <%-- The following script creates a dropdown with the players of the home team as its options--%>
                                <%
                                    Statement st;
                                    String home_team, away_team, sql;
                                    Connection connection = ConnectionManager.getConnection();
                                    st = connection.createStatement();
                                    PreparedStatement psmnt = connection.prepareStatement("SELECT user_id, first_name, last_name FROM users WHERE team_id=" + request.getParameter("home_team"));
                                    ResultSet rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer user_id = rs.getInt("user_id");
                                        String first_name = rs.getString("first_name");
                                        String last_name = rs.getString("last_name");

                                %><option value="<%= user_id%>"><%=first_name + " " + last_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>
                        <div id="fm-opt">
                            <label><h3>Assist:</h3></label>
                            <select id="homeAssistor" name="homeAssistor"><option value="">Unassisted</option>
                                <%-- The following script creates a dropdown with the players of the home team as its options--%>
                                <%
                                    st = connection.createStatement();
                                    psmnt = connection.prepareStatement("SELECT user_id, first_name, last_name FROM users WHERE team_id=" + request.getParameter("home_team"));
                                    rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer user_id = rs.getInt("user_id");
                                        String first_name = rs.getString("first_name");
                                        String last_name = rs.getString("last_name");

                                %><option value="<%= user_id%>"><%=first_name + " " + last_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>

                        <div id="fm-submit">
                            <input name="Add Stat" type="button" value="Add Stat" onClick="addHomeGoal(),displayFinalScore()"/>
                            <input name="Remove Stat" type="button" value="Remove Stat" onClick="removeHomeGoal(),displayFinalScore()"/>
                        </div>  


                        <input id="game_id" type="hidden" value="<%= request.getParameter("game_id")%>"/>
                        <input id="home_team" type="hidden" value="<%= request.getParameter("home_team")%>"/>

                        <div id="home_feedback"></div>


                        <div id="displayScoreFeedback" style="float:left;"></div>

                    </fieldset>
                </form>

                <form name="awayTeamStats">

                    <fieldset>
                        <legend>Away Team Stats</legend>

                        <div id="fm-opt">
                            <label><h3>Goal:</h3></label>
                            <select id="awayGoalScorer" name="awayGoalScorer"><option value="">Select Player</option>
                                <%-- The following script creates a dropdown with the players of the away team as its options--%>
                                <%
                                    st = connection.createStatement();
                                    psmnt = connection.prepareStatement("SELECT user_id, first_name, last_name FROM users WHERE team_id=" + request.getParameter("away_team"));
                                    rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer user_id = rs.getInt("user_id");
                                        String first_name = rs.getString("first_name");
                                        String last_name = rs.getString("last_name");

                                %><option value="<%= user_id%>"><%=first_name + " " + last_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>
                        <div id="fm-opt">
                            <label><h3>Assist:</h3></label>
                            <select id="awayAssistor" name="awayAssistor"><option value="">Unassisted</option>
                                <%-- The following script creates a dropdown with the players of the away team as its options--%>
                                <%
                                    st = connection.createStatement();
                                    psmnt = connection.prepareStatement("SELECT user_id, first_name, last_name FROM users WHERE team_id=" + request.getParameter("away_team"));
                                    rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer user_id = rs.getInt("user_id");
                                        String first_name = rs.getString("first_name");
                                        String last_name = rs.getString("last_name");

                                %><option value="<%= user_id%>"><%=first_name + " " + last_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                    connection.close();
                                %>
                            </select>
                        </div>

                        <div id="fm-submit">
                            <input name="Add Stat" type="button" value="Add Stat" onClick="addAwayGoal(),displayFinalScore()"/>
                            <input name="Remove Stat" type="button" value="Remove Stat" onClick="removeAwayGoal(),displayFinalScore()"/>
                        </div>    

                        <div id="away_feedback"></div>
                        <input name="game_id" type="hidden" value="<%request.getParameter("game_id");%>"/>
                        <input name="away_team" type="hidden" value="<%request.getParameter("away_team");%>"/>

                        <div id="fm-submit">
                            <label><h3>Game Status:</h3></label>
                            <div id="gameStatus" name="gameStatus" value="gameStatus"></div><br/>
                            <input name="Submit Final Result" type="button" id="status" value="Submit Final Result" onclick="submitFinalResult(), displayGameStatus()"/>
                        </div>


                    </fieldset>
                </form>     

            </div> 


            <div id="addGoalFeedback" style="float:right;"></div>

        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>