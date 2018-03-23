function addOrder(id,add)
{
    var strreq = "/processorder?id="+id+"&add="+add;
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4)
        {
            location.reload(true);
        }
    }
    req.open("GET", strreq, true);
    req.send(null);
}

