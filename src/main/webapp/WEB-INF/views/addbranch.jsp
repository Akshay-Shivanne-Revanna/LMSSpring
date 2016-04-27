<%@ include file="include.html" %>
<title>LMS</title>
<h2>Welcome to GCIT Library Management System - Admin</h2>
<h3>Enter Branch Details Below:</h3>
${result}

	<form action="addBranch" method="post">
		
		Branch Name : <input type="text" name="branchName"> 
		<br/><br/><br/>
		Branch Address : <input type="text" name="branchAddress"> 
		<br/><br/><br/>
		<button type="submit">Add Branch</button>
	</form>
