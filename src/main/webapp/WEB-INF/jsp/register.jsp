<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center">
		<h3>Register User</h3>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<form action="/registeruser" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">User Name</label> <input
							name="username" value="${previousData.username}" type="text">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Password</label> <input
							name="password" type="password">
					</div>
					<p class="text-info">${message }</p>
					<input type="hidden" class="csrf" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>

		</div>

	</div>

</body>
</html>
