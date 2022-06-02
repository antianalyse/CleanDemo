package com.example.demo.domain

import com.example.demo.po.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 10:50
 * @description :TODO
 */
data class LoginUserDetails(private val user: User) : UserDetails {

    //存储SpringSecurity所需要的权限信息的集合
    private val authorities: List<SimpleGrantedAuthority>? = null

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        if (authorities != null) {
            return authorities
        }
        return listOf(SimpleGrantedAuthority(user.role))
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.id
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}