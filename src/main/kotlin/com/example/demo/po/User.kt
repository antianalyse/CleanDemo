package com.example.demo.po

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 10:50
 * @description :TODO
 */
data class User(
    private var username: String,
    private var password: String,
    var nickname: String?,
    var role: String?
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role)
    }


    override fun getPassword(): String {
        return this.password
    }

    override fun getUsername(): String {
        return this.username
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