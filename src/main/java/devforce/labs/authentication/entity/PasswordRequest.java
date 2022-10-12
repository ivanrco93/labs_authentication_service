package devforce.labs.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "password_request")
@Getter
@Setter
@AllArgsConstructor
public class PasswordRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String requestId;
    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private Integer status;
    @Column(nullable=false, name = "created_at")
    private Date createdAt;
    @Column(nullable=false, name = "updated_at")
    private Date updatedAt;
}
