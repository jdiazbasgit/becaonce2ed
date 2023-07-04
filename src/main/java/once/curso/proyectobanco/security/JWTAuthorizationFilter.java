package once.curso.proyectobanco.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter implements Filter {

	private final String SECRET = "onceBanco";
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			if(checkJWTToken((HttpServletRequest) request)) {
				Claims claims=validateToken((HttpServletRequest) request);
				if(claims.get("roles") !=null)  {
					setUpSpringAuthentication(claims);
					
					System.out.println("autenticado:"+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
					
					
					
				}
				else {
					SecurityContextHolder.clearContext();
					System.out.println("autenticado:"+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

				}
			}
			else {
				
				//System.out.println("autenticado:"+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
				SecurityContextHolder.clearContext();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);

	}

	private boolean checkJWTToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER);
		if (token == null || !token.startsWith(PREFIX))
			return false;
		return true;

	}
	
	private Claims validateToken(HttpServletRequest request) {
		String token=request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		UsernamePasswordAuthenticationToken auth=
				new UsernamePasswordAuthenticationToken(claims.getSubject(), null,null);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
	}

}







