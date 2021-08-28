package net.frankie.api.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN","관리자권한"),
    USER("ROLE_USER","사용자권한"),
    UNKNOWN_USER("ROLE_UNKNOWN_USER","알수없는 사용자");
    private final String code;
    private final String description;

    @Override
    public String getAuthority() { return name(); }
}
