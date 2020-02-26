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
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="nav-brand" href="#">Library</a> 
        <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="studenthome.jsp">Home</a>
            </li>
              </div>
            
              <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Books</a>
                <div class="dropdown-menu">
                     <a href="DisplayAllBooksStudentServlet" class="dropdown-item">List</a>
                     <div class="dropdown-divider"></div>
                    <a href="searchbybooknamestd.jsp" class="dropdown-item">Search By Name</a>
                    <a href="searchbybookidstd.jsp" class="dropdown-item">Search By ID</a>
                   <div class="dropdown-divider"></div>

                </div>
            </li>
            
            <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Report</a>
                <div class="dropdown-menu">
                    <a href="CheckLimtOfStudentServlet" class="dropdown-item">Availability Status</a>
                    <a href="CheckBookAlreadyTakenServlet" class="dropdown-item">Already Taken</a>
                    <a href="BooksTakenByAStudentServlet" class="dropdown-item">List Taken books</a>
                    <a href="TotalFineOfAStudentServlet" class="dropdown-item">Total Fine Amount</a>
                    

                </div>
            </li>

          </ul>  
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="Report.jsp">Welcome Ahamed(Student)</a>
              </li>
            <li class="nav-item">
              <a class="nav-link" href="StudentLogoutServlet">Logout</a>
            </li>
          </ul>  
      </nav>
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1>TotalFineOfStudent</h1> 
          <p>Fine = 23</p> 
              <table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>ID</th>  
            <th>Name</th>
            <th>Category</th>
            <th>Name</th>
            <th>Edition</th>
            <th>Price</th>
            <th>PublishedDate</th>
            <th>Copies</th>
            <th>Pages</th>
          </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>212</td>
                <td>Java</td>
                <td>Programming</td>
                <td>Naresh</td>
                <td>3</td>
                <td>350</td>
                <td>2019-12-21</td>
                <td>30</td>
                <td>231</td>
            </tr>
       </tbody>
      </table>
    
        </div>
    </div>   
</body>
</html>