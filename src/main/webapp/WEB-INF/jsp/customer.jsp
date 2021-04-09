<%@include file="header.jsp"%>

	<div class="jumbotron text-center">
		<h3>Patient List</h3>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<form action="/user/savecustomer" method="post">
					<div class="form-group">
						<label for="">Customer Name: </label> <input type="text"
							value="${previousData.customername}" class="form-control" name="customername">
							<p class="text-danger">${message}</p>
					</div>

					<div class="form-group">
						<label for="">Mobile: </label> <input type="text"
							value="${previousData.mobile}" class="form-control" name="mobile">
						<p class="text-danger">${mmessage}</p>
					</div>
					<div class="form-group">
						<label for="">Address: </label> <input type="text"
							value="${previousData.address}" class="form-control"
							name="address">
							<p class="text-danger">${amessage}</p>
					</div>
						<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
					
					
			</div>
			<br />
			<table class="table table-bordered">
				<thead>
					<tr>
					<tr>
						<th>Id</th>
						<th>Customer Name</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Issue Book</th>

					</tr>
				</thead>
				<tbody>
				<tbody>
					<c:forEach var="c" items="${customerList}">
						<tr>
							<td>${c.id}</td>
							<td>${c.customername}</td>
							<td>${c.mobile}</td>
							<td>${c.address}</td>
							<td><a href="/user/issuebook?cid=${c.id}">Issue Book</a></td>
						</tr>
					</c:forEach>
				</tbody>


				</tbody>
			</table>
		</div>
</body>
</html>
