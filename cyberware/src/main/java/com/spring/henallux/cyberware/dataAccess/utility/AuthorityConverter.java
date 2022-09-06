package com.spring.henallux.cyberware.dataAccess.utility;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AuthorityConverter {
    public static Collection<GrantedAuthority> authorityStringToAuthorityCollection(String authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");
            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }
    public static String authorityCollectionToAuthorityString(Collection<GrantedAuthority> grantedAuthorities) {
        StringBuilder authorities = new StringBuilder();
        if (grantedAuthorities != null && !grantedAuthorities.isEmpty()) {
            for (GrantedAuthority authority : grantedAuthorities) {
                if (authority != null && !authority.getAuthority().isEmpty()) {
                    authorities.append(authority.getAuthority()).append(",");
                }
            }
        }
        int lastCharacterPosition = authorities.length() - 1;
        Character lastCharacter = authorities.charAt(lastCharacterPosition);
        if (lastCharacter.equals(',')) {
            authorities.deleteCharAt(lastCharacterPosition);
        }
        return authorities.toString();
    }
}
