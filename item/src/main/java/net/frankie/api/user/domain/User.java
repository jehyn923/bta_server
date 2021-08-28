package net.frankie.api.user.domain;

import lombok.Data;
import net.frankie.api.order.domain.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data @Entity
@Table(name = "users")
public class User {
    @Id @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "reg_date")
    private Date regDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
