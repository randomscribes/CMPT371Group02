<%-- 
    Document   : editStatss
    Created on : Nov 3, 2011, 6:19:30 PM
    Author     : Simon
--%>

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
        <link rel="stylesheet" href="template.css">
        <link rel="stylesheet" href="adminTemplate.css">
        <link rel="stylesheet" href="tableTemplate.css">
        <SCRIPT LANGUAGE="JavaScript" SRC="ajaxAddRemoveStats.js"></SCRIPT>

    </head>

    <body>
        <div class="header row">
            <div id="header">
                <h1>Admin - Edit Stats</h1>
            </div>
        </div>

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

                <form action="editResultServ" method="post" name="addAResult">

                    <fieldset>
                        <legend>Select A Game</legend>

                        <div id="fm-opt">
                            <label for="game"><h3>Game to edit:</h3></label>
                            <select id="game" name="game" onChange="displayGameID()"><option value="">Select Game</option>
                                <%-- The following script creates a select box with all past games as the options--%>
                                <%
                                    Statement st;
                                    String home_team, away_team, sql;
                                    Connection connection = ConnectionManager.getConnection();
                                    st = connection.createStatement();
                                    PreparedStatement psmnt = connection.prepareStatement("SELECT game_id, home_team, away_team, date FROM games WHERE date <= curdate() ORDER by date");
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

                        <div id="fm-opt">
                            <label for="gameID" ><h3>Or enter gameID:</h3></label>
                            <input id="gameID" name="game_id" type="text" onKeyDown="resetResultSelect()"/>
                        </div>                      


                        <div id="fm-submit">
                            <input name="Edit Result" type="submit" value="Edit Result"/>
                        </div>  

                        <div id="resultFeedback"></div>

                    </fieldset>
                </form>

            </div> 

            <div id="displayUserFeedback" style="float:right;z-index:1;"></div>

        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>


