<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.NhanVien" %><!--import model-->
 <%
 String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();//lấy absolute link
 %>
<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>
    CONTACT US
  </title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Raleway:400,700&display=swap" rel="stylesheet" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>
<!-- header -->
	<jsp:include page="header.jsp" />

  <!-- contact section -->

  <section class="contact_section layout_padding-bottom layout_padding2-top">
    <div class="container px-0">
      <div class="heading_container">
        <h2 class="">
          Con<span>ta</span>ct Us
        </h2>
      </div>

    </div>
    <div class="container container-bg">
      <div class="row">
        <div class="col-lg-8 col-md-7 px-0">
          <div class="map_container">
            <div class="map-responsive">
              
              <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3227.149094916142!2d139.0049407!3d36.01665239999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x601eb79f3ee6ddc7%3A0xf39941c83f50324d!2s182%20Ogano%2C%20Chichibu%20District%2C%20Saitama%20368-0105!5e0!3m2!1sen!2sjp!4v1677915270347!5m2!1sen!2sjp" width="600" height="300" frameborder="0" style="border:0; width: 100%; height:100%" allowfullscreen></iframe>
            </div>
          </div>
        </div>
        <div class="col-md-5 col-lg-4 px-0">
          <form action="">
            <div>
              <input type="text" placeholder="Name" />
            </div>
            <div>
              <input type="email" placeholder="Email" />
            </div>
            <div>
              <input type="text" placeholder="Phone" />
            </div>
            <div>
              <input type="text" class="message-box" placeholder="Message" />
            </div>
            <div class="d-flex ">
              <button>
                SEND
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>

  <!-- end contact section -->

  <!-- client section -->

  <section class="client_section layout_padding-bottom">
    <div class="container">
      <div class="heading_container">
        <h2>
          What <span>says</span> our clients
        </h2>
      </div>
      <div class="box">
        <div class="client_id">
          <div class="name">
            <h4>
              Mr <br>
              Tien
            </h4>
          </div>
          <div class="img-box">
            <img src="images/client.jpg" alt="">
          </div>
        </div>
        <div class="detail-box">
          <p>
            Thank you so much. Good job!
          </p>
          <img src="images/quote.png" alt="">
        </div>
      </div>
    </div>
  </section>

  <!-- end client section -->
<!-- footer -->
	<%@include file="footer.jsp"%>

  
</html>