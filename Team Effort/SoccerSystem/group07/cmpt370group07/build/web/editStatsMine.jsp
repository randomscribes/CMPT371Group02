<%-- 
    Document   : editStatss
    Created on : Nov 3, 2011, 6:19:30 PM
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="Connection.ConnectionManager" import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Admin - Edit Stats</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/adminTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="ajaxEditStats.js"></SCRIPT>

    </head>

    <body>
        <div class="header row">
            <div id="header">
                <h1>Admin - Edit Stats</h1>
            </div>
        </div>

        <div class="body row scroll-y">
            <form action="LogoutServlet" method="post">
                <div id="fm-submit">
                    <button type="submit" style="float:right;width:100px;">Logout</button>
                </div>
            </form>

            <div id="container">

                <form name="addAResult">

                    <fieldset>
                        <legend>Add Game Result</legend>

                        <div id="fm-opt">
                            <%--label>Game:</label--%>
                            <select id="game" name="game" onChange="displayGameID()"><option value="">Select Game</option>
                                <%
                                    Statement st;
                                    String home_team, away_team, sql;
                                    Connection connection = ConnectionManager.getConnection();
                                    st = connection.createStatement();
                                    PreparedStatement psmnt = connection.prepareStatement("SELECT game_id, home_team, away_team, date FROM games WHERE home_score IS NULL AND away_score IS NULL AND date <= curdate()");
                                    ResultSet rs = psmnt.executeQuery();
                                    ResultSet rs1;
                                    while (rs.next()) {
                                        Integer game_id = rs.getInt("game_id");
                                        Integer home_team_id = rs.getInt("home_team");
                                        Integer away_team_id = rs.getInt("away_team");
                                        Date date = rs.getDate("date");

                                        sql = "SELECT * FROM teams WHERE team_id =" + home_team_id;
                                        rs1 = st.executeQuery(sql);
                                        if (rs1.next()) {
                                            home_team = rs1.getString("team_name");
                                        } else {
                                            home_team = "";
                                        }

                                        sql = "SELECT * FROM teams WHERE team_id =" + away_team_id;
                                        rs1 = st.executeQuery(sql);
                                        if (rs1.next()) {
                                            away_team = rs1.getString("team_name");
                                        } else {
                                            away_team = "";
                                        }
                                %><option value="<%= game_id%>"><%=date + ": " + home_team + " @ " + away_team%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>

                        <div class="gameID">
                            <label for="gameID" >Or enter gameID:</label>
                            <input id="gameID" name="gameID" type="text" onKeyDown="resetResultSelect()"/>
                        </div>    

                        <div class="homeScore">
                            <label for="homeScore">Home Score:</label>
                            <input id="homeScore" name="homeScore" type="text" />
                        </div>

                        <div class="awayScore">
                            <label for="awayScore">Away Score:</label>
                            <input id="awayScore" name="awayScore" type="text" />
                        </div>



                        <div id="fm-submit">
                            <input type="button" value="Add Result" onClick="addResult()"/>
                        </div>

                        <div id="fm-submit">
                            <input type="button" value="Delete Result" onClick="removeResult()"/>
                        </div>

                        <div id="resultFeedback"></div>

                    </fieldset>
                </form>

                <form name="addAPlayerResult">

                    <fieldset>
                        <legend>Add Goal</legend>

                        <div id="fm-opt">

                            <select id="game_id" name="game_id" onChange="displayGoalGameID()"><option value="">Select Game</option>
                                <%

                                    PreparedStatement psmnt3 = connection.prepareStatement("SELECT game_id, home_team, away_team, date FROM games WHERE goals_entered < (home_score + away_score)");
                                    rs = psmnt3.executeQuery();
                                    while (rs.next()) {
                                        Integer game_id = rs.getInt("game_id");
                                        Integer home_team_id = rs.getInt("home_team");
                                        Integer away_team_id = rs.getInt("away_team");
                                        Date date = rs.getDate("date");

                                        sql = "SELECT * FROM teams WHERE team_id =" + home_team_id;
                                        rs1 = st.executeQuery(sql);
                                        if (rs1.next()) {
                                            home_team = rs1.getString("team_name");
                                        } else {
                                            home_team = "";
                                        }

                                        sql = "SELECT * FROM teams WHERE team_id =" + away_team_id;
                                        rs1 = st.executeQuery(sql);
                                        if (rs1.next()) {
                                            away_team = rs1.getString("team_name");
                                        } else {
                                            away_team = "";
                                        }
                                %><option value="<%= game_id%>"><%=date + ": " + home_team + " @ " + away_team%></option>
                                <%}
                                    rs.close();
                                    psmnt3.close();
                                    connection.close();
                                %>
                            </select>
                        </div>

                        <div class="homeScore">
                            <label for="goalGameID">Or enter gameID:</label>
                            <input id="goalGameID" name="goalGameID" type="text" onKeyDown="resetGoalGameSelect()" />
                        </div>  

                        <div class="scorePlayer">
                            <label for="scorePlayer">Scoring Player:</label>
                            <input id="scorePlayer" name="scorePlayer" type="text" />
                        </div>

                        <div class="assistPlayer">
                            <label for="assistPlayer">Assisting Player:</label>
                            <input id="assistPlayer" name="assistPlayer" type="text" />
                        </div>



                        <div id="fm-submit">
                            <input type="button" value="Add Goal" onClick="addGoal()"/>
                        </div>   

                        <div id="fm-submit">
                            <input type="button" value="Delete Goal" onClick="removeGoal()"/>
                        </div>

                        <div id="addGoalFeedback"></div>

                    </fieldset> 
                </form>

                <form name="otherOptions">

                    <fieldset>
                        <legend>Other Options:</legend>
                        <div id="fm-submit">
                            <input type="button" value="View Users" onClick="displayUsers()"/>
                        </div>

                        <div id="fm-submit">
                            <input type="button" value="View Games" onClick="displayGames()"/>
                        </div>

                        <div id="fm-submit">
                            <input type="button" value="View Goals" onClick="displayGoals()"/>
                        </div>
                    </fieldset>

                    <!--<input id="year" type="hidden" value="<%= request.getParameter("season")%>"/>       <!-- Hidden field for year-->
                </form>
            </div> 

            <div id="displayUserFeedback" style="float:right;z-index:1;"></div>

        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>