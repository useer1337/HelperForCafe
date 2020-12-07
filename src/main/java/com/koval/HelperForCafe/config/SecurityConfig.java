package com.koval.HelperForCafe.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    // Доступ только для незарег. пользователей
                    .antMatchers("/registration").not().fullyAuthenticated()
                    // Доступ для пользователей ROLE_USER TODO ДОБАВИТЬ ЛОГИКУ ДЛЯ РОЛЕЙ
                    // Доступ разрешен для всех пользователей
                    .antMatchers("/", "/index").permitAll()
                // Все остальные страницы требуют аутентификацию
                .anyRequest().authenticated()
                .and()
                    // Настройка для входа в систему
                    .formLogin()
                    .loginPage("/signin")
                    // Перенаправление на главную страницу после успешного входа
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");

    }
}
