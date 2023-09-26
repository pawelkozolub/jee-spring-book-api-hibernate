<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/simple.css"/>">
</head>
<body>
    <p>
        ${url}<br/>
        ${errorMessage}<br/>
        ${exception}<br/>
        <br/>
        <br/>
        <a href="/view/book/list">Back to book list</a><br/>
    </p>
</body>
</html>
