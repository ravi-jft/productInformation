<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 19/5/17
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
</head>
<body>
<form action="/productInformation/user/saveResetPassword" method="post">
   <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>--%>
    <input type="hidden" name="token" value="${token}"/><br>
    <input type="text" name="password"/><br>
    <input type="text" name="confirmpwd"/><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
