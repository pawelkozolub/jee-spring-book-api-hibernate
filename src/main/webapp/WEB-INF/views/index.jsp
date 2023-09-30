<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/simple.css"/>">
    <%-- alternative that not require configureDefaultServletHandling overriding --%>
    <%--    <style><%@include file="/css/simple.css"%></style>--%>
</head>
<body>
    <div>
        <h1>Web Application Index Page</h1>
        <p>
            <a href="/view/book/list">Go to book list</a><br/>
        </p>
    </div>
</body>
</html>
