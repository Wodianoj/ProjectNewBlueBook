package com.example.sm.nbb.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.DETACH;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPLICATIONS")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPLICATION_ID", nullable = false)
    private Integer id;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE", nullable = true)
    private String phone;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "SUBMISSION_DATE", nullable = false)
    private LocalDateTime submissionDate;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "PASSWORD", nullable = false)
    private byte[] password;

    @Type(type = "text")
    @Column(name = "NOTE", nullable = true)
    private String note;

    @Column(name = "RESOLUTION_DATE", nullable = true)
    private LocalDateTime resolutionDate;

    @Column(name = "RESOLVED_POSITIVELY", nullable = true, columnDefinition = "TINYINT(1)")
    private Boolean resolvedPositively;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "NEW_USER_ID", referencedColumnName = "USER_ID")
    private User newUser;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "RESOLVED_BY", referencedColumnName = "USER_ID")
    private User resolvedBy;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "APPLIED_ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role appliedRole;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "APPLIED_ACCESS_ID", referencedColumnName = "ACCESS_ID")
    private Access appliedAccess;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "GRANTED_ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role grantedRole;

    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "GRANTED_ACCESS_ID", referencedColumnName = "ACCESS_ID")
    private Access grantedAccess;
}
