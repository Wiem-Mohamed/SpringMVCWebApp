package com.global.hr.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
@Entity
@Data
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lasName;
    @NaturalId(mutable=true)
    private  String email;
    private String  password;
    private boolean isEnabled;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id",
                    referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String firstName, String lasName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
