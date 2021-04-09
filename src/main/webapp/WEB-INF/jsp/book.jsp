<%@include file="header.jsp"%>

	<div class="jumbotron text-center">
		<h3>Book List</h3>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<form action="/user/savebook" method="post">
					<div class="form-group">
						<label for="">ISBN: </label> <input type="text"
							value="${previousData.isbn}" class="form-control" name="isbn">
						<p class="text-danger">${message}</p>
					</div>

					<div class="form-group">
						<label for="">Book Name: </label> <input type="text"
							value="${previousData.bookname}" class="form-control" name="bookname">
						<p class="text-danger">${bmessage}</p>
					</div>
					<div class="form-group">
						<label for="">Author name: </label> <input type="text"
							value="${previousData.authorname}" class="form-control"
							name="authorname">
						<p class="text-danger">${amessage}</p>
					</div>

					<div class="form-group">
						<label for="">Edition: </label> <input type="text"
							value="${previousData.edition}" class="form-control" name="edition">
						<p class="text-danger">${emessage}</p>
					</div>
					<div class="form-group">
						<label for="">Publication: </label> <input type="text"
							value="${previousData.publication}" class="form-control"
							name="publication">
						<p class="text-danger">${pmessage}</p></div>
						<input type="hidden" class="csrf" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
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
							<td>
							<a href="/user/editbook?id=${b.id}">Edit</a>
						<a href="/user/deletebook?id=${b.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>


				</tbody>
			</table>
		</div>
</body>
</html>
