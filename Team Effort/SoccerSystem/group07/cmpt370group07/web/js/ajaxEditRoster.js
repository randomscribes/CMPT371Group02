/**
 * This removes a user from the roster they're on and displays
 * an update table of the users in the database.
 */
function removeUser() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Your browser does not support XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            document.getElementById("removeFromRosterFeedback").innerHTML =
            xmlhttp.responseText;
            displayUser();
            document.removeFromRoster.reset();
                        
        }
    }

    var params = "user_id=" +
    document.getElementById("rem_user_id").value;
    xmlhttp.open("POST", "removeFromRosterServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
/**
 * This displays a table of all the users in the database
 */            
function displayUser() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Your browser does not support XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            document.getElementById("displayUserFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "display";
    xmlhttp.open("POST", "displayRosterUserServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

/**
 * This displays a single team's roster in a table.
 */
function displayTeam() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Your browser does not support XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            document.getElementById("displayUserFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "viewTeam=" + document.getElementById("viewTeam").value;
    xmlhttp.open("POST", "displayTeamRosterServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
/**
 * This add's a user to a team's roster.
 */            
function addUser() {
                
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Your browser does not support XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            document.getElementById("addToRosterFeedback").innerHTML =
            xmlhttp.responseText;
            displayUser();
            document.addToRoster.reset();
                        
        }
    }
                
                
    var params = "user_id=" + document.getElementById("add_user_id").value + 
    "&addTeam=" + document.getElementById("addTeam").value;
    xmlhttp.open("POST", "addToRosterServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}