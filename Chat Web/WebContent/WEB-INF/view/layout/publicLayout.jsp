<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title><tiles:insertAttribute name="title"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="ru"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<s:head/>
	<sj:head loadFromGoogle="false" jqueryui="true" compressed="false" jquerytheme="redmond" />
	<base href='<%=request.getScheme() %>://<%=request.getServerName() %>:<%=request.getServerPort() %>/chatWeb/' />
	
	<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/content.css" rel="stylesheet" type="text/css" />
<link href="resources/css/main_menu_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/text.css">

<link rel="stylesheet" type="text/css" href="resources/css/accordion.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/css/tables.css">
<link rel="stylesheet" type="text/css" href="resources/css/fileuploader.css">

<!-- widget -->
<script type="text/javascript" src="resources/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="resources/js/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="resources/js/jquery.inputValue.js"></script>
<script type="text/javascript" src="resources/js/displayTagAjax.js"></script>
<script type="text/javascript" src="resources/js/jquery.form.js"></script>
<script type="text/javascript" src="resources/js/ui/jquery.effects.core.js"></script>
<script type="text/javascript" src="resources/js/ui/jquery.effects.blind.js"></script>
<script type="text/javascript" src="resources/js/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="resources/js/menu.js"></script>
<LINK REL="SHORTCUT ICON"
       HREF="resources/favicon.ico">
<script>
		!window.jQuery && document.write('<script src="../jquery-1.4.3.min.js"><\/script>');
	</script>
	<script type="text/javascript" src="resources/js/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
	<script type="text/javascript" src="resources/js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/js/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
	

<script type="text/javascript">

	function ajaxSumbitFormByFileSizeExceeded(formId, renderId){
		$('#' + formId).ajaxSubmit(function(data){
			if(jQuery.trim(data) == ''){
				alert('<s:text name="fileSizeExceded" />');
			}
			else {
				$('#' + renderId).html(data);
			}	
		});		
	}
	
	function callAjax(action, renderId, duration){
		$("#" + renderId).hide();
		$.ajax({
	  		url: action,
	  		success: function(data) {
	  			$("#" + renderId).html(data);
	  			$("#" + renderId).fadeIn(duration);
	  		}
	  	});
	}
	function sumbitFormToAction(formId, action){
		if(action.indexOf('?') == -1) action += '?';
		action += $('#' + formId).serialize();
		document.location = action;
	}
	function isFloat(val) {
		if(!val || (typeof val != "string" || val.constructor != String)) {
			return(false);
		}

		var isNumber = !isNaN(new Number(val));
		if(isNumber) {
			if(val.indexOf('.') != -1) {
				return(true);
			} 
			else {
				return(false);
			}
		} 
		else {
			return(false);
		}
	}
	function isEmpty(str) {
	    return (!str || 0 === str.length);
	}
</script>
	
	
	
	
	
</head>

<body>

<!-- <div id="ornament-top" class="ornament"></div> -->

<!-- HEADER -------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

<div id="header-wrap">

	<div id="header" class="container_16">
		<tiles:insertAttribute name="header" />
	</div>

</div>

<!-- HORIZONTAL MENU ------------------------------------------------------------------------------------------------------------------------------------------------------------------>

<div id="menu-wrap">

	<div id="menu" class="container_16">
		<div id="horizMenu" class="grid_16">
			<tiles:insertAttribute name="horizMenu" />
		</div>		
	</div>

</div>

<script language="javascript">setPage();</script>
		
<!-- WORK MENU -------------------------------------------------------------------------------------------------------------------------------------------------------------------->

<div id="work-menu-wrap">
	
	<div id="workMenu" class="grid_16">
		<div id="horizMenu" class="grid_16">
			<tiles:insertAttribute name="workMenu" />	
		</div>	
	</div>
		
</div>

<script language="javascript">setPage();</script>

<!-- CONTAINER ------------------------------------------------------------------------------------------------------------------------------------------------------------------->

<div id="container-wrap">
	
	<div id="container" class="container_16">
			
<!-- FILTER -------------------------------------------------------------------------------------------------------------------------------------------------------------------->

<!-- CONTENT -------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	
		<div id="content" class="grid_12">
			<div class="messageDiv">
				<s:actionmessage/> 
			</div>
			<div class="errorDiv">
				<s:actionerror/>
				<s:fielderror/>
			</div>
			<tiles:insertAttribute name="content" />
		</div>

<!-- VERTMENU ----------------------------------------------------------------------------------------------------------------------------------------------------------------------->
		
		<div id="vertMenu" class="grid_4">
			<tiles:insertAttribute name="news"/>
		</div>
		
	</div>

</div>

<!-- FOOTER -------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

<div id="footer-wrap">
			
	<div id="footer" class="container_16">
		<div id="footer-content" class="grid_16">	
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</div>

</body>
</html>