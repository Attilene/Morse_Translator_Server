package morse.translator.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passwords")
public class Password implements Serializable {
    @Id
    private Long id;

    @Column(nullable = false, length = 150)
    private String hash;

    @Column(nullable = false, length = 70)
    private String salt;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Long getId() { return id; }

    public String getHash() { return hash; }

    public String getSalt() { return salt; }

    public User getUser() { return user; }

    public void setHash(String hash) { this.hash = hash; }

    public void setSalt(String salt) { this.salt = salt; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Password{" +
                "hash='" + hash + '\'' +
                ", salt='" + salt + '\'' +
                ", user=" + user +
                '}';
    }
}