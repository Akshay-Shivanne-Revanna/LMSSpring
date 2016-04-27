<%@ include file="include.html" %>
<title>LMS</title>
<h2>Welcome to GCIT Library Management System - Admin</h2>
<h3>Enter Publisher Details Below:</h3>
${result}

	<form action="addPublisher" method="post">
		
		PUBLISHER NAME : <input type="text" name="publisherName"> 
		<br/></br>
		PUBLISHER ADDRESS: <input type="text" name="publisherAddress">
		<br/></br>
		PUBLISHER PHONE: <input type="text" name="publisherPhone">
		<br/></br>
		<button type="submit">Add publisher</button>
	</form>
