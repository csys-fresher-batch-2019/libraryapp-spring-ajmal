<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Library</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="adminheader.jsp"></jsp:include>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>
				<center>Insert New Books</center>
			</h2>
			<center><jsp:include page="message.jsp"></jsp:include></center>
			<form action="AddNewBookServlet" method="GET">
				<div class="form-group">
					<label for="name">Name:</label> <input type="name"
						class="form-control" placeholder="Enter name" id="name"
						name="bookname" required autofocus>
				</div>
				<div class="form-group">
					<label for="name">Category:</label> <input type="name"
						class="form-control" placeholder="Enter Category" id="name"
						name="bookcategory" required>
				</div>
				<div class="form-group">
					<label for="name">Author:</label> <input type="name"
						class="form-control" placeholder="Enter Author" id="name"
						name="bookauthor" required>
				</div>
				<div class="form-group">
					<label for="number">Edition:</label> <input type="number"
						class="form-control" placeholder="Enter Edition" id="number"
						name="bookedition" required>
				</div>
				<div class="form-group">
					<label for="number">Price:</label> <input type="number"
						class="form-control" placeholder="Enter Price" id="number"
						name="bookprice" required>
				</div>
				<div class="form-group">
					<label for="number">Pages:</label> <input type="number"
						class="form-control" placeholder="Enter Pages" id="number"
						name="bookpages" required>
				</div>
				<div class="form-group">
					<label for="number">Copies:</label> <input type="number"
						class="form-control" placeholder="Enter Copies" id="number"
						name="bookcopies" required>
				</div>
				<div class="form-group">
					<label for="date">Purchased Date:</label> <input type="date"
						class="form-control" placeholder="Enter Date" id="date"
						name="purchaseddate" required>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>


