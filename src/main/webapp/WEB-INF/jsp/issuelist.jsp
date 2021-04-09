<%@include file="header.jsp"%>

<div class="jumbotron text-center">
	<h3>Issued Books</h3>
</div>

<script>
	$(document).ready(function() {
		$('#tble').DataTable({
			"ordering": false
		});
	});
</script>

<div class="container">
	<div class="row">

		<table id="tble" class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Customer</th>
					<th>Book</th>
					<th>FromDate</th>
					<th>To Date</th>
					<th>Returned date</th>
					<th>Is Returned</th>
					<th>Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${issuedBooks}">
					<tr>
						<td>${b.id}</td>
						<td>${b.issuedTo.customername}</td>
						<td>${b.bookDetail.bookname}</td>
						<td>${b.fromDate}</td>
						<td>${b.toDate}</td>
						<td>${b.returnDate}</td>
						<td>${b.returned}</td>
						<td><a href="/user/returnbook?bid=${b.id}">Returned</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
	</html>