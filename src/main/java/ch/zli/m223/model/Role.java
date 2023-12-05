package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Role {

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "role")
    @JsonIgnoreProperties("role")
    @Fetch(FetchMode.JOIN)
    private Set<ApplicationUser> user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<ApplicationUser> getUser() {
        return user;
    }

    public void setUser(Set<ApplicationUser> user) {
        this.user = user;
    }
}
