function addInput(divName) {
    var newdiv = document.createElement('div');
    newdiv.innerHTML = "  <form action=\"#\" th:action=\"@{/admin/world/create}\" th:object=\"${world}\" method=\"post\">" +
        "<p>Country code: <input type=\"text\" name=\"countryCode\" th:field=\"*{countryCode}\" /></p>" +
        "<p>World code: <input type=\"text\" name=\"worldCode\" th:field=\"*{worldCode}\" /></p>" +
        "<p>World name: <input type=\"text\" name=\"name\" th:field=\"*{name}\" /></p>" +
        "<p><input type=\"submit\" value=\"Submit\" />" +
        "</form>";
    // newdiv.innerHTML = "<form th:action=\"@{/login}\" method=\"post\">  "
    // 		+ "    <fieldset>    " th:action="@{/greeting}"
    // 		+ "    <h1>Proszę zrób to</h1>     "
    // 		+ "   <div class=\"form-group\">    "
    // 		+ "    <input type=\"text\" name=\"username\" id=\"username\" placeholder=\"UserName\" required=\"true\" utofocus=\"true\"/> "
    // 		+ "</div>        <div class=\"form-group\">  "
    // 		+ " <input type=\"password\" name=\"password\" id=\"password\"  placeholder=\"Password\" required=\"true\"/> "
    // 		+ "</div>        <div class=\"row\">"
    // 		+ " <div class=\"col-xs-6 col-sm-6 col-md-6\"> <input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Sign In\"/> </div>"
    // 		+ " <div class=\"col-xs-6 col-sm-6 col-md-6\"> </div> </div> "
    // 		+ "</fieldset> " + "</form>";
    // newdiv.appendChild(textnode);
    var item = document.getElementById(divName);
    item.replaceChild(newdiv, item.childNodes[0]);
}