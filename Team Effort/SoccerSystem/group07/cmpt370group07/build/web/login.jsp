<%-- 
    Document   : login
    Created on : 2011-10-19, 22:18:24
    Author     : Steph
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
        <title>Login Page</title>
        <link rel="stylesheet" href="template.css">        
        <link rel="stylesheet" href="login.css">
    </head>

    <body>
        <div class="header row">
            <div id="header">
                <h1>TeamLeader Soccer Management System Login</h1>
            </div>
        </div>

        <div class="body row scroll-y">
            <div id="container">
                <form id="loginform" action="LoginServlet">
                    <fieldset>
                        <legend >Login</legend>
                        <div class="username">
                            <label for="username">Username:</label>
                            <input id="username" name="un" type="text" />
                        </div>

                        <div class="password">
                            <label for="password">Password:</label>
                            <input id="password" name="pw" type="password" />
                        </div>                        


                        <div id="fm-submit">
                            <button type="submit">Login</button>
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