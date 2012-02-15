/**
 * This method removes a game from the database.
 */
function removeGame() {
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
            document.getElementById("removeGameFeedback").innerHTML =
            xmlhttp.responseText;
            displaySchedule();
            document.removeAGame.reset();
                        
        }
    }

    var params = "game_id=" +
    document.getElementById("rem_game_id").value;
    xmlhttp.open("POST", "removeGameServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
/**
 * This method displays all games for the selected season.
 */            
function displaySchedule() {
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
            document.getElementById("displayScheduleFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "display";
    xmlhttp.open("POST", "displayScheduleServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
/**
 * This method adds a game to the database.
 */            
function addGame() {
                
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
            document.getElementById("addGameFeedback").innerHTML =
            xmlhttp.responseText;
            displaySchedule();
            document.addNewGame.reset();               
        }
    }
                
    ///DO THIS        
    var params = "homeTeam=" + document.getElementById("homeTeam").value + 
    "&awayTeam=" + document.getElementById("awayTeam").value +
    "&location=" + document.getElementById("add_location").value +
    "&date=" + document.getElementById("add_date").value;
    xmlhttp.open("POST", "addGameServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}