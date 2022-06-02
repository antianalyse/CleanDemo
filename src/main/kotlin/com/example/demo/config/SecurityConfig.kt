package com.example.demo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 15:26
 * @description :TODO
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启前置和后置验证
class SecurityConfig : WebSecurityConfigurerAdapter() {

    //创建BCryptPasswordEncoder注入容器
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Autowired
    private val jwtAuthenticationTokenFilter: JwtAuthenticationTokenFilter? = null

    //认证失败
    @Autowired
    private val authenticationEntryPoint: AuthenticationEntryPoint? = null

    //拒绝处理器
    @Autowired
    private val accessDeniedHandler: AccessDeniedHandler? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable() //关闭csrf
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //不通过Session获取SecurityContext
            .and()
            .authorizeRequests()
            .antMatchers("/user/login").anonymous()
            // .antMatchers("/testCors").hasAuthority("system:dept:list222")
            // 除上面外的所有请求全部需要鉴权认证
            .anyRequest().authenticated()

        //添加过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter::class.java)

        //配置异常处理器
        http.exceptionHandling() //配置认证失败处理器
            .authenticationEntryPoint(authenticationEntryPoint)
            .accessDeniedHandler(accessDeniedHandler)

        //允许跨域
        http.cors()
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}