package ua;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		JDBC AUTHENTICATION
		auth.jdbcAuthentication().dataSource(dataSource);
		
//		HARD CODED USERS
//		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication().withUser(userBuilder.username("emp1").password("1234").roles("EMPLOYEE"))
//				.withUser(userBuilder.username("admin1").password("1234").roles("EMPLOYEE", "ADMIN"))
//				.withUser(userBuilder.username("man1").password("1234").roles("EMPLOYEE", "MANAGER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/myLoginPage")
//				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll();
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/admins/**").hasRole("ADMIN").and().formLogin().loginPage("/myLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/restricted");

	}

}
