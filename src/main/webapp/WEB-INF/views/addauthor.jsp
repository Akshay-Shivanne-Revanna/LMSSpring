<%@ include file="include.html" %>
<h2>Welcome To GCIT Library Management System - Admin</h2>
<h3>Enter Author Details Below:</h3>

${result}

	<form action="addAuthor" method="post">
		
		Author Name : <input type="text" name="authorName"> 
		<br/>
		<button type="submit" class="btn btn-primary">Add Author</button>
	</form>
	
	<a href="author.jsp">EXIT</a>
