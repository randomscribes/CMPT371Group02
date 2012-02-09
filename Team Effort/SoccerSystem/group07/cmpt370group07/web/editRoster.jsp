<%-- 
    Document   : editRoster
    Created on : Nov 1, 2011, 4:43:54 PM
    Author     : paw818
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="Connection.ConnectionManager" import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Admin - Edit Rosters</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/adminTemplate.css">
        <link rel="stylesheet" href="css/tableTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="ajaxEditRoster.js"></SCRIPT>
    </head>

    <body >
        <!-- Begin Header -->
        <div class="header row">
            <div id="header">
                <h1>Admin - Edit Rosters</h1>
            </div>
        </div>
        <!-- End Header -->

        <!-- Begin Wrapper -->
        <div class="body row scroll-y">

            <!-- Begin Content -->
            <div id="fm-submit" style="padding-top:0em; height:30px; border-bottom: 6px double #000">
                <form action="homeButtonServlet" method="post">
                    <button type="submit" style="float:left;width:100px;">Home</button>
                </form>
                <form action="LogoutServlet" method="post">
                    <button type="submit" style="float:right;width:100px;">Logout</button>
                </form>
            </div>

            <div id="container">

                <form name="addToRoster" >

                    <fieldset>
                        <legend>Assign/Change User's Team</legend>

                        <div id="fm-opt">
                            <label for="userID"><h3>User ID:</h3></label>
                            <input id="add_user_id" name="user_id" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label><h3>Team:</h3></label>
                            <select id="addTeam" name="addTeam"><option value="">Team</option>
                                <%-- The following script creates a select menu with every team in the season in the database as options. --%>
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
                        <div id="addToRosterFeedback"></div>

                        <div id="fm-submit">
                            <input type="button" value="Assign Team" type="submit" onClick="addUser()" />
                        </div>

                    </fieldset>
                </form>

                <form name ="removeFromRoster">

                    <fieldset>
                        <legend>Remove User From Team</legend>

                        <div id="fm-opt">
                            <label for="user_id"><h3>User ID:</h3></label>
                            <input id="rem_user_id" name="user_id" type="text" />
                        </div>

                        <div id="removeFromRosterFeedback"></div>


                        <div id="fm-submit">
                            <input type="button" name="request" value="Remove Player" type="submit" onClick="removeUser()" />
                        </div>                          

                    </fieldset> 
                </form>
                <form name ="viewTeamRoster">

                    <fieldset>
                        <legend>View A Team's Roster</legend>

                        <div id="fm-opt">
                            <label><h3>Team:</h3></label>
                            <select id="viewTeam" name="viewTeam"><option value="">Team</option>
                                <%-- The following script creates a select menu with every team in the season in the database as options. --%>
                                <%
                                    connection = ConnectionManager.getConnection();
                                    PreparedStatement psmnt1 = connection.prepareStatement("SELECT team_id, team_name from teams WHERE year = " + request.getParameter("season"));
                                    rs = psmnt1.executeQuery();
                                    while (rs.next()) {
                                        Integer team_id_r = rs.getInt("team_id");
                                        String team_name = rs.getString("team_name");
                                %><option value="<%= team_id_r%>"><%=team_id_r + " - " + team_name%></option>
                                <%}
                                    rs.close();
                                    psmnt1.close();
                                %>
                            </select>
                        </div>




                        <div id="fm-submit">
                            <input type="button" name="request" value="View Team" type="submit" onClick="displayTeam()" />
                        </div>                          

                    </fieldset> 
                </form>
                <form name ="otherOptions">

                    <fieldset>
                        <legend>Other Options</legend>
                        <div id="fm-submit">
                            <input type="button" name="request" value="Display User List" onClick="displayUser()" />
                        </div>
                    </fieldset>


                </form>
            </div>

            <div id="displayUserFeedback" style="float:right;"></div>
        </div>

    </div>

    <!-- Begin Footer -->
    <div class="footer row">
        TeamLeader 2011 &#169;		
    </div>
    <!-- End Footer -->
</body>
</html>
