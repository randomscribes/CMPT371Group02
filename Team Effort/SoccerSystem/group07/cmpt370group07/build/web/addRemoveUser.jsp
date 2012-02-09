<%-- 
    Document   : addRemoveTeam
    Created on : 2011-10-19, 23:00:49
    Author     : Steph
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
        <SCRIPT LANGUAGE="JavaScript" SRC="js/ajaxAddRemoveUser.js"></SCRIPT>
        <SCRIPT LANGUAGE="JavaScript">
            <!--HIDE


            function checkID()
            {
                var id = parseInt(document.AddUser.user_id.value)
                if (isNaN(id) ) {
                    alert("Please Enter A Valid ID!")   
                    return false   
                }
                
                if (!alert(s.indexOf('0-9')) != -1)
                    alert("Please Enter A Valid ID!")   
                return false 

                return true;
            }

            function checkUser()
            {
                if (document.AddUser.first_name.value == "") {
                    alert("Please Enter First Name!")
                    return false
                }
                if (document.AddUser.last_name.value == "") {
                    alert("Please Enter Last Name!")
                    return false
                }
                if (document.AddUser.username.value == "") {
                    alert("Please Enter Username!")
                    return false
                }
                if (document.AddUser.password.value == "") {
                    alert("Please Enter Password!")
                    return false
                }

                else {
                    return true
                }
            }
        </SCRIPT>
    </head>

    <body >
        <div class="header row">
            <div id="header">
                <h1>Admin - Add/Remove Users</h1>
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

                <form name="addAUser">

                    <fieldset>
                        <legend>Add New User</legend>

                        <div id="fm-opt">
                            <label for="firstName"><h3>First Name:</h3></label>
                            <input id="first_name" name="first_name" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label for="lastName"><h3>Last Name:</h3></label>
                            <input id="last_name" name="last_name" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label for="userName"><h3>Username:</h3></label>
                            <input id="username" name="username" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label for="password"><h3>Password:</h3></label>
                            <input id="password" name="password" type="text" />
                        </div>

                        <div id="fm-opt">
                            <label><h3>User Type:</h3></label>
                            <select id="access" name="access">
                                <option value="0" selected="selected">Player</option>
                                <option value="1">Manager</option>
                                <option value="2">Administrator</option>
                            </select>
                        </div>
                        <div id="addUserFeedback"></div>

                        <div id="fm-submit">
                            <input type="button" name="request" value="Add User" onClick="addUser()" />
                        </div>

                    </fieldset>
                </form>

                <form name="removeAUser">
                    <fieldset>
                        <legend>Remove User</legend>

                        <div id="fm-opt">
                            <label for="user_id"><h3>UserID:</h3></label>
                            <input id="user_id" name="user_id" type="text" />
                        </div>
                        <div id="removeUserFeedback"></div>



                        <div id="fm-submit">
                            <input type="button" name="request" value="Remove User" onClick="removeUser()" />
                        </div>



                    </fieldset> 
                </form>

                <form name="otherOptions">
                    <fieldset>
                        <legend>Other Options:</legend>
                        <div id="fm-submit">
                            <input type="button" name="request" value="Display User List" onClick="displayUser()" />
                        </div>
                    </fieldset>
                </form>

            </div>

            <div id="displayUserFeedback" style="float:right;"></div>
        </div>

        <div class="footer row">
            TeamLeader 2011 &#169;
        </div>
    </body>
</html>