<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 추가</title>
</head>
<body>
    <h2>새 상품 추가</h2>
    <form action="/products?action=create" method="post">
        <table>
            <tr>
                <td><label for="name">상품 이름:</label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>
            <tr>
                <td><label for="description">상품 설명:</label></td>
                <td><textarea id="description" name="description" rows="4" cols="50" required></textarea></td>
            </tr>
            <tr>
                <td><label for="price">가격:</label></td>
                <td><input type="number" id="price" name="price" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">추가</button>
                    a href="/products?action=list">취소</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
