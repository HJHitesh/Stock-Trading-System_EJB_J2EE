<%@ page contentType="text/html" %>
<html>
<head><title>Order History</title></head>
<body>
    <h2>Order History</h2>
    <ul>
        <c:forEach var="order" items="${history}">
            <li>${order}</li>
        </c:forEach>
    </ul>
</body>
</html>
