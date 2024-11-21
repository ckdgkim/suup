<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>상품 목록 조회</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>price</th>
        </tr>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.price}</td>
                <td><a href="/products?action=update&id=${p.id}">수정</a></td>
                <td><a href="/products?action=delete&id=${p.id}">삭제</a></td>

            </tr>
        </c:forEach>
    </table>
    <a href="/products?action=create">새 상품 추가</a>
</body>
</html>