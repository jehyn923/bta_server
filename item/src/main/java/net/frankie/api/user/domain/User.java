package net.frankie.api.user.domain;

import lombok.Data;
import net.frankie.api.order.domain.Order;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data @Entity
@Table(name = "users")
public class User {
    @Id @Column(name = "user_id")
    private long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min=8, message="8자리 이상 입력하시오")
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "reg_date")
    private String regDate;

    //접속 권한 판단을 위해선 load를 해놓은 상태에서 진행해야 하기 때문에, Eager 처리
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
