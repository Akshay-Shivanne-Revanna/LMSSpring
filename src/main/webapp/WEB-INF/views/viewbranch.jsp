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
	Integer branchCount = service.getBranchCount();
	List<Branch> branch = new ArrayList<Branch>();
	if (request.getAttribute("branch") != null) {
		branch = (List<Branch>) request.getAttribute("branch");
		branchCount = branch.size();
	} else {
		branch = service.getAllBranches(1);
	}
%>


<script type="text/javascript">
function deleteBranch(branchId){
	out.println("I am in delete function");
	$.ajax({
		  url: "deleteBranch",
		  data:{
			  branchId: branchId
		  }
		}).done(function(data) {
		  $("#pagination").html(data);
		  $('#branchTable').html(data);
		});
}

function searchBranch(searchString){
	
	$.ajax({
		  url: "searchBranch",
		  data:{
			  branchId: searchBranch
		  }
		}).done(function(data) {
		  
		  $('#searchResults').html(data);
		});
}

</script>

<title>LMS</title>

<h2>Welcome to GCIT Library Management System - Admin</h2>
${result}

<form action="searchBranch" method="post">
	<div class="input-group">
		<input type="text" class="form-control" placeholder="Branch Name"
			aria-describedby="basic-addon1" name="searchString" onchange="searchBranch()">
		<button onclick="searchBranch();">Search!</button>
	</div>
</form>


<div id="searchResults">
<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<%if(branchCount!=null &&  branchCount >0){
			int pageNo = branchCount % 10;
			int pages = 0;
			if(pageNo == 0){
				pages = branchCount/10;
			}else{
				pages = branchCount/10 + 1;
			}
			for(int i=1; i<=pages;i++){%>
				<li><a href="pageBranch?pageNo=<%=i%>"><%=i %></a></li>
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

		<table border="2" id="branchTable" class="table">
			<tr>
				<th>Branch Name</th>
				<th>Branch Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>




			<%
				for (Branch br : branch) {
			%>
			<tr>
				<td>
					<%
						out.println(br.getBranchName());
					%>
				</td>
				<td>
					<%
						out.println(br.getBranchAddress());
					%>
				</td>


				<td align="center"><button type="button"
						class="btn btn btn-primary" data-toggle="modal"
						data-target="#myModal1"
						href="editbranch.jsp?branchId=<%=br.getBranchId()%>">EDIT</button></td>

				<td><button type="button" class="btn btn-danger"
						onclick="deleteBranch(<%=br.getBranchId()%>)">DELETE</button>
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
 --%></div>