package com.example.demo.config

//import com.example.demo.filter.JwtAuthenticationTokenFilter

import com.example.demo.filter.JwtFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.hierarchicalroles.RoleHierarchy
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
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
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //开启方法注解
class SecurityConfig : WebSecurityConfigurerAdapter() {

    // JWT拦截器
    @Autowired
    private val jwtFilter: JwtFilter? = null

    // 认证失败处理器
    @Autowired
    private val authenticationEntryPoint: AuthenticationEntryPoint? = null

    // 拒绝处理器
    @Autowired
    private val accessDeniedHandler: AccessDeniedHandler? = null


    // 注入BCryptPasswordEncoder
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            //关闭csrf
            .csrf().disable()
            //不通过Session获取SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/user/login").anonymous()
            // 除上面外的所有请求全部需要鉴权认证
            .anyRequest().authenticated()

        //添加JWT拦截器
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)

        //配置异常处理器
        http.exceptionHandling() //配置认证失败处理器
            .authenticationEntryPoint(authenticationEntryPoint)
            .accessDeniedHandler(accessDeniedHandler)

        //允许跨域
        http.cors()
    }

    //开启角色继承
    @Bean
    fun roleHierarchy(): RoleHierarchy? {
        val hierarchy = RoleHierarchyImpl()
        hierarchy.setHierarchy("ROLE_MANAGER > ROLE_VIP > ROLE_USER > ROLE_SEAL")
        return hierarchy
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

}