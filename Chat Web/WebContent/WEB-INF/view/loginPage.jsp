<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="headerCaption" /></title>
	<base href='<%=request.getScheme() %>://<%=request.getServerName() %>:<%=request.getServerPort() %>/chatWeb/' />
	<link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/text.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/960.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/tables.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
	<LINK REL="SHORTCUT ICON"
       HREF="resources/favicon.ico">
	
	<s:head/>
	<sj:head loadFromGoogle="false" jqueryui="true" compressed="false" jquerytheme="redmond" />
	<script type="text/javascript" src="resources/js/displayTagAjax.js"></script>
	<title><s:text name="enter" /></title>
	<link rel="stylesheet" type="text/css" href="resources/css/styleLogin.css" />
		
	<s:head />
	<sj:head />
</head>

<body>

<div id="container-wrap">

	<div id="container" class="container_16">
		
		<div id="content" >
			<div class="messageDiv">
				<s:actionmessage/> 
			</div>
			
			<div class="errorDiv">
				<s:actionerror/>
				<s:fielderror/>
			</div>
			
  			<div id="loginPage">
				<s:form action="tryLogin" >
        			<div>
            			<div class="loginlabel"><s:text name="username" /></div>
                		<div class="roundedfield" >  
                    		<s:textfield name="person.username"></s:textfield>
                		</div>
            		</div>
            		<div>
                		<div class="loginlabel"><s:text name="password" /></div>
                		<div class="roundedfield" > 
                    		<s:password name="person.password"></s:password>
                		</div>    
            		</div>
            		<input type="submit" class="button" value='<s:text name="enter" />' id="loginbutton" name="loginbutton"/>
            		<br>
            	
				</s:form>
		
  			</div>
		</div>
	</div>
</div>
		
</body>
</html>