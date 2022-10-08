package devforce.labs.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "password_historical")
@Getter
@Setter
@AllArgsConstructor
public class PasswordHistorical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private String password;
    @Column(name = "created_at")
    private Date createdAt;
}
