package com.rishavkdu.flightmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Contact_Details",
        uniqueConstraints = @UniqueConstraint(name="contact_details__unique", columnNames = "phone")
)
public class ContactDetails {

    @Id
    @Column(name = "contact_id")
    @SequenceGenerator(name="contact_sequence", sequenceName = "contact_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence" )
    private Long contactId;

    private String emailId;
    private String phone;

    @Embedded
    private Address address;
}
