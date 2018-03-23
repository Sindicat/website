function sendAjaxRequest(value) {
        var message = "message="+document.getElementById("textArea").value+value;
        document.getElementById("textArea").value="";
        var request = new XMLHttpRequest();
        var url = "/CommentHandler";
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var message = JSON.parse(request.response);
                addComment(message);

            }
        };
        request.open("post", url);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send(message);
}

function addComment(content) {
    for(var i=0; i<Object.keys(content).length; ++i)
    {
        var div = document.createElement("div");
        div.className="w3-pannel w3-topbar w3-border-blue";

        var div1 = document.createElement("div");
        div1.innerHTML = content[i][0];
        var div2 = document.createElement("div");
        div2.innerHTML = content[i][1];
        div.appendChild(div1);
        div.appendChild(div2);
        document.getElementById("listComments").appendChild(div);
    }
}

window.onload = sendAjaxRequest("&num=all");