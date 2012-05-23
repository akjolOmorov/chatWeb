package struts2.intercepters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import web.LoginUtil;
import web.Struts2ScopeQualifier;


import annotation.Logged;
import annotation.RolesAllowed;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constants.ScopeConstants;
import domain.Person;

/****
 * 
 * @author dolphin
 *
 */

public class Struts2SecurityInteceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 5264617333686157887L;

	@Override
	public String intercept(ActionInvocation ivn) throws Exception {
		
		@SuppressWarnings("rawtypes")
		Class clazz = ivn.getAction().getClass();
		String methodName = ivn.getProxy().getMethod();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		for (Method method : clazz.getMethods()) {
			if(method.getName().equals(methodName)){
				Annotation[] annotations = method.getAnnotations();
				boolean allowed = true;
				
				try {
					for (Annotation annotation : annotations) {
						if(annotation instanceof RolesAllowed){
							RolesAllowed securityRoles = (RolesAllowed)annotation;
							String role = securityRoles.role();
							Person person = new Struts2ScopeQualifier().getValue(LoginUtil.CURRENT_USER_SESSION_KEY, ScopeConstants.SESSION_SCOPE);
							if(person != null && role != null){
								allowed = LoginUtil.userHasRole(person, role);
							}
							else {
								allowed = false;
							}
						}
						if(annotation instanceof Logged){
							if(!LoginUtil.isLogged()) allowed = false;
						}
					}
					if(!allowed) return isAjax(request) ? "access_denied_ajax" : "access_denied";
				} catch (Exception e) {}
			}
		}
		
		return ivn.invoke();
	}
	
	private static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}


}
