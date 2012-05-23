package struts2.intercepters;

import java.util.Locale;
import java.util.Map;

import web.LoginUtil;
import web.ScopeQualifier;
import web.Struts2ScopeQualifier;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constants.ScopeConstants;

/****
 * 
 * @author dolphin
 *
 */

public class TilesI18nInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = -2485001028953782799L;
	private final static String TILES_LOCALE_SESSION_KEY = "org.apache.tiles.LOCALE";

	public String intercept(ActionInvocation invocation) throws Exception {
		Locale struts2Locale = invocation.getInvocationContext().getLocale();
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		if (session != null || LoginUtil.getCurrentUser() != null) 
			if (ActionContext.getContext().getSession().containsKey(LoginUtil.CURRENT_USER_SESSION_KEY))
			{
				ScopeQualifier qualifier = new Struts2ScopeQualifier();
				String language = qualifier.getValue(LoginUtil.CURRENT_LANGUAGE_SESSION_KEY, ScopeConstants.SESSION_SCOPE);
				if(language == null) language = "ru";
				System.out.println(language);
				//if(language == null) return invocation.invoke();
				struts2Locale = new Locale(language);
				session.put(TILES_LOCALE_SESSION_KEY, struts2Locale);
			}
			else session.put(TILES_LOCALE_SESSION_KEY, struts2Locale);
			
		ActionContext.getContext().setLocale(struts2Locale);
		
		return invocation.invoke();
	}

}
