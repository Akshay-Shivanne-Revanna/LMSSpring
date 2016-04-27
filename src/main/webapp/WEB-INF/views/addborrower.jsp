<%@ include file="include.html" %>
<title>LMS</title>

<h2>Welcome to GCIT Library Management System - Admin</h2>
<h3>Enter Borrower Details Below:</h3>
${result}

	<form action="addBorrower" method="post">
		
		Borrower Name : <input type="text" name="borrowerName"> 
		<br/><br/>
		Borrower Address : <input type="text" name="borrowerAddress"> 
		<br/><br/>
		Borrower Phone : <input type="text" name="borrowerPhone"> 
		<br/><br/>
		<button type="submit">Add Borrower</button>
	</form>
