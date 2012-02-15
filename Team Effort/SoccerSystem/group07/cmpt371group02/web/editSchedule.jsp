<%-- 
    Document   : editSchedule
    Created on : Nov 3, 2011, 6:09:32 PM
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="Connection.ConnectionManager" import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Admin - Edit Schedule</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/adminTemplate.css">
        <link rel="stylesheet" href="css/tableTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="js/ajaxEditSchedule.js"></SCRIPT>

    </head>

    <body >
        <!-- Begin Header -->
        <div class="header row">
            <div id="header">
                <h1>Admin - Edit Schedule</h1>
            </div>
        </div>
        <!-- End Header -->

        <!-- Begin Wrapper -->
        <div class="body row scroll-y">

            <div id="fm-submit" style="padding-top:0em; height:30px; border-bottom: 6px double #000">
                <form action="homeButtonServlet" method="post">
                    <button type="submit" style="float:left;width:100px;">Home</button>
                </form>
                <form action="LogoutServlet" method="post">
                    <button type="submit" style="float:right;width:100px;">Logout</button>
                </form>
            </div>

            <div id="container">

                <form name="addNewGame" >

                    <fieldset>
                        <legend>Add A Game To Schedule</legend>

                        <div id="fm-opt">
                            <label for="date"><h3>Date:</h3></label>
                            <input id="add_date" name="date" type="text" />
                        </div>
                        <div id="fm-opt">
                            <label for="location"><h3>Location:</h3></label>
                            <input id="add_location" name="location" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label><h3>Home Team:</h3></label>
                            <select id="homeTeam" name="homeTeam"><option value="">Home Team</option>
                                <%--The following script creates a dropdown with all teams for the selected season as it's input --%>
                                <%
                                    Connection connection = ConnectionManager.getConnection();
                                    PreparedStatement psmnt = connection.prepareStatement("SELECT team_id, team_name from teams WHERE year = " + request.getParameter("season"));
                                    ResultSet rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer team_id_r = rs.getInt("team_id");
                                        String team_name = rs.getString("team_name");
                                %><option value="<%= team_id_r%>"><%=team_id_r + " - " + team_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>

                        <div id="fm-opt">
                            <label><h3>Away Team:</h3></label>
                            <select id="awayTeam" name="awayTeam"><option value="">Away Team</option>
                                <%--The following script creates a dropdown with all teams for the selected season as it's input --%>
                                <%
                                    Connection connection1 = ConnectionManager.getConnection();
                                    PreparedStatement psmnt1 = connection1.prepareStatement("SELECT team_id, team_name from teams WHERE year = " + request.getParameter("season"));
                                    ResultSet rs1 = psmnt1.executeQuery();
                                    while (rs1.next()) {
                                        Integer team_id_r = rs1.getInt("team_id");
                                        String team_name = rs1.getString("team_name");
                                %><option value="<%= team_id_r%>"><%=team_id_r + " - " + team_name%></option>
                                <%}
                                    rs1.close();
                                    psmnt1.close();
                                %>
                            </select>
                        </div>

                        <div id="addGameFeedback"></div>

                        <div id="fm-submit">
                            <input type="button" value="Add Game"  onClick="addGame()" /> <!type="submit">
                        </div>

                    </fieldset>
                </form>

                <form name ="removeAGame">

                    <fieldset>
                        <legend>Remove Game From Schedule</legend>

                        <div id="fm-opt">
                            <label for="game_id"><h3>Game ID:</h3></label>
                            <input id="rem_game_id" name="game_id" type="text" />
                        </div>

                        <div id="removeGameFeedback"></div>


                        <div id="fm-submit">
                            <input type="button" name="request" value="Remove Game" type="submit" onClick="removeGame()" />
                        </div>                          

                    </fieldset> 
                </form>
                <form name ="otherOptions">

                    <fieldset>
                        <legend>Other Options</legend>
                        <div id="fm-submit">
                            <input type="button" name="request" value="Display Schedule" onClick="displaySchedule()" />
                        </div>
                    </fieldset>


                </form>
            </div>

            <div id="displayScheduleFeedback" style="float:right;"></div>
        </div>


        <!-- Begin Footer -->
        <div class="footer row">
            TeamLeader 2011 &#169;		
        </div>
        <!-- End Footer -->
    </body>
</html>
