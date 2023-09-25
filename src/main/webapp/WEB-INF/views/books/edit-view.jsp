
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit book</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/simple.css"/>">
</head>
<body>

<c:url var="edit_url" value="/view/book/edit" />
<form:form method="post" modelAttribute="book" action="${edit_url}">
    <p><a href="/view/book/list">Back to book list</a><br/></p>
    <p>
        <form:hidden path="id"/>
        <label>ISBN:</label>
        <form:input path="isbn"/><form:errors path="isbn"/><br/>

        <label>Title:</label>
        <form:input path="title"/><form:errors path="title"/><br/>

        <label>Author:</label>
        <form:input path="author"/><form:errors path="author"/><br/>

        <label>Publisher:</label>
        <form:input path="publisher"/><form:errors path="publisher"/><br/>

        <label>Type:</label>
        <form:input path="type"/><form:errors path="type"/><br/>
    </p>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
