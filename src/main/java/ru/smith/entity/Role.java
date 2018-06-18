package ru.smith.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.smith.model.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "role")
@Data
@NoArgsConstructor
public class Role extends Model {

    private static final long serialVersionUID = -2238566275244330667L;

    private String nameRole;

    //@OneToMany (mappedBy = "role")
    @ManyToMany (mappedBy = "roles")
    private List<User> users;
}