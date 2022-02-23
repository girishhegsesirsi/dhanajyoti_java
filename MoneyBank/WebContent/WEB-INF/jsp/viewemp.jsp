<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="ISO-8859-1">
<title>Ang Model</title>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	 
	 <script type="text/javascript" src="resources/js/controllers.js"></script>
	  <script type="text/javascript" src="resources/js/app.js"></script>
	 
	 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>

<script>
var app=angular.module("app",['controllers']);
var bankControllers=angular.module("controllers",[]);
bankControllers.controller('userCtrl',['$scope',function($scope){
	$scope.username="girish";

	$scope.getLength=function(){
		return $scope.mobile.length;
	}
	$scope.getStrength=function(){
		if($scope.password.length>5)
			alert("strong password");
		else
			alert("weak password");
	}
}]);
</script>

</head> 
<body>
<div ng-controller="userCtrl">
<form>
<p><label for="username">Username: </label>
<input type="text" name="username" ng-model="username" id="username"/>
<span id="displayUsername">Your username is: <i>{{username}}</i></span>
</p>
<p ng-init="mobile=1234567890"><label for="mobile">mobile: </label>
<input type="text" name="mobile" ng-model="mobile" id="umobile"/>
<span id="displayUMobileNumber">Your mobile number is: <i>{{mobile}}</i></span>
<span id="displayUMobileNumberStrength">Your mobile number length is: <i>{{getLength()}}</i></span>
</p>
<p><label for="password">Password: </label>
<input type="password" name="password" ng-model="password" id="password" onclick="getStrength()"/>
<span id="displayPassword">Your password is: <i>{{password}}</i></span>
<button value="button" ng-click="getStrength()">Submit</button>
</p>
<div ng-controller="userCtrl">
<p ><label for="mobile">mobile: </label>
<input type="text" name="mobile" ng-model="mobile" id="mobile"/>
<span id="displayUMobileNumber2">Your mobile number is: <i>{{mobile}}</i></span>
<span id="displayUMobileNumberStrength2">Your mobile number is: <i>{{getLength()}}</i></span>
</p>
<div>
</form>
</div>
</body>
</html>