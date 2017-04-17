<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Products</title>
</head>
<body>

<c:forEach items="${listOfProducts}" var="product">
	<div class="col-sm-6 col-md-3">
		<div class="thumbnail">
			<div class="caption">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>$${product.unitPrice}</p>
				<p>Available ${product.unitsInStock} units in stock</p>
				<p>
					<a
							href=" <spring:url value="/market/product?id=${product.productId}" /> "
							class="btn btn-primary"> <span
							class="glyphicon-info-sign glyphicon" /></span> Details
					</a>
				</p>

			</div>
		</div>
	</div>
</c:forEach>
</body>
</html>
