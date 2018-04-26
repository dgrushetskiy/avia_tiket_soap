package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spr_flight_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FlightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classes_id", nullable = false, unique = true)
    private Long flightClassId;
    @Column(name = "name", length = 200)
    private String flightClassName;
    @Column(name = "descrip", length = 100)
    private String descriptionFlightClass;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flightClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Place> placeSet = new HashSet<>();
}
