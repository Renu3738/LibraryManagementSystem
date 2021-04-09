<%@include file="header.jsp"%>

<div class="jumbotron text-center">
	<h3>Book List</h3>
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-4">

			<form action="/user/issuenow" method="post">
				<input type="hidden" value="${cid}" name="cid" /> <input
					type="hidden" value="${bid}" name="bid" />
				<div class="form-group">
					<label for="">From Date: </label> <input type="date"
						value="${fromDate}" class="form-control" name="fromDate">
				</div>
				<div class="form-group">
					<label for="">To Date: </label> <input type="date"
						value="${toDate}" class="form-control" name="toDate">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p class="text-danger">${emessage}</p>
		</div>


	</div>
	<br />

</div>
</body>
</html>
