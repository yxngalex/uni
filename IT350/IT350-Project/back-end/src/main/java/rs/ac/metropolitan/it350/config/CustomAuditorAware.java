package rs.ac.metropolitan.it350.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Component
public class CustomAuditorAware implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		// After implementing Spring Security uncomment these lines to 
		// enable user auditing
		// Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// if (authentication != null) return Optional.of(authentication.getName());

		return Optional.of("system");
	}
}