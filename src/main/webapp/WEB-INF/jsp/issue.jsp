<%@include file="header.jsp"%>

<div class="jumbotron text-center">
	<h3>Book List</h3>
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-4">

			<form action="/user/issuebook" method="get">
				<input type="hidden" value="${cid}" name="cid" />
				<div class="form-group">
					<label for="">Search Book By Name: </label> <input type="text"
						value="${bookname}" class="form-control" name="bookname">
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
				<th>ISBN</th>
				<th>Book name</th>
				<th>Author name</th>
				<th>Edition</th>
				<th>Publication</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
		<tbody>
			<c:forEach var="b" items="${bookList}">
				<tr>
					<td>${b.id}</td>
					<td>${b.isbn}</td>
					<td>${b.bookname}</td>
					<td>${b.authorname}</td>
					<td>${b.edition}</td>
					<td>${b.publication}</td>
					<td><a href="/user/issuenow?cid=${cid}&bid=${b.id}">Issue
							Now</a></td>
				</tr>
			</c:forEach>
		</tbody>


		</tbody>
	</table>
</div>
</body>
</html>
