<%@ page language="java" contentType="text/html; charset=UTF-8"  
  pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<c:set var="language"  
  value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"  
  scope="session" />  
<fmt:setLocale value="${language}" />  
<fmt:setBundle basename="com.i18n.text" />  
<html lang="en">  
 
<head>  
 
<meta charset="utf-8">  
<link rel="stylesheet"  
  href="https://fonts.googleapis.com/icon?family=Material+Icons">  
<link type="image/png" rel="icon"  
  href="${pageContext.servletContext.contextPath}/resources/themes/images/ico/favicon.png">  
<title>MAIN PAGE</title>  
 
<link  
  href="${pageContext.servletContext.contextPath}/resources/css/rangeSlider/rangeStyle.css"  
  rel="stylesheet">  
 
<link  
  href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css"  
  rel="stylesheet">  
 
<link  
  href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/simple-sidebar.css"  
  rel="stylesheet">  
 
<link type="text/css" rel="stylesheet"  
  href="${pageContext.servletContext.contextPath}/resources/materialize/css/materialize.min.css"  
  media="screen,projection" />  
 
 
<link rel="stylesheet"  
  href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/languages.min.css">  
 
 
<link rel="stylesheet"  
  href="${pageContext.servletContext.contextPath}/resources/css/jPage/style.css">  
 
<link  
  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"  
  rel="stylesheet">  
 
<link rel="stylesheet"  
  href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">  
 
<link  
  href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/8.5.1/nouislider.min.css"  
  rel="stylesheet">  
 
<style>  
div #sidebar-wrapper {  
  position: relative;  
  left: 0;  
  margin-top: 0px;  
}  
 
.bg-img {  
  border-style: solid;  
  border-width: 3px 0px 0px;  
  border-color: grey;  
  width: 100%;  
  /*   background: */  
  /*     url('http://3.bp.blogspot.com/-UXVFcPTKwrk/VC9-GaPAooI/AAAAAAAAFfo/g_uYO8A1PCo/s1600/black%2Bgrey%2Bgradient%2Bbackground%2Bfor%2Bweb.jpg') */  
  background:  
    url(${pageContext.servletContext.contextPath}/resources/images/foot.jpg)  
    center center no-repeat;  
  background-size: cover; &: before { content : '';  
  position: absolute;  
  top: 0;  
  right: 0;  
  bottom: 0;  
  left: 0;  
  background-image: linear-gradient(to bottom right, #002f4b, #dc4225);  
  opacity: .6;  
}  
 
.well {  
  padding: 0px;  
}  
</style>  
</head>  
 
 
<body>  
  <input id="lang" type="hidden" value="${language}" />  
  <input id="mapping" type="hidden"  
    value="${pageContext.servletContext.contextPath}/" />  
 
 
  <!-- Header ========================================================================= -->  
  <jsp:include page="header.jsp"></jsp:include>  
  <!-- Header End====================================================================== -->  
    
    
    
    
    
    
    
    
  <div class="container">  
  <table id="example" class="display" cellspacing="0" width="100%">  
        <thead>  
            <tr>  
                <th>№</th>  
                <th>Type</th>  
                <th>Capacity</th>  
                <th>Good</th>  
                <th>Food</th>  
                <th>Percentage</th>  
                <th>Price</th>  
            </tr>  
        </thead>  
        <tbody>  
            <tr>  
                <td>Tiger Nixon</td>  
                <td>System Architect</td>  
                <td>Edinburgh</td>  
                <td>61</td>  
                <td>2011/04/25</td>  
                <td>$320,800</td>  
            </tr>  
            <tr>  
                <td>Garrett Winters</td>  
                <td>Accountant</td>  
                <td>Tokyo</td>  
                <td>63</td>  
                <td>2011/07/25</td>  
                <td>$170,750</td>  
            </tr>  
            <tr>  
                <td>Ashton Cox</td>  
                <td>Junior Technical Author</td>  
                <td>San Francisco</td>  
                <td>66</td>  
                <td>2009/01/12</td>  
                <td>$86,000</td>  
            </tr>  
            <tr>  
                <td>Cedric Kelly</td>  
                <td>Senior Javascript Developer</td>  
                <td>Edinburgh</td>  
                <td>22</td>  
                <td>2012/03/29</td>  
                <td>$433,060</td>  
            </tr>  
    </table>  
  </div>  
    
    
<!-- Footer ========================================================================== -->  
  <jsp:include page="foot.jsp"></jsp:include>  
  <!-- Footer END==================================================================== -->  
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.js"></script>  
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>  
  <script type="text/javascript">$(document).ready(function() {  
      $('#example').DataTable( {  
          "paging":   false,  
          "ordering": false,  
          "info":     false  
      } );  
  } );</script>  
   
<!-- 
 
//--> 
</script>  
</body>  
 
</html>