package devforce.labs.authentication.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable=false, name = "uu_id", unique = true)
    private String uuId;

    @Column(name = "identification")
    private String identification;

    @Column(name = "code")
    private String code;

    @Column(nullable=false, name = "sectional_id")
    private Integer sectionalId;

    @Column(nullable=false, name = "headquarter_id")
    private Integer headquarterId;

    @Column(nullable=false, name = "faculty_id")
    private Integer facultyId;

    @Column(nullable=false, name = "program_id")
    private Integer programId;

    @Column(nullable=false, name = "first_name")
    private String firstName;

    @Column(nullable=true, name = "second_name")
    private String secondName;

    @Column(nullable=false, name = "first_lastname")
    private String firstLastName;

    @Column(nullable=true, name = "second_lastname")
    private String secondLastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(nullable=true, name = "email_verified_at")
    private Date emailVerifiedAt;

    @Column(name = "password")
    private String password;

    @Column(nullable=false, name = "profile_id")
    private Integer profileId;

    @Column(nullable=true, name = "remember_token")
    private String rememberToken;

    @Column(nullable=false, name = "next_pwd_change")
    private Date nextPasswordChange;

    @Column(name = "status")
    private boolean status;

    @Column(nullable=false, name = "created_at")
    private Date createdAt;

    @Column(nullable=true, name = "created_by")
    private Integer createdBy;

    @Column(nullable=true, name = "updated_at")
    private Date updatedAt;

    @Column(nullable=true, name = "updated_by")
    private Integer updatedBy;
}
