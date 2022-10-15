package devforce.labs.authentication.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
/*@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor*/
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable=false, name = "uu_id", unique = true)
    private String uuId;

    @Size(max = 12, message = "Value has exceded maximum length of {max} characters")
    @NotBlank(message = "Field is mandatory")
    @Column(name = "identification")
    private String identification;

    @Size(max = 10, message = "Value has exceded maximum length of {max} characters")
    @Column(name = "code")
    private String code;

    @NotNull(message = "Field is mandatory")
    @Column(nullable=false, name = "sectional_id")
    private Integer sectionalId;

    @NotNull(message = "Field is mandatory")
    @Column(nullable=false, name = "headquarter_id")
    private Integer headquarterId;

    @NotNull(message = "Field is mandatory")
    @Column(nullable=false, name = "faculty_id")
    private Integer facultyId;

    @NotNull(message = "Field is mandatory")
    @Column(nullable=false, name = "program_id")
    private Integer programId;

    @NotBlank(message = "Field is mandatory")
    @Column(nullable=false, name = "first_name")
    @Size(max = 45, message = "Value has exceded maximum length of {max} characters")
    private String firstName;

    @Column(nullable=true, name = "second_name")
    @Size(max = 45, message = "Value has exceded maximum length of {max} characters")
    private String secondName;

    @NotBlank(message = "Field is mandatory")
    @Column(nullable=false, name = "first_lastname")
    @Size(max = 45, message = "Value has exceded maximum length of {max} characters")
    private String firstLastName;

    @Column(nullable=true, name = "second_lastname")
    @Size(max = 45, message = "Value has exceded maximum length of {max} characters")
    private String secondLastName;

    @Size(max = 191, message = "Value has exceded maximum length of {max} characters")
    @Email(message = "Field has an invalid format")
    @NotBlank(message = "Field is mandatory")
    @Column(name = "email", unique = true)
    private String email;

    @Column(nullable=true, name = "email_verified_at")
    private Date emailVerifiedAt;

    @Column(name = "password")
    private String password;

    @NotNull(message = "Field is mandatory")
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
