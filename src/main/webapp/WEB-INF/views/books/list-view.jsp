<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book list</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/simple.css"/>">
</head>
<body>
<div>

    <p>
        <a class="button" href="/view/book/add">Add book</a>
    </p>

    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>ISBN</th>
                <th>Title</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book" varStatus="status">
            <tr>
                <td><c:out value="${status.index + 1}"/></td>
                <td><c:out value="${book.isbn}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td>
                    <a href="<c:out value="/view/book/edit/${book.id}"/>">Edit</a>
                    <a href="<c:out value="/view/book/delete/${book.id}"/>">Delete</a>
                    <a href="<c:out value="/view/book/show/${book.id}"/>">Show</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
