<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mytags" uri="http://productInformation.com/jsp/tlds/mytags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>

<sf:form method="POST" commandName="product">
	<sf:errors path="description" /><br/>
</sf:form>
<%--<div class="container">
	<h1>This is secured!</h1>
	<p>
		Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
	</p>
	<c:url var="logoutUrl" value="/logout"/>
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>--%>
<form action="/productInformation/saveOrUpdate" method="post" modelAttribute="product">
	<input type="text" name="name" value="Name..." onclick="this.value=''"/><br/>
	<input type="number" name="unitPrice"  value="Unit Price..." onclick="this.value=''"/><br/>
	<input type="text" name="description"  value="Manufacturer..." onclick="this.value=''"/><br/>
	<input type="text" name="manufacturer"  value="Description..." onclick="this.value=''"/><br/>
	<input type="text" name="category"  value="Category..." onclick="this.value=''"/><br/>
	<input type="number" name="unitsInStock"  value="Description..." onclick="this.value=''"/><br/>
	<mytags:formatNumber number="100050.574" format="#,###.00"/><br><br>
	<input type="submit" value="register"/>
</form>
</body>
</html>
