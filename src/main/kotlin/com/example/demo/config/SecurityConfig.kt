package com.example.demo.config

//import com.example.demo.filter.JwtAuthenticationTokenFilter

import com.example.demo.handler.MyAccessDeniedHandlerImpl
import com.example.demo.handler.MyAuthenticationEntryPointImpl
import com.example.demo.handler.MyAuthenticationSuccessHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.hierarchicalroles.RoleHierarchy
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 15:26
 * @description :TODO
 */

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //开启方法注解
class SecurityConfig : WebSecurityConfigurerAdapter() {

//    // JWT拦截器
//    @Autowired
//    private val jwtFilter: JwtFilter? = null

    // 认证失败处理器
    @Autowired
    private val myAuthenticationEntryPointImpl: MyAuthenticationEntryPointImpl? = null

    // 拒绝处理器
    @Autowired
    private val myAccessDeniedHandlerImpl: MyAccessDeniedHandlerImpl? = null

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(java.lang.Exception::class)
    override fun configure(http: HttpSecurity) {

        http
            .authorizeRequests()//配置权限
            .anyRequest().authenticated()//任意请求需要登录
            .and()
            .formLogin()//开启formLogin默认配置
            .loginProcessingUrl("/login")//post登录接口，登录验证由系统实现
            .usernameParameter("username")    //要认证的用户参数名，默认username
            .passwordParameter("password")    //要认证的密码参数名，默认password
            .defaultSuccessUrl("/demo/user", true)//登录成功跳转接口
            .successHandler(MyAuthenticationSuccessHandler())
            .and()
            .csrf().disable()//禁用csrf


//        //添加JWT拦截器
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)


        //配置异常处理器
        http.exceptionHandling()
            .authenticationEntryPoint(myAuthenticationEntryPointImpl)
            .accessDeniedHandler(myAccessDeniedHandlerImpl)


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