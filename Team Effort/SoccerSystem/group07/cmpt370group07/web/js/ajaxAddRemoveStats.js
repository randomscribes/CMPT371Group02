/**
 * This method is for putting the game ID of a selected game into the corresponding textbox
 */
function displayGameID(){
    document.getElementById("gameID").value = document.getElementById("game").value;
}  

/**
 * This is for resetting the dropdown when anything is typed in the corresponding textbox
 */
function resetResultSelect(){
    document.getElementById("game").value = "";
}

/**
 * This method is for putting the game ID of a selected game into the corresponding textbox
 */
function displayGoalGameID(){
    document.getElementById("goalGameID").value = document.getElementById("game_id").value;
}  

/**
 * This is for resetting the dropdown when anything is typed in the corresponding textbox
 */
function resetGoalGameSelect(){
    document.getElementById("game_id").value = "";
}



/**
 * This method adds a goal to the database, and adds a goal to the home team's 
 * score for the selected game in the database.
 */
function addHomeGoal(){
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
            document.getElementById("home_feedback").innerHTML =
            xmlhttp.responseText;
            displayGoalsResult();
        //document.addNewGame.reset();               
        }
    }
                
    ///DO THIS        
    var params = "game_id=" + document.getElementById("game_id").value + 
    "&scorePlayer=" + document.getElementById("homeGoalScorer").value +
    "&assistPlayer=" + document.getElementById("homeAssistor").value +
    "&game_type=home";
    xmlhttp.open("POST", "addGoalServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}

/**
 * This method adds a goal to the database, and adds a goal to the away team's 
 * score for the selected game in the database.
 */
function addAwayGoal(){
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
            document.getElementById("away_feedback").innerHTML =
            xmlhttp.responseText;
            displayGoalsResult();
        //document.addNewGame.reset();               
        }
    }
                
    ///DO THIS        
    var params = "game_id=" + document.getElementById("game_id").value + 
    "&scorePlayer=" + document.getElementById("awayGoalScorer").value +
    "&assistPlayer=" + document.getElementById("awayAssistor").value +
    "&game_type=away";
    xmlhttp.open("POST", "addGoalServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}

/**
 * This method removes a goal from the database, and removes a goal from the home team's 
 * score for the selected game in the database.
 */
function removeHomeGoal(){
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
            document.getElementById("home_feedback").innerHTML =
            xmlhttp.responseText;
            displayGoalsResult();
        //document.addNewGame.reset();               
        }
    }
                
    ///DO THIS        
    var params = "game_id=" + document.getElementById("game_id").value + 
    "&scorePlayer=" + document.getElementById("homeGoalScorer").value +
    "&assistPlayer=" + document.getElementById("homeAssistor").value+
    "&game_type=home";
    xmlhttp.open("POST", "removeGoalServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}

/**
 * This method removes a goal from the database, and removes a goal from the away team's 
 * score for the selected game in the database.
 */
function removeAwayGoal(){
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
            document.getElementById("away_feedback").innerHTML =
            xmlhttp.responseText;
            displayGoalsResult();
        //document.addNewGame.reset();               
        }
    }
                
    ///DO THIS        
    var params = "game_id=" + document.getElementById("game_id").value + 
    "&scorePlayer=" + document.getElementById("awayGoalScorer").value +
    "&assistPlayer=" + document.getElementById("awayAssistor").value+
    "&game_type=away";
    xmlhttp.open("POST", "removeGoalServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}







/**
 * This method display a table for each team of the game with all the players
 * and their number of goals and assists.
 */
function displayGoalsResult() {
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
            document.getElementById("addGoalFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "game_id=" + document.getElementById("game_id").value;
    xmlhttp.open("POST", "displayStatsServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

/**
 * This method displays the final score of the game as it is updated.
 */
function displayFinalScore() {
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
            document.getElementById("displayScoreFeedback").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "game_id=" + document.getElementById("game_id").value;
    xmlhttp.open("POST", "displayFinalScoreServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}

/**
 * This method displays the final score of the game as it is updated.
 */
function displayGameStatus() {
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
            document.getElementById("gameStatus").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "game_id=" + document.getElementById("game_id").value;
    xmlhttp.open("POST", "displayGameStatusServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}

function submitFinalResult(){
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
            
    //document.addNewGame.reset();               
    }
    }
                
    ///DO THIS        
    var params = "game_id=" + document.getElementById("game_id").value;
    xmlhttp.open("POST", "submitFinalResultServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}