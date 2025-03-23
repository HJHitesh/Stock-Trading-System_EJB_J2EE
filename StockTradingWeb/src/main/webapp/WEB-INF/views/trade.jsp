<%@ page contentType="text/html" %>
<html>
<head><title>Place a Trade</title></head>
<body>
    <h2>Place a Trade</h2>
    <form action="trading" method="post">
        Stock Symbol: <input type="text" name="stockSymbol" required/><br/>
        Quantity: <input type="number" name="quantity" required/><br/>
        Order Type: 
        <select name="orderType">
            <option value="Buy">Buy</option>
            <option value="Sell">Sell</option>
        </select><br/>
        <input type="submit" value="Submit Order" />
    </form>
</body>
</html>