<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/simple.css"/>">
</head>
<body>
<div>

    <p><a href="/view/book/list">Back to book list</a><br/></p>

    <table>

        <tr>
            <th>ID</th>
            <td><c:out value="${book.id}"/></td>
        </tr>
        <tr>
            <th>ISBN</th>
            <td><c:out value="${book.isbn}"/></td>
        </tr>
        <tr>
            <th>Title</th>
            <td><c:out value="${book.title}"/></td>
        </tr>
        <tr>
            <th>Author</th>
            <td><c:out value="${book.author}"/></td>
        </tr>
        <tr>
            <th>Publisher</th>
            <td><c:out value="${book.publisher}"/></td>
        </tr>
        <tr>
            <th>Type</th>
            <td><c:out value="${book.type}"/></td>
        </tr>
        <tr>
            <th>Action</th>
            <td>
                <a href="<c:out value="/view/book/edit/${book.id}"/>">Edit</a>
                <a href="<c:out value="/view/book/delete/${book.id}"/>">Delete</a>
            </td>
        </tr>

    </table>
</div>
</body>
</html>
