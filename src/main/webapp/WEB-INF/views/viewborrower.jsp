<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
     <%@ page import="com.gcit.lms.entity.Borrower" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <%@ include file="include.html" %>
<%--     <%
	AdministratorService service = new AdministratorService();
	Integer borrowerCount = service.getBorrowerCount();
	List<Borrower> borrowers = new ArrayList<Borrower>();
	if (request.getAttribute("borrowers") != null) {
		borrowers = (List<Borrower>) request.getAttribute("borrowers");
		borrowerCount=borrowers.size();
	} else {
		borrowers = service.getAllBorrowers(1);
	}
%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
<script type="text/javascript">
function deleteBorrower(cardNo){
	$.ajax({
		  url: "deleteBorrower",
		  data:{
			  cardNo: cardNo
		  }
		}).done(function(data) {
		  $('#borrowerTable').html(data);
		});
}

function searchBorrower(searchString){
	
	$.ajax({
		  url: "searchBorrower",
		  data:{
			  cardNo: searchString
		  }
		}).done(function(data) {
		  $('#searchResults').html(data);
		});
}

</script>

<h2>Welcome to GCIT Library Management System - Admin</h2>
${result}

<form action="searchBorrower" method="post">
	<div class="input-group">
		<input type="text" class="form-control" placeholder="Borrower Name"
			aria-describedby="basic-addon1" name="searchString" onchange="searchAuthor()">
		<button onclick="searchBorrower();">Search!</button>
	</div>
</form>

<div class="alert alert-danger" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  
</div>

<div id="searchResults">
<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%if(borrowerCount!=null &&  borrowerCount >0){
			int pageNo = borrowerCount % 10;
			int pages = 0;
			if(pageNo == 0){
				pages = borrowerCount/10;
			}else{
				pages = borrowerCount/10 + 1;
			}
			for(int i=1; i<=pages;i++){%>
				<li><a href="pageBorrower?pageNo=<%=i%>"><%=i %></a></li>
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
<table border="2" id="borrowerTable" class="table">
	<tr>
		<th>borrower name</th>
		<th>address</th>
		<th>phone</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	
		<%for (Borrower b: borrowers){ %>
		<tr>
		<td><% out.println(b.getName()); %></td>
		<td><%out.println(b.getAddress()); %></td>
		<td><%out.println(b.getPhone()); %></td>
		
		<td align="center"><button type="button"
						class="btn btn btn-primary" data-toggle="modal"
						data-target="#myModal1"
						href="editborrower.jsp?cardNo=<%=b.getCardNo()%>">EDIT</button></td>
		
		<td><button type="button" class="btn btn-danger" onclick="deleteBorrower(<%=b.getCardNo() %>)">DELETE</button>
		</tr>
		<%} %>
		
	

</table>
</div>
</div>
</div>
<div id="myModal1" class="modal fade" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg">
		<div class="modal-content"></div>
	</div>
</div>
 --%>