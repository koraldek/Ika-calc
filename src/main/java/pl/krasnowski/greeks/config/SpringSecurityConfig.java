package pl.krasnowski.greeks.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	UrlAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/home", "/about","/index","/login","/resources/**","/img/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().successHandler(customAuthenticationSuccessHandler)
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
	
//	.rememberMe()
//	.and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable();
                http.authorizeRequests().antMatchers("/").permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}123").roles("USER")
                .and()
                .withUser("ad").password("{noop}1").roles("ADMIN");
    }
    

	

    /*
    //Spring Boot configured this already.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }*/

}
