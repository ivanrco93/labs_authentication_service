package devforce.labs.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, name = "uu_id", unique = true)
    private String uuId;
    private String identification;
    private String code;
    @Column(nullable=false, name = "sectional_id")
    private int sectionalId;
    @Column(nullable=false, name = "headquarter_id")
    private int headquarterId;
    @Column(nullable=false, name = "faculty_id")
    private int facultyId;
    @Column(nullable=false, name = "program_id")
    private int programId;
    @Column(nullable=false, name = "first_name")
    private String firstName;
    @Column(nullable=true, name = "first_name")
    private String secondName;
    @Column(nullable=false, name = "first_lastname")
    private String firstLastName;
    @Column(nullable=true, name = "first_name")
    private String secondLastName;
    private String email;
    @Column(nullable=true, name = "email_verified_at")
    private Date emailVerifiedAt;
    private String password;
    @Column(nullable=false, name = "profile_id")
    private int profileId;
    @Column(nullable=false, name = "remember_token")
    private String rememberToken;
    @Column(nullable=false, name = "next_pwd_change")
    private Date nextPasswordChange;
    private boolean status;
    @Column(nullable=false, name = "created_at")
    private Date createdAt;
    @Column(nullable=true, name = "created_by")
    private int createdBy;
    @Column(nullable=true, name = "updated_at")
    private Date updatedAt;
    @Column(nullable=true, name = "updated_by")
    private int updatedBy;
}
