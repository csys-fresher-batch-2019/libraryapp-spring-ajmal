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

    <jsp:include page="adminheader.jsp"></jsp:include>
          <div class="container">
        <h2><center>Book Return</center></h2>
        
      <form action="BookReturnFineServlet" method="GET">
      
      
          <div class="form-group">
          <label for="number">BooktId:</label>
          <input type="number" class="form-control" placeholder="" id="number" value="${bookid }" name="bookid" readonly  required autofocus>
          </div>
          <div class="form-group">
            <label for="number">StudentId:</label>
            <input type="number" class="form-control" placeholder="" id="number" name="studentid"value="${studentid}" readonly required>
          </div>
          <div class="form-group">
            <label for="number">Fine:</label>
            <input type="number" class="form-control" placeholder="" id="number"value="${fineamount}" name="fineamount" readonly required autofocus>
          </div>
          <div class="form-group-row">
            <label for="radio">Do you want to return the book:</label><br>
            Yes<input type="radio" class="form-control inline" placeholder="Enter Y/N" id="radio" name="return" value="y"  required>
            No<input type="radio" class="form-control inline" placeholder="Enter Y/N" id="radio"  name="return" value="n" required>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
      
    </body>
    </html>