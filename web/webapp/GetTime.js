function getTime() {
    var obj = document.getElementById('clock');
    var req;

	req = new XMLHttpRequest();

    if (req) {
        req.onreadystatechange = function() {
            if (req.readyState == 4 && req.status == 200)
            { obj.innerHTML = req.responseText;}
        };
        req.open("POST", '/TimeServlet',true);
        req.send(null);
    }
}
setInterval(getTime, 1000);