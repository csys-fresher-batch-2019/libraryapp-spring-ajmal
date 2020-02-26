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
          <h2><center>Display book </center></h2>
         <table class="table">
        <thead>
          <tr>
            <th>#ID</th>  
            <th>Name</th>
            <th>Category</th>
            <th>AuthorName</th>
            <th>Edition</th>
            <th>Price(Rs)</th>
            <th>PublishedDate</th>
            <th>Copies</th>
            <th>Pages</th>
          </tr>
        </thead>
        <tbody>
        
  <tr>
  <td>${BOOK_LIST.bookId}</td>
  <td>${BOOK_LIST.bookName}</td>
  <td>${BOOK_LIST.bookCategory}</td>
  <td>${BOOK_LIST.bookAutherName}</td>
  <td>${BOOK_LIST.bookEdition}</td>
  <td>Rs.${BOOK_LIST.bookPrice}</td>
  <td>${BOOK_LIST.bookPurchasedDate}</td>
  <td>${BOOK_LIST.bookCopies}</td>
  <td>${BOOK_LIST.bookPages}</td>
  </tr>
        </tbody>
      </table>
        
        </div>
    </div>   
</body>
</html>