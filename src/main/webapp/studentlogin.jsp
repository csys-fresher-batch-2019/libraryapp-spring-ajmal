<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
   crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
  integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
  integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
  crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
  crossorigin="anonymous"></script>
</head>
<body>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="nav-brand" href="#">Library</a> 
    <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="DisplayAllBooksServlet">Books</a>
        </li>
      </ul>  
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="adminlogin.jsp">AdminLogin</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="studentlogin.jsp">StudentLogin</a>
          </li>
      </ul>  
  </nav>

  <div class="container">
    <h2><center>Student Login</center></h2>
    <center><jsp:include page="message.jsp"></jsp:include></center>
  <form action="StudentLoginServlet" method="GET">
      <div class="form-group">
        <label for="studentId">StudentId:</label>
        <input type="number" class="form-control" placeholder="Enter studentId" id="studentId" name="studentid" required autofocus>
      </div>
      <div class="form-group">
        <label for="dateOfBirth">DateOfBirth:</label>
        <input type="date" class="form-control" placeholder="Enter dateOfBirth" id="date" name="dob" required>
      </div>	
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
  

</body>
</html>