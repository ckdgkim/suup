<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상품 정보 수정</title>
</head>
<body>
    <h2>상품 정보 수정</h2>
    <form action="/products?action=update&id=${p.id}" method="post">
        <input type="hidden" name="id" value="${p.id}">
        이름<input type="text" name="name" value="${p.name}" >
        설명<input type="text" name="description" value="${p.description}">
        가격<input type="text" name="price" value="${p.price}">
        <input type="submit" value="수정">
    </form>
</body>
</html>

