<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
	
	<script type="text/javascript">
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
	</script>




<div class="grid_12">
<s:form action="register" id="registerFormId">

	<div id="form-wrap">
	
		
		<table id="userInformation" class="large-form">
				
		
		
			<tr class="heading" >
				<td class="label"></td>
				<td><s:text name="userInformation"/></td>
			</tr>
	    	<tr>
			</tr>
			<tr class="topBorder">			
				<td class="label">
					<span class="required">*</span>
					<s:text name="roleParticipant" />
				</td>
				<td class="radioButtonsBlock">
					<s:radio id="role" name="person.role" list="roles" />
				
				</td>
			</tr>
			<tr>
				<td class="label">
					<span class="required">*</span>
					<s:text name="fullName" />
				</td>
				<td>
					<s:textfield name="person.name"/>
				</td>
				
			</tr>	
			<tr>
				<td class="label">
					<span class="required">*</span>
					<s:text name="username" />
				</td>
				<td>
					<s:textfield name="person.username" id="usernameField" />
				</td>
			</tr>
			<tr>
				<td class="label">
					<span class="required">*</span>
					<s:text name="email" />
				</td>
				<td>
					<s:textfield name="person.email" id="emailField" />
				</td>
			</tr>	
			
			<tr>
				<td class="label">
					<span class="required">*</span>
					<s:text name="password"/>
				</td>
				<td>
					<s:password name="person.password" id="passwordField" />
				</td>
			</tr>	
			<tr>
				<td class="label">
					<span class="required">*</span>
					<s:text name="passwordConfirm" />
				</td>
				<td>
					<s:password name="passwordConfirmation" id="passwordConfirmField" />
				</td>
			</tr>
			<tr>
				<td class="label">
					&nbsp;
				</td>
				<td align="center">
				<style>
						#submit{
						text-decoration: none;
					    float:left;
					    border: 1px solid white;
					    border-radius: 5px;
					    background:#4D90FE;
					    width:330px;
					    cursor: pointer;
					  }
				</style>
				
					<input id="submit" type="submit" value='<s:text name="register" />'></input>
				
				</td>
			</tr>
		</table>
	</div>
</s:form>
</div>

