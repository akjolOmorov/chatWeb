<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	<script type="text/javascript">
		$(document).ready(function() {		
			$("#example").fancybox({
				'width':470,  
			    'height':250,  
			    'transitionIn'      : 'elastic',  
			    'transitionOut'     : 'elastic',
			    
			    'autoDimensions': false
				
			});
		});
	</script>
	
<a id="example" href="user/add.action"><s:submit value="Add"/></a>
	

<div class="displaytable">
    	<s:url action="friends" var="url" namespace="/user" />
    	<display:table export="true" uid="row" htmlId="dispTable" name="friendsList" requestURI="${url}">
    		<display:column property="friend.name" titleKey="Name Surname"  />
    		<display:column property="friend.username" titleKey="Login"  />
    		
    	</display:table>
    </div>
