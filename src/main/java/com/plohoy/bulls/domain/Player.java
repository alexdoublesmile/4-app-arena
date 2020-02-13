package com.plohoy.bulls.domain;

import javax.persistence.*;

@Table(name="a_player")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;
    @Column(name = "player_first_name")
    private String firstName;
    @Column(name = "player_last_name")
    private String lastName;
    @Column(name = "player_login")
    private String login;
    @Column(name = "player_password")
    private String password;
    @Column(name = "player_score")
    private String score;
}
