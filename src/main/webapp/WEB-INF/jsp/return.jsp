<%@include file="header.jsp"%>

<div class="jumbotron text-center">
	<h3>Returned Book</h3>
</div>



<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<form action="/user/returnbook" method="post">
				<input type="hidden" value="${bookUserId}" name="bookUserId" />
				<div class="form-group">
					<label for="">Returned Date </label> <input type="date"
						value="${returnDate}" class="form-control" name="returnDate">
				</div>
				<p class="text-danger">${emessage}</p>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
