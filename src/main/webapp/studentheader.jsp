
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="nav-brand" href="#">Library</a>
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link"
			href="studenthome.jsp">Home</a></li>
		</div>

		<li class="nav-item dropdown"><a href="#"
			class="nav-link dropdown-toggle" data-toggle="dropdown">Books</a>
			<div class="dropdown-menu">
				<a href="DisplayAllBooksStudentServlet" class="dropdown-item">List</a>
				<div class="dropdown-divider"></div>
				<a href="searchbybooknamestd.jsp" class="dropdown-item">Search
					By Name</a> <a href="searchbybookidstd.jsp" class="dropdown-item">Search
					By ID</a>
				<div class="dropdown-divider"></div>

			</div></li>

		<li class="nav-item dropdown"><a href="#"
			class="nav-link dropdown-toggle" data-toggle="dropdown">Report</a>
			<div class="dropdown-menu">
				<a href="CheckLimtOfStudentServlet" class="dropdown-item">Availability
					Status</a> <a href="BooksTakenByAStudentServlet" class="dropdown-item">List
					Taken books</a> <a href="TotalFineOfAStudentServlet"
					class="dropdown-item">Total Fine Amount</a>


			</div></li>

	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item"><a class="nav-link" href="Report.jsp">Welcome
				(Student)</a></li>
		<li class="nav-item"><a class="nav-link"
			href="StudentLogoutServlet">Logout</a></li>
	</ul>
</nav>