<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
<form action="/productInformation/saveOrUpdate" method="post" modelAttribute="product">
	<input type="text" name="name" value="Name..." onclick="this.value=''"/><br/>
	<input type="number" name="unitPrice"  value="Unit Price..." onclick="this.value=''"/><br/>
	<input type="text" name="description"  value="Manufacturer..." onclick="this.value=''"/><br/>
	<input type="text" name="manufacturer"  value="Description..." onclick="this.value=''"/><br/>
	<input type="text" name="category"  value="Category..." onclick="this.value=''"/><br/>
	<input type="number" name="unitsInStock"  value="Description..." onclick="this.value=''"/><br/>
	<input type="submit" value="register"/>
</form>
</body>
</html>
