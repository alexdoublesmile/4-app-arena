<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head id="head">
    <title>${title}</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta http-equiv="Cache-Control" content="no-cache">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <c:if test="${isFun} > 0">
        <link href="${pageContext.request.contextPath}/static/css/fun.css" rel="stylesheet"/>
    </c:if>
</head>
