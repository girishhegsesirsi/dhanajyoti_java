<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>MoneyBank</title>
	    
	    <!-- AngularJs Javascript File -->
	    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.1.5/angular.min.js"></script>
	  <!-- Bootstrap Css -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		
		
		 <script type="text/javascript" src="resources/js/controllers.js"></script>
	  <script type="text/javascript" src="resources/js/app.js"></script>
	  <script type="text/javascript" src="resources/js/customServices.js"></script>
	<!-- <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
	 <script type="text/javascript" src="resources/js/angular.min.js"></script>
	 <script type="text/javascript" src="resources/js/controllers.js"></script>
	 <link rel="stylesheet" href="resources/CSS/bootstrap.min.css"/>  -->
	

	   
	</head>
	<body>
	    <div id="angularSpring" class="container">
	        <h1 align="center" class="text-primary">MoneyBank Netbanking</h1>
	        <hr />
	        
	        <!------ AngularJs and Spring Mvc Example ------>
	        <div data-ng-app="app" data-ng-controller="userCtrl">
	        <form data-ng-submit="" name="myForm" class="form-horizontal">
	        
	         <div class="row">
	          <div class="form-group col-md-12">
	         <div class="col-md-5">
	            <input type="text" data-ng-model="firstname" name="fname" id="firstname" class="username form-control input-sm" placeholder="Enter first name" required data-ng-minlength="3"/>
	            <div class="has-error" data-ng-show="$scope.firstname.$dirty">
                                      <span data-ng-show="$scope.firstname.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.fname.$error.minlength">Minimum length required is 3</span>
                                      <span data-ng-show="myForm.fname.$invalid">This field is invalid </span>
                                  </div>
	            
	            </div>
	            <div class="col-md-5">
	            <input type="text" data-ng-model="ctrl.user.lastname" name="lname" class="username form-control input-sm" placeholder="Enter last name" required data-ng-minlength="3"/>
	            <div>&nbsp;</div>
	            </div>
	            </div>
	            </div>
	            
	            <div class="row">
	          <div class="form-group col-md-12">
	         <div class="col-md-5">
	            <input type="text" data-ng-model="ctrl.user.firstname" name="dob" class="dob form-control input-sm" placeholder="Enter birth date" required data-ng-minlength="3"/>
	            <div class="has-error" data-ng-show="$scope.myForm.$dirty">
                                      <span data-ng-show="myForm.fname.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.fname.$error.minlength">Minimum length required is 3</span>
                                      <span data-ng-show="myForm.fname.$invalid">This field is invalid </span>
                                  </div>
	            
	            </div>
	            <div class="col-md-5">
	            <input type="text" data-ng-model="ctrl.user.adrl1" name="adrl1" class="adrl1 form-control input-sm" placeholder="Enter address line1" required data-ng-minlength="3"/>
	            <div>&nbsp;</div>
	            </div>
	            </div>
	            </div>
	            
	            

	            
	            </form>
	        </div>
	    </div>
	</body>
</html>