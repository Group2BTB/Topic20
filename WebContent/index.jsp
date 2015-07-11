<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>



	<div class="container">
		<div class="text-center h2 text-primary">Student Management</div>
		<table class='table table-bordered' id="display">
		</table>
		<!-- Large modal -->
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title text-center text-primary"
							id="gridSystemModalLabel">Add Student Form</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-2 control-label">*Full Name :</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="stu_name"
												name="stu_name" placeholder="Full Name">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">*University :</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="stu_university"
												name="stu_university" placeholder="University">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">*Class :</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="stu-class"
												id="stu_class" placeholder="Class">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Gender</label>
										<div class="col-sm-10">
											<label class="radio-inline"> <input type="radio"
												name="gender" id="male" value="male"> Male
											</label> <label class="radio-inline"> <input type="radio"
												name="gender" id="female" value="female"> Female
											</label>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
		</div>
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
			str = "<tr class='bg-success'><th class='text-center'>ID</th>"
					+ "<th class='text-center'>Name</th>"
					+ "<th class='text-center'>Gender</th>"
					+ "<th class='text-center'>University</th>"
					+ "<th class='text-center'>Class</th>"
					+ "<th class='text-center'>Status</th>"
					+ "<th class='text-center'>Action</th></tr>";
			/*-----end---- */

			for (var i = 0; i < data.length; i++) {
				str += "<tr class='text-center'>" + "<td>"
						+ data[i].id
						+ "</td>"
						+ "<td>"
						+ data[i].name
						+ "</td>"
						+ "<td>"
						+ data[i].gender
						+ "</td>"
						+ "<td>"
						+ data[i].university
						+ "</td>"
						+ "<td>"
						+ data[i].stu_class
						+ "</td>"
						+ "<td>"
						+ data[i].status
						+ "</td>"
						+ "<td><button class='btn btn-primary btn-sm' onclick='myedit("
						+ data[i].id
						+ ")'>Edit</button>&nbsp;<button class='btn btn-primary btn-sm' onclick='mydeletepro("
						+ data[i].id
						+ ")'>Delete</button>&nbsp;<button class='btn btn-primary btn-sm' data-toggle='modal' data-target='.bs-example-modal-lg'>Add</button></td>"
						+ "</tr>";
			}
			return str;
		}
	</script>
</body>
</html>