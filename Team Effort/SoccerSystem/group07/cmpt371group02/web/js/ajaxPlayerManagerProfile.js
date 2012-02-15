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

    var params = "user_id=" + document.getElementById("user_id_disp").value 
    +"&num_games=true";
    xmlhttp.open("POST", "getUpcomingGamesServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

function getAnnouncements() {
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
            document.getElementById("announcementsbox").innerHTML =
            xmlhttp.responseText;                        
        }
    }

    var params = "team_id=" + document.getElementById("team_id").value;
    xmlhttp.open("POST", "getAnnouncementsServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
            
function getUpcomingGames() {
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
            document.getElementById("upcomingGames").innerHTML =
            xmlhttp.responseText;
        }
    }

    var params = "user_id=" + document.getElementById("user_id").value 
    + "&num_games=false";
    xmlhttp.open("POST", "getUpcomingGamesServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
function getMyStats() {
                
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
            document.getElementById("myStats").innerHTML =
            xmlhttp.responseText;             
        }
    }
                
    ///DO THIS        
    var params = "user_id_stats=" + document.getElementById("user_id_stats").value;
    xmlhttp.open("POST", "getMyStatsServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}

function post() {

    var xmlhttp;

    if (window.XMLHttpRequest) {
        xmlhttp=new XMLHttpRequest();
    }

    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            document.getElementById("message").innerHTML=xmlhttp.responseText;
            document.PostAnnouncementBox.reset();
        }
    }

    var params = "messageArea=" + document.getElementById("textArea").value + 
    "&user_id=" + document.getElementById("user_id").value + 
    "&access=" + document.getElementById("access").value;

    xmlhttp.open("POST", "announcementsServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length", params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);
}