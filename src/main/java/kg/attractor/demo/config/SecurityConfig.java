package kg.attractor.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String userQuery = "select EMAIL, PASSWORD, ENABLED from USERS\n" +
                "where EMAIL = ?;";

        String roleQuery = "select EMAIL, ROLE_NAME from USERS u, ROLES r\n" +
                "where u.EMAIL = ?\n" +
                "and u. ROLE_ID = r.ID;";

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(roleQuery);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> login
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers(
                                        "/resume/**",
                                        "/vacancy/**",
                                        "/profile/**").fullyAuthenticated()
                                .requestMatchers(
                                        "/auth/register",
                                        "/resume",
                                        "/resume/category/**",
                                        "/vacancy",
                                        "/vacancy/category/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                .anyRequest().permitAll()
                );
        return http.build();
    }
}
