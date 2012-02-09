/**
 * This method removes a team from the database and displays a table of all the
 * teams in the database.
 */
function removeTeam() {
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
            document.getElementById("removeTeamFeedback").innerHTML =
            xmlhttp.responseText;
            displayTeam();
            document.addATeam.reset();
            document.removeATeam.reset();

        }
    }

    var params = "remTeam=" +
    document.getElementById("remTeam").value +
    "&year=" + document.getElementById("year").value;
    xmlhttp.open("POST", "removeTeamServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

/**
 * This method displays a table of all team's in the database.
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
            document.getElementById("displayTeamFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "display";
    xmlhttp.open("POST", "displayTeamsServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

/**
 * This method adds a team to the database and displays a table of all the teams
 * in the database.
 */
function addTeam() {

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
            document.getElementById("addTeamFeedback").innerHTML =
            xmlhttp.responseText;
            displayTeam();
            document.addATeam.reset();
            document.removeATeam.reset();

        }
    }


    var params = "team_name=" + document.getElementById("teamName").value + 
    "&manager_id=" + document.getElementById("manager").value +
    "&year=" + document.getElementById("year").value;
    xmlhttp.open("POST", "addTeamServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}