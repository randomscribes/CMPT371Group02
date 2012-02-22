<%-- 
    Document   : addRemoveTeam
    Created on : 2011-10-19, 23:00:49
    Author     : Steph W
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="Connection.ConnectionManager" import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Admin - Add/Remove Teams</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/adminTemplate.css">
        <link rel="stylesheet" href="css/tableTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="js/ajaxAddRemoveTeam.js"></SCRIPT>

    </head>

    <body>
        <div class="header row">
            <div id="header">
                <h1>Admin - Add/Remove Teams</h1>
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

                <form name="addATeam">

                    <fieldset>
                        <legend>Add New Team</legend>

                        <div id="fm-opt">
                            <label for="teamName"><h3>Team Name:</h3></label>
                            <input id="teamName" name="team_name" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label><h3>Manager:</h3></label>
                            <select id="manager" name="manager"><option value="">Manager</option>
                                <%-- The following script creates a select menu with every manager in the database as options --%>
                                <%
                                    Connection connection = ConnectionManager.getConnection();
                                    PreparedStatement psmnt = connection.prepareStatement("SELECT user_id, first_name, last_name from users WHERE access = " + 1);
                                    ResultSet rs = psmnt.executeQuery();
                                    while (rs.next()) {
                                        Integer user_id = rs.getInt("user_id");
                                        String first_name = rs.getString("first_name");
                                        String last_name = rs.getString("last_name");
                                %><option value="<%= user_id%>"><%=user_id + " - " + first_name + " " + last_name%></option>
                                <%}
                                    rs.close();
                                    psmnt.close();
                                %>
                            </select>
                        </div>
                        <div id="addTeamFeedback"></div>

                        <div id="fm-submit">
                            <input type="button" value="Add Team" onClick="addTeam()"/>
                        </div>

                    </fieldset>
                </form>

                <form name="removeATeam">

                    <fieldset>
                        <legend>Remove Team</legend>

                        <div id="fm-opt">
                            <label><h3>Team:</h3></label>
                            <select id="remTeam" name="remTeam"><option value="">Team</option>
                                <%-- The following script creates a select menu with every team in the season in the database as options --%>
                                <%

                                    PreparedStatement psmnt1 = connection.prepareStatement("SELECT team_id, team_name from teams WHERE year = " + request.getParameter("season"));
                                    rs = psmnt1.executeQuery();
                                    while (rs.next()) {
                                        Integer team_id_r = rs.getInt("team_id");
                                        String team_name = rs.getString("team_name");
                                %><option value="<%= team_id_r%>"><%=team_id_r + " - " + team_name%></option>
                                <%}
                                    rs.close();
                                    psmnt1.close();
                                    connection.close();
                                %>
                            </select>
                        </div>

                        <div id="removeTeamFeedback"></div>

                        <div id="fm-submit">
                            <input type="button" value="Remove Team" onClick="removeTeam()"/>
                        </div>                          

                    </fieldset> 
                </form>

                <form name="otherOptions">

                    <fieldset>
                        <legend>Other Options</legend>
                        <div id="fm-submit">
                            <input type="button" value="View All Teams"  onClick="displayTeam()"/>
                        </div>
                    </fieldset>

                    <input id="year" type="hidden" value="<%= request.getParameter("season")%>"/>       <!-- Hidden field for year-->
                </form>
            </div> 
            <div id="displayTeamFeedback" style="float:right    ;"></div>
        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>