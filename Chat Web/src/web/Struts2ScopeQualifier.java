package web;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import constants.ScopeConstants;


/****
 * 
 * @author dolphin
 *
 */

public class Struts2ScopeQualifier implements ScopeQualifier {

	@SuppressWarnings("unchecked")
	public <U> U getValue(String name, ScopeConstants scope) {
		
		U u = null;
		
		switch (scope) {
		case REQUEST_SCOPE:
			u = (U)ServletActionContext.getRequest().getAttribute(name);
			break;
		/*case FLASH_SCOPE:
			u = (U)externalContext.getFlash().get(name);
			break;*/
		case SESSION_SCOPE:
			u = (U)ServletActionContext.getRequest().getSession().getAttribute(name);
			break;
		case APPLICATION_SCOPE:
			u = (U)ServletActionContext.getServletContext().getAttribute(name);
			break;
		default:
			break;
		}
		
		return u;
	}
	
	public <U> void setValue(String name, U u, ScopeConstants scope) {
		
		switch (scope) {
		case REQUEST_SCOPE:
			ServletActionContext.getRequest().setAttribute(name, u);
			break;
		/*case FLASH_SCOPE:
			externalContext.getFlash().put(name, u);
			break;*/
		case SESSION_SCOPE:
			ServletActionContext.getRequest().getSession().setAttribute(name, u);
			break;
		case APPLICATION_SCOPE:
			ServletActionContext.getServletContext().setAttribute(name, u);
			break;
		default:
			break;
		}
		
	}
	
	
	public void remove(String name, ScopeConstants scope) {
		
		switch (scope) {
		case REQUEST_SCOPE:
			ServletActionContext.getRequest().removeAttribute(name);
			break;
		/*case FLASH_SCOPE:
			externalContext.getFlash().remove(name);
			break;*/
		case SESSION_SCOPE:
			ServletActionContext.getRequest().getSession().removeAttribute(name);
			break;
		case APPLICATION_SCOPE:
			ServletActionContext.getServletContext().removeAttribute(name);
			break;
		default:
			break;
		}
		
	}
	
	public HttpSession getSession() {
		
		return ServletActionContext.getRequest().getSession(false);
		
	}

}
