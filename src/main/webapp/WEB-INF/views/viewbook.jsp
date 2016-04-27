<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.lms.entity.Author"%>
<%@ page import="com.gcit.lms.entity.Branch"%>
<%@ page import="com.gcit.lms.entity.Book"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%@ include file="include.html"%>

<%-- <%
	AdministratorService service = new AdministratorService();
	Integer booksCount = service.getBookCount();
	List<Book> books = new ArrayList<Book>();
	if (request.getAttribute("books") != null) {
		books = (List<Book>) request.getAttribute("books");
		booksCount = books.size();
	} else {
		books = service.getAllBooks(1);
	}
%>

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
function deleteBook(bookId){
	$.ajax({
		  url: "deleteBook",
		  data:{
			  bookId: bookId
		  }
		}).done(function(data) {
		  $('#bookTable').html(data);
		});
}



 
 var sType="Any";


 $(function(){
	 $('#searchType li a').on('click', function(){
	 		console.log("Selected option :"+$(this).text());
	 		sType=$(this).text();
	 	});
 });

    function searchBooks(){
 	   console.log($('#searchString'));
 	  	$('#searchType li a').on('click', function(){
 	 		console.log("Selected option :"+$(this).text());
 	 		sType=$(this).text();
 	 	});
 	   ///if($('#searchString').val().legth<3) return;
     $.ajax({
     	
 		  url: "searchBooks",
 		  data:{
 			  searchString:$('#searchStrings').val(),
 			  text: sType	
 			  }
 		}).done(function(data) {
 		  $('#searchResults').html(data);
 		});
    
 }
</script>

<title>LMS</title>

<h2>Welcome to GCIT Library Management System - Admin</h2>
${result}



<!-- <div class="alert alert-danger" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  
</div> -->


<form action="searchBooks">
       <div class="row">
       <div class="cl-lg-6">
       <div class="input-group">
       
      <input type="text" class="form-control" placeholder="Author Name"
			aria-describedby="basic-addon1" name="searchString" id="searchStrings" onkeyup="searchAuthors()">
			<div class = "input-group-btn">
			<button type = "button" class = "btn btn-primary dropdown-toggle" data-toggle = "dropdown" aria-haspopup="true" aria-expanded="false">
			<span class = "caret"></span> <span class="sr-only">Toggle Dropdown</span>
   			</button>
   	
   			 <ul id="searchType" class = "dropdown-menu dropdown-menu-right">
   				<li><a tabindex="-1" href="#">Search by Authors</a></li>
   				<li><a tabindex="-1" href="#">Search by Books</a></li>
   				<li role="separator" class="divider"></li>
 				<li><a tabindex="-1" href="#">Search by All</a></li>  			
   </ul>
   <button type="button" class="btn btn-success" onclick="searchBooks()">Search</button>
        </div>
        </div>
        </div>
        </div>
        </form>



<div id="searchResults">
<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%if(booksCount!=null &&  booksCount >0){
			int pageNo = booksCount % 10;
			int pages = 0;
			if(pageNo == 0){
				pages = booksCount/10;
			}else{
				pages = booksCount/10 + 1;
			}
			for(int i=1; i<=pages;i++){%>
				<li><a href="pageBooks?pageNo=<%=i%>"><%=i %></a></li>
			<%}
			
		} %>
		<li>
      		<a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
	</ul>
</nav>


<div class="row">
	<div class="col-md-6">
		<table border="2" id="bookTable" class="table">
			<tr>
				<th>Book Title</th>
				<th>Author</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>




			<%
				for (Book b : books) {
			%>
			<tr>
				<td>
					<%
						out.println(b.getTitle());
					%>
				</td>
				<td>
					<%
						if (b.getAuthors() != null && b.getAuthors().size() > 0) {
								for (Author a : b.getAuthors()) {
									out.println(a.getAuthorName());
									out.println(", ");
								}
							}
					%>
				</td>

				<td align="center"><button type="button"
						class="btn btn btn-primary" data-toggle="modal"
						data-target="#myModal1"
						href="editbook.jsp?bookId=<%=b.getBookId()%>">EDIT</button></td>

				<td><button type="button" class="btn btn-danger"
						onclick="deleteBook(<%=b.getBookId()%>)">DELETE</button>
			</tr>
			<%
				}
			%>

		</table>
	</div>
</div>
</div>
<div id="myModal1" class="modal fade" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg">
		<div class="modal-content"></div>
	</div>
</div> --%>