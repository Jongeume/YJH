<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>헤더</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath }/resources/main/libs/demo-assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- SmartMenus jQuery Bootstrap Addon CSS -->
<link
	href="${pageContext.request.contextPath }/resources/main/addons/bootstrap/jquery.smartmenus.bootstrap.css"
	rel="stylesheet">

<script type="text/javascript">
</script>

</head>
<body>
	<!-- Static navbar -->
	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">인강사이트</a>
		</div>
		<div class="navbar-collapse collapse">

			<!-- Left nav -->
			<ul class="nav navbar-nav">
				<li><a href="#">ㅋㅋ</a></li>
				<li><a href="#">정보</a></li>
				<li><a href="#">머 ㅋ</a></li>
				<li><a href="#">수강신청 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">A long sub menu <span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="#">Action</a></li>
										<li><a href="#">Something else here</a></li>
										<li class="disabled"><a class="disabled" href="#">Disabled
												item</a></li>
										<li><a href="#">One more link</a></li>
										<li><a href="#">Menu item 1</a></li>
										<li><a href="#">Menu item 2</a></li>
										<li><a href="#">Menu item 3</a></li>
										<li><a href="#">Menu item 4</a></li>
										<li><a href="#">Menu item 5</a></li>
										<li><a href="#">Menu item 6</a></li>
										<li><a href="#">Menu item 7</a></li>
										<li><a href="#">Menu item 8</a></li>
										<li><a href="#">Menu item 9</a></li>
										<li><a href="#">Menu item 10</a></li>
									</ul></li>
								<li><a href="#">Another link</a></li>
								<li><a href="#">One more link</a></li>
							</ul></li>
					</ul></li>
			</ul>
			<!-- Right nav 
			-->

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">회원정보 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/L_member/login">로그인</a></li>
						<li><a href="#">회원가입</a></li>
						<li><a href="#">아이디 찾기</a></li>
						<li><a href="#">비번 찾기</a></li>
					</ul></li>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>








	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/main/libs/demo-assets/bootstrap/js/bootstrap.min.js"></script>

	<!-- SmartMenus jQuery plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/main/jquery.smartmenus.js"></script>

	<!-- SmartMenus jQuery Bootstrap Addon -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/main/addons/bootstrap/jquery.smartmenus.bootstrap.js"></script>




</body>
</html>