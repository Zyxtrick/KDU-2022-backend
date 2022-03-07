package com.rishavkdu.flightmanagement.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name="user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence" )
    private Long userId;

    @Column(name="user_name")
    private String userName;
    private String emailId;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="contact_id", referencedColumnName = "contact_id")
    private ContactDetails contactDetails;

}
