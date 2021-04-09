<%@include file="header.jsp"%>

	<div class="jumbotron text-center">
		<h3>Book Edit</h3>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<form action="/user/editbookpost" method="post">
					<div class="form-group">
					<input type="hidden" value="${bookDetail.id}" name ="id" />
						<label for="">ISBN: </label> <input type="text"
							value="${bookDetail.isbn}" class="form-control" name="isbn">
					</div>
					<div class="form-group">
					<label for="">Book Name: </label> <input type="text"
							value="${bookDetail.bookname}" class="form-control" name="bookname">
					</div>
					<div class="form-group">
					<label for="">Author name: </label> <input type="text"
							value="${bookDetail.authorname}" class="form-control"
							name="authorname">
					</div>
					<div class="form-group">
					<label for="">Edition: </label> <input type="text"
							value="${bookDetail.edition}" class="form-control" name="edition">
					</div>
					<div class="form-group">
					<label for="">Publication: </label> <input type="text"
							value="${bookDetail.publication}" class="form-control"
							name="publication">
							</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>

		</div>
		<br />
		
	</div>

</body>
</html>
