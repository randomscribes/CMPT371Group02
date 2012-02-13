/**
 * This function displays announcements from the database.
 */
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
            document.getElementById("adminannouncementsbox").innerHTML =
            xmlhttp.responseText; 
            setTimeout('autoRefresh()', 500);
        }
    }

    var params = "team_id=" + document.getElementById("team_id").value;
    xmlhttp.open("GET", "getAdminAnnouncementsServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length", params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send();
}
     
/**
 * This function adds an anouncement to the database and updates the page.
 */
function post() {

    var xmlhttp;

    if (window.XMLHttpRequest) {
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        //IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Your browser does not support XMLHTTP");
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