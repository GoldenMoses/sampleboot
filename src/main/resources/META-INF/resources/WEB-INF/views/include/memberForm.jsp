<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  <script>
  
  	  $(document).ready(function(){
  		  
  		  $("#userid").on("keyup",function(){
  			 
  			  	$.ajax({
  			  	   url:'userid-check',
  			  	   method:'get',
  			  	   dataType:"text",
  			  	   data:{
  			  		   "userid":$(this).val()
  			  	   },
  			  	   success:function(res, status ,xhr){
  			  		   $("#result").text(res);
  			  	   },
  			  	   error:function(){}
  			  	});
  			  
  		  });
  		  
  	  });
  
  </script>
 
  <div class="TodoApp">
    <div class="container">
            <div class="Login">
            <h1>회원가입화면</h1>
            <div class="signUpForm">
              <form:form  method="post" modelAttribute="member" 
              action="signup">
                <div>
                    <label for="userid">userid:</label>
                    <form:input type="text" path="userid" />
                    <form:errors path="userid" cssClass="text-warning"/>
                </div>
                <div>
                    <label for="password">passwd:</label>
                    <form:input type="passwd" path="passwd" value="1234" />
  					 <form:errors path="passwd" cssClass="text-warning"/>
                </div>
                 <div>
                    <label for="username">username:</label>
                    <form:input type="text" path="username" />
                    <form:errors path="username" cssClass="text-warning"/>
                </div>
                <div>
                    <button name="login" class="btn btn-success m-5" >signup</button>
                </div>
               </form:form> 
            </div>
        </div>
        </div>
    </div>
