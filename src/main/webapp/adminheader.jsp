 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="nav-brand" href="#">Library</a> 
        <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="adminhome.jsp">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Action</a>
                <div class="dropdown-menu">
                    <a href="bookentry.jsp" class="dropdown-item">BookEntry</a>
                    <a href="bookreturn.jsp" class="dropdown-item">BookReturn</a>
                    <a href="bookrenewal.jsp" class="dropdown-item">BookRenewal</a>
                    <div class="dropdown-divider"></div>

                </div>
            </li>

              </div>
            
              <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Books</a>
                <div class="dropdown-menu">
                    <a href="addnewbook.jsp" class="dropdown-item">Add</a>
                    <a href="DisplayAllBooksAdminServlet" class="dropdown-item">List</a>
                    <a href="updatebookcopies.jsp" class="dropdown-item">Update</a>
                    <div class="dropdown-divider"></div>
                    <a href="searchbybookid.jsp" class="dropdown-item">Search By ID</a>
                    <a href="searchbybookname.jsp" class="dropdown-item">Search By Name</a>
                    <a href="unreturnedbooks.jsp" class="dropdown-item">UnReturned Book</a>
                    <div class="dropdown-divider"></div>

                </div>
            </li>
            
            <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Users</a>
                <div class="dropdown-menu">
                    <a href="addnewadmin.jsp" class="dropdown-item">Add Admin Student</a>
                    <div class="dropdown-divider"></div>
                    <a href="addnewstudent.jsp" class="dropdown-item">Add Student</a>
                    <a href="DisplayAllStudentServlet" class="dropdown-item">List Student</a>
                    <div class="dropdown-divider"></div>

                </div>
            </li>

            <li class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Report</a>
                <div class="dropdown-menu">
                    <a href="searchbystudentid.jsp" class="dropdown-item">Search By Student ID</a>
                </div>
            </li>
          </ul>  
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="Report.jsp">Welcome (Admin)</a>
              </li>
            <li class="nav-item">
              <a class="nav-link" href="AdminLogoutServlet">Logout</a>
            </li>
          </ul>  
      </nav>