package com.plohoy.bulls.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "web_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role_name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUserLogins() {
        return users;
    }

    public void setUserLogins(Collection<User> users) {
        this.users = users;
    }
}
