<%@ page contentType="text/html" %>
<html>
<head><title>Dashboard</title></head>
<body>
    <h2>Welcome to the Stock Trading Dashboard</h2>
    <a href="trade.jsp">Place a Trade</a> | <a href="trading?action=viewHistory">Order History</a>
    <form action="trading" method="get">
        Search Stock Symbol: <input type="text" name="symbol" />
        <input type="hidden" name="action" value="getPrice" />
        <input type="submit" value="Get Price" />
    </form>
</body>
</html>