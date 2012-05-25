<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<div class="displaytable">
    	<display:table export="true" uid="row" htmlId="dispTable" name="people" >
    		<display:column titleKey="Name Surname">
    		<s:url var="url" action="addFriend" namespace="/user" escapeAmp="false">
    				<s:param name="id">${row.id}</s:param>
    		</s:url>
    		<a href="${url}">
					${row.name}
			</a>
    		</display:column>
    		<display:column property="username" titleKey="Login"  />
    		
    	</display:table>
  </div>