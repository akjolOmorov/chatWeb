package struts2.intercepters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain next) throws IOException, ServletException 
	{
	    String encoding = request.getCharacterEncoding();
	    if (encoding == null || encoding.length() == 0)
	    {
	        request.setCharacterEncoding("UTF-8");
	    }
	    encoding = request.getCharacterEncoding();
	    next.doFilter(request, response); 
	}

	@Override
	public void destroy() {}

}
