<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<body>
	<s:form action="search" namespace="/user" id="searchForm">
	<table>
		<tr>
			<td><s:textfield name="login" id="login2"/>
			</td>
			<td><s:submit id="button" value="Search"/>
			<script type="text/javascript">
						$("#login2").keyup(function() {								
							$('#searchForm').ajaxSubmit(function(data){
								$('#people').html(data);
							});
						});

			</script>
			</td>
		</tr>
	</table>
	</s:form>
	<div id="people">
	</div>




