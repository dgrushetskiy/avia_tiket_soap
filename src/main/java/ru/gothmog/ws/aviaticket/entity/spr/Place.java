package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;
import ru.gothmog.ws.aviaticket.entity.Reservation;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Place")
@Table(name = "spr_place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id", nullable = false, unique = true)
    private Long placeId;
    @Column(name = "seat_letter", length = 1)
    private char seatLetter;
    @Column(name = "seat_number")
    private Integer seatNumber;
    @ManyToOne
    @JoinColumn(name = "flightClassId", foreignKey = @ForeignKey(name = "fk_spr_place_spr_flight_class"))
    private FlightClass flightClass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservationSet = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "spr_aircraft_place", joinColumns = @JoinColumn(name = "place_id"), inverseJoinColumns = @JoinColumn(name = "aircraft_id"))
    private List<Aircraft> aircraftList = new ArrayList<>();

    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
        aircraft.getPlaces().add(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircraftList.remove(aircraft);
        aircraft.getPlaces().remove(this);
    }
}
