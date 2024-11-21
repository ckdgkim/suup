<%@ page contentType="text/html;charset=UTF-8" language="java"
    isELIgnored="false"
%>

<html>
<head>
    <title>상품 상세정보 조회</title>
</head>
<body>
 <h2>상품 상세 정보</h2>
 <ul>
     <li>${product.id}</li>
     <li>${product.name}</li>
     <li>${product.description}</li>
     <li>${product.price}</li>
 </ul>
</body>
</html>