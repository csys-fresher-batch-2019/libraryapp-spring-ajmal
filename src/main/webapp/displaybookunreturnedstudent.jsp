<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library</title>
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
    <jsp:include page="adminheader.jsp"></jsp:include>
          <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h2><center>List of Student to return the Book </center></h2>
                 <table class="table">
        <thead>
          <tr>
            <th>#BookID</th>
            <th>BookName</th>
            <th>#StudentId</th>  
            <th>StudentName</th>
            <th>Dept</th>
            <th>Mob.Num</th>
            <th>IssueDate</th>
            <th>DueDate</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${LIST}" var="b">
  <tr>
            <th>${b.bookId}</th>
            <th>${b.bookName}</th>
            <th>${b.studentId}</th>
            <th>${b.studentName}</th>  
            <th>${b.studentDept}</th>
            <th>${b.mobileNumber}</th>
            <th>${b.issueDate}</th>
            <th>${b.dueDate}</th>
  </tr>
    </c:forEach>
        </tbody>
      </table>
        
        </div>
    </div>   
</body>
</html>