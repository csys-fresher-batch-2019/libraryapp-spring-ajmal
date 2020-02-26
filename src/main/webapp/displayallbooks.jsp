<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"  crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="nav-brand" href="#">Library</a> 
        <ul class="navbar-nav">
            <li class="nav-item ">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="DisplayAllBooksServlet">Books</a>
            </li>
          </ul>  
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="adminlogin.jsp">AdminLogin</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="studentlogin.jsp">StudentLogin</a>
              </li>
          </ul>  
      </nav>
      
    
    
      <div class="container">
        <div class="row">
            <div class="col">
                <h3 align='center'>Books List</h3>
                
                 
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
        <c:forEach items="${BOOK_LIST}" var="b">
  <tr>
  <td>${b.bookId}</td>
  <td>${b.bookName}</td>
  <td>${b.bookCategory}</td>
  <td>${b.bookAutherName}</td>
  <td>${b.bookEdition}</td>
  <td>Rs.${b.bookPrice}</td>
  <td>${b.bookPublishedDate}</td>
  <td>${b.bookCopies}</td>
  <td>${b.bookPages}</td>
  </tr>
    </c:forEach>
        </tbody>
      </table>
            </div>
        </div>
    </div>  
    </body>
</html>