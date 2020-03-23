function checkTheme() {
    var themeButton = document.getElementsByName('satisfaction'),
        newLink = document.createElement('link'),
        head = document.getElementById('head');
    for (var i = 0; i < themeButton.length; i++) {
        if (themeButton[1].checked) {
            newLink.href = "${pageContext.request.contextPath}/static/css/fun.css";
            newLink.rel = "stylesheet";
            newLink.id = "link";
            head.insertBefore(newLink, null);

        } else {
            link.remove(newLink);

        }
    }
}