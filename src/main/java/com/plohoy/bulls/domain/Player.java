package com.plohoy.bulls.domain;

import javax.persistence.*;
import java.util.Objects;

@Table(name="a_player")
@Entity
@NamedQueries({
        @NamedQuery(
                name = "RemoveAllTestData",
                query = "select p from Player p " +
                        "where p.login like :login"
)
})
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
    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return score == player.score &&
                Objects.equals(id, player.id) &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(login, player.login) &&
                Objects.equals(password, player.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, login, password, score);
    }

    @Override
    public String toString() {
        return "this Player:{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
