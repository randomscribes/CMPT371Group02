<%-- 
    Document   : adminHome
    Created on : Oct 20, 2011, 5:29:13 PM
    Author     : srw565
--%>

<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Administrator Home</title>
        <link rel="stylesheet" href="css/template.css">
        <link rel="stylesheet" href="css/adminHome.css">
    </head>

    <body>


        <div class="header row">
            <div id="header">
                <h1>Administrator Menu</h1>
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

                <form id="adminform" action="adminController">
                    <fieldset>
                        <legend>Select Season:</legend>


                        <div id="fm-opt">

                            <label>&#8592; Select season to modify</label>
                            <select name="Season" onChange="document.getElementById('menuSeason').value = this.value">
                                <option value="" selected="selected">Choose a Year</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                            </select>

                        </div>

                    </fieldset>

                    <fieldset>
                        <legend>Select an Option:</legend>

                        <div id="fm-submit">
                            <label>&#8592; Add or remove teams to/from the system</label>
                            <button name="buttonPressed" value="Add/Remove Team" type="submit">Add/Remove Team</button> 
                        </div>

                        <div id="fm-submit">
                            <label>&#8592; Add or remove users to/from the system</label>
                            <button name="buttonPressed" value="Add/Remove User" type="submit">Add/Remove User</button> 
                        </div>


                        <div id="fm-submit">
                            <label>&#8592; Add or remove players to/from a team</label>
                            <button name="buttonPressed" value="Edit Rosters" type="submit">Edit Rosters</button> 
                        </div>

                        <div id="fm-submit">
                            <label>&#8592; Create  and cancel games</label>
                            <button name="buttonPressed" value="Edit Schedule" type="submit">Edit Schedule</button> 
                        </div>

                        <div id="fm-submit">
                            <label>&#8592; Enter game stats and results</label>
                            <button type="submit" value="Update Stats" name="buttonPressed">Update Stats</button> 
                        </div>

                        <div id="fm-submit">
                            <label>&#8592; Post Announcements</label>
                            <button type="submit" value="Post Announcement" name="buttonPressed">Post Announcement</button> 
                        </div>                            

                    </fieldset>                       

                </form>
            </div>

        </div>             

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>