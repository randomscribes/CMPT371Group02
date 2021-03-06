<%-- 
    Document   : postAnnouncement
    Created on : Nov 12, 2011, 1:48:39 PM
    Author     : scb444
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="login.userBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Post Announcement</title>
        <link rel="stylesheet" href="css/template.css">
        <script type="text/javascript" src="js/ajaxAdminProfile.js"></script> 
    </head>

    <body onload="getAnnouncements()">

        <div class="header row">
            <div id="header">
                <h1>Admin - Post Announcement</h1>
                <% userBean currentUser = (userBean) (session.getAttribute("currentSessionUser"));%>
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
                <fieldset>

                    <legend>Announcements</legend>
                    <form id="getAnnouncementsForm">
                        <input type="hidden" id="team_id" value="<%= currentUser.getTeam_id()%>" />
                    </form>
                    <div id="adminannouncementsbox">
                        Announcements go here!
                    </div>

                    <form class="PostAnnouncementBox" name="PostAnnouncementBox">
                        <div id="adminannouncements">
                            <textarea id="textArea" name="messageArea" rows="10" cols="43"></textarea>
                        </div>
                    </form>
                    <div id="fm-submit">

                        <button type="submit" value="post" onClick="post(), getAnnouncements()">Post</button>
                        <input type="hidden" id="user_id" value="<%= currentUser.getUser_id()%>" />
                        <input type="hidden" id="access" value="<%= currentUser.getAccessLevel()%>" />
                    </div>

                </fieldset>

                <div id="message"></div>

            </div>

        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>

    </body>

</html>