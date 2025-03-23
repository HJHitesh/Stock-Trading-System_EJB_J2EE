<%@ page contentType="text/html" %>
<html>
<head><title>Login</title></head>
<body>
    <h2>Login to Stock Trading System</h2>
    <form action="dashboard.jsp" method="post">
        Username: <input type="text" name="username" required/><br/>
        Password: <input type="password" name="password" required/><br/>
        <input type="submit" value="Login" />
    </form>
</body>
</html>