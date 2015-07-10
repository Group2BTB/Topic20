<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<table class='table table-bordered' id="display">
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			lists();
		});
		function lists() {
			$.get("liststudent.act", function(data) {
				$("#display").html(listdetailarticle(data));
			});
		}
		function listdetailarticle(data) {
			var str = "";
			/* display header of the table */
			str = "<tr class='text-'><th class='text-center'>ID</th>"
					+ "<th class='text-center'>Name</th>"
					+ "<th class='text-center'>Gender</th>"
					+ "<th class='text-center'>University</th>"
					+ "<th class='text-center'>Class</th>"
					+ "<th class='text-center'>Status</th>"
					+ "<th class='text-center'>Action</th></tr>";
			/*-----end---- */
			
			for (var i = 0; i < data.length; i++) {
				str += "<tr class='text-center'>" + "<td>" + data[i].id
						+ "</td>" + "<td>" + data[i].name + "</td>" + "<td>"
						+ data[i].gender + "</td>" + "<td>"
						+ data[i].university + "</td>" + "<td>"
						+ data[i].stu_class + "</td>" + "<td>" + data[i].status
						+ "</td>" + "<td><button onclick='myviewpro("
						+ data[i].id
						+ ")'>View</button><button onclick='myedit("
						+ data[i].id
						+ ")'>Edit</button><button onclick='mydeletepro("
						+ data[i].id + ")'>Delete</button></td>" + "</tr>";
			}

			str += "</table>";
			return str;
		}
	</script>
</body>
</html>