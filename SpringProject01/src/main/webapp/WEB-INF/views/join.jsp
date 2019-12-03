<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>회원관리 - 회원가입</title>

<!-- Icons font CSS-->
<link href="${pageContext.request.contextPath }/resources/join/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath }/resources/join/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="${pageContext.request.contextPath }/resources/join/vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath }/resources/join/vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="${pageContext.request.contextPath }/resources/join/css/main2.css" rel="stylesheet" media="all">

<!-- Jquery JS-->
<script src="${pageContext.request.contextPath }/resources/join/vendor/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="${pageContext.request.contextPath }/resources/join/vendor/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/join/vendor/datepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/join/vendor/datepicker/daterangepicker.js"></script>

<!-- Main JS-->
<script src="${pageContext.request.contextPath }/resources/join/js/global.js"></script>

</head>

<body>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960">
			<div class="card card-2">
				<div class="card-heading"></div>
				<div class="card-body">
					<h2 class="title">회원가입 </h2>
					<form method="POST">
						<div class="input-group">
							<input class="input--style-2" type="text" placeholder="Name"
								name="name">
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2 js-datepicker" type="text"
										placeholder="Birthdate" name="birthday"> <i
										class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="gender">
											<option disabled="disabled" selected="selected">Gender</option>
											<option>Male</option>
											<option>Female</option>
											<option>Other</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="class">
									<option disabled="disabled" selected="selected">Class</option>
									<option>Class 1</option>
									<option>Class 2</option>
									<option>Class 3</option>
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="text"
										placeholder="Registration Code" name="res_code">
								</div>
							</div>
						</div>
						<div class="p-t-30">
							<button class="btn btn--radius btn--green" type="submit">Search</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>