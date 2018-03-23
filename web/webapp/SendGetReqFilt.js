function sendGetRequest(lang)
{
    var from = document.getElementById("filterFrom").value;
    var to = document.getElementById("filterTo").value;
    var state = {'page_id':1, 'user_id': 1};
    var strreq = "/products?lang=" + lang + "&from=" + from + "&to="+ to + "&filter=1";
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4)
        {
            //Передаем управление обработчику пользователя
            handlerResponse(req.responseText);
        }
    }
    req.open("GET", strreq, true);
    req.send(null);
}

function handlerResponse(txt)
{
    document.getElementById("cardsContainer").innerHTML="";
    document.getElementById("cardsContainer").innerHTML=txt;
    location.reload(true);
}