function setDefaultTab(param) {
    var strreq = "/setab?tab=" + param;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4)
        {
        }
    }
    req.open("GET", strreq, true);
    req.send(null);
}