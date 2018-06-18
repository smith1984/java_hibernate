package ru.smith.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.smith.model.Model;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table (name = "user")
public class User extends Model {

    private static final long serialVersionUID = -336854176402360374L;

    private String firstName;

    private String lastName;

    private int age;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    //@ManyToOne
    //@JoinColumn (name = "ROLE_ID", nullable = false)
    //private Role role;

    @ManyToMany
    @JoinTable (name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
