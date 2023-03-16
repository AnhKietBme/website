<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>WEBSITE TINH TIEN LUONG</title>
	<head>
  <!-- Basic -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Site Metas -->
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Raleway:400,700&amp;display=swap" rel="stylesheet">
  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet">
  <link	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"	rel="stylesheet">
  <script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"crossorigin="anonymous"></script>
  <style type="text/css" id="operaUserStyle"></style></head>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp" />
	<!-- Page content -->
	<div class="container mt-4">
	<h1 class="text-center">Salary calculator</h1>
	<!-- Slider and Products -->
			<div class="col-lg-12">
	<!-- Slider -->
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="images/p1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/p2.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/p3.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				</div>
				<!-- End Slider -->
		</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>

</body>
</html>