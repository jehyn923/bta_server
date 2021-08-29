package net.frankie.api.security.config;

import lombok.RequiredArgsConstructor;
import net.frankie.api.security.domain.SecurityProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    //private final SecurityProvider securityProvider;
    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }
}
