<%-- 
    Document   : mngrProfile
    Created on : Oct 20, 2011, 3:54:53 PM
    Author     : srw565
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="login.userBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Profile</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/playerManagerProfile.css">
        <link rel="stylesheet" href="css/tableTemplate.css">
        <script type="text/javascript" src="js/softedge.js"></script>
        <script type="text/javascript" src="js/ajaxPlayerManagerProfile.js"></script>
    </head>
    <body onLoad="getUpcomingGames(), getAnnouncements(), getMyStats()">
        <div class="header row">
            <div id="header">
                <h1><% userBean currentUser = (userBean) (session.getAttribute("currentSessionUser"));%>
                    <%= currentUser.getFirstName() + " " + currentUser.getLastName()%> - Manager Profile</h1>
            </div>
        </div>

        <div class="body row scroll-y">

            <div id="sidebar">
                <img src="images/profile.jpg" class="profilePicture"/>
                <fieldset style="border-top:0px;width:250px;">
                    <p id="userInfo"><b>Name:</b> <%= currentUser.getFirstName() + " " + currentUser.getLastName()%></p>
                    <p id="userInfo"><b>Address:</b> <%= currentUser.getAddress()%></p>
                    <p id="userInfo"><b>Birth Date:</b> <%= currentUser.getBirthdate()%></p>
                    <p id="userInfo"><b>Phone Number:</b> <%= currentUser.getPhone_number()%></p>

                    <p id="link"><a href="http://google.ca">Google</a></p>
                    <p id="link"><a href="http://www.fifa.com/index.html?language=en">FIFA</a></p>
                    <p id="link"><a href="http://ca.yahoo.com/?p=us">Yahoo</a></p>
                    <p id="link"><a href="http://www.stupidvideos.com/">Stupid Videos</a></p>
                </fieldset>
            </div>

            <div id="main">

                <form action="LogoutServlet" method="post">
                    <div id="fm-submit">
                        <button type="submit" style="float:right;width:100px;">Logout</button>
                    </div>
                </form>

                <div id="container">                  
                    <fieldset>
                        <legend>Announcements</legend>
                        <form id="getAnnouncementsForm">
                            <input type="hidden" id="team_id" value="<%= currentUser.getTeam_id()%>" />
                        </form>
                        <div id="announcementsbox">
                            Announcements go here.
                        </div>

                        <form class="PostAnnouncementBox" name="PostAnnouncementBox">
                            <div id="managersannouncements">
                                <textarea id="textArea" name="announcementArea" rows="7"></textarea><br/>
                            </div>
                        </form>

                        <form id="postAnnouncementForm">
                        </form> 
                    </fieldset>

                    <div id="fm-submit">
                        <button type="submit" value="post" onClick="post(), getAnnouncements()">Post</button> 
                        <input type="hidden" id="user_id" value="<%= currentUser.getUser_id()%>" />
                        <input type="hidden" id="access" value="<%= currentUser.getAccessLevel()%>" />
                    </div>

                    <div id="message"></div>

                    <fieldset>
                        <legend>Upcoming Games</legend>
                        <form id="getUpcomingGamesForm">
                            <input type="hidden" id="user_id" value="<%= currentUser.getUser_id()%>" />
                        </form>
                        <div id="upcomingGames">
                            Upcoming games go here.
                        </div>
                        <form id="getFullScheduleForm">
                            <div id="fm-submit">
                                <input type="hidden" id="user_id_disp" value="<%= currentUser.getUser_id()%>" />
                                <input type="button" value="See Full Schedule" onClick="displaySchedule()"/>
                            </div>
                            <div id="displayScheduleFeedback">

                            </div>
                        </form>
                    </fieldset>

                    <fieldset>
                        <legend>My Stats</legend>
                        <form id="getMyStatsForm">
                            <!-- get the stats here. Maybe don't need a form, can just use ajax javascript function -->
                            <input type="hidden" id="user_id_stats" value="<%= currentUser.getUser_id()%>" />
                        </form>
                        <div id="myStats">
                            My stats go here.
                        </div>
                    </fieldset>						
                </div>

            </div>


        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>
