package ru.gothmog.ws.aviaticket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false, unique = true)
    private Long passengerId;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "family_name")
    private String familyName;
    @Column(name = "document_number", length = 100)
    private String documentNumber;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "phone", length = 45)
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservationSet = new HashSet<>();
}
