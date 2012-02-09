
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
            document.getElementById("removeUserFeedback").innerHTML =
            xmlhttp.responseText;
            displayUser();
            document.removeAUser.reset();
                        
        }
    }

    var params = "user_id=" +
    document.getElementById("user_id").value;
    xmlhttp.open("POST", "removeUserServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
            
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
    xmlhttp.open("POST", "displayUserServ",
        true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}
            
            
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
            document.getElementById("addUserFeedback").innerHTML =
            xmlhttp.responseText;
            displayUser();
            document.addAUser.reset();
                        
        }
    }
                
                
    var params = "first_name=" + document.getElementById("first_name").value + 
    "&last_name=" + document.getElementById("last_name").value +
    "&username=" + document.getElementById("username").value +
    "&password=" + document.getElementById("password").value +
    "&access=" + document.getElementById("access").value;
    xmlhttp.open("POST", "addUserServ", true);
    xmlhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length",
        params.length);
    xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(params);

}