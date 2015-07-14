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
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title text-center" id="myModalLabel">Add Student Form</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-3 control-label">*Full Name :</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="stu_name"
										name="stu_name" placeholder="Full Name">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">*University :</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="stu_university"
										name="stu_university" placeholder="University">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">*Class :</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="stu_class"
										id="stu_class" placeholder="Class">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">Gender</label>
								<div class="col-sm-8">
									<label class="radio-inline"> <input type="radio"
										name="gender" id="male" value="1"> Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" id="female" value="0"> Female
									</label>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary" onclick="addStudent()" data-dismiss="modal">Save</button>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center h2 text-primary">Student Management</div>
		<form class="navbar-form navbar-left col-sm-9">
			<div class="form-group ">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="button" class="btn btn-primary btn-md"
				data-toggle="modal" data-target="#myModal">Add</button>
		</form>
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
			var gender = "";
			var status = "";
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
				if (data[i].gender == 1) {
					gender = "M";
				} else {
					gender = "F";
				}

				if (data[i].status == 1) {
					status = "Active";
				} else {
					status = "Deactive";
				}
				str += "<tr class='text-center'>";
				str += "<td>"+ data[i].id+ "</td>";
				str	+= "<td>"+ data[i].name+ "</td>";
				str	+= "<td>"+ gender+ "</td>";
				str	+= "<td>"+ data[i].university+ "</td>";
				str	+= "<td>"+ data[i].stu_class+ "</td>";
				str += "<td>"+ status+ "</td>";
				str += "<td><button class='btn btn-primary btn-sm' onclick= myedit('"+data[i].id+"')>Edit</button>&nbsp;";
				str += "<button class='btn btn-primary btn-sm'onclick= deleteStudent('"+ data[i].id+"')>Delete</button></td>";
				str += "</tr>";
			}
			return str;
		}

		function addStudent() {
			$.ajax({
				url : "addstudent.act",
				method : "POST",
				data : {
					stu_name : $("#stu_name").val(),
					gender : $("input[name=gender]").val(),
					stu_university : $("#stu_university").val(),
					stu_class : $("#stu_class").val()
				},
				success:function(data){
					lists();
				},
				error: function(data){
					alert("fail");
				}
			}); 
		}
		
		/*------- Function Delete Student-------- */
		function deleteStudent(id){
			$.ajax({
				url: "deletestudent.act",//destination to get data
				method: "POST",// use post method
				data: {
					stu_id : id // assign value of id to stu_id in controller
				},
				success:function(data){
					lists();// call method list after delete student successfully
				},
				error: function(data){
					alert("Fail");
				}
			});
		}
		/* The end of function delete */
		
		/* ----------function update Student information-------- */
		function updateStudent(id){
			$.ajax({
				url: "updatestudent.act",
				method: "POST",
				data: {
					stu_id : id,
					stu_name : $("#stu_name").val(),
					stu_university : $("#stu_university").val(),
					stu_class: $("#stu_class").val(),
					gender: $("input[name=gender]").val()
				},
				success: function(data){
					
				},
				error: 
			});
		}
	</script>
</body>
</html>