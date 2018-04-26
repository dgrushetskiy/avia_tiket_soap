package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;
import ru.gothmog.ws.aviaticket.entity.Flight;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "spr_aircraft")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id", nullable = false, unique = true)
    private Long aircraftId;
    @Column(name = "name", length = 200)
    private String aircraftName;
    @ManyToOne
    @JoinColumn(name = "companyId", foreignKey = @ForeignKey(name = "fk_spr_aircraft_spr_company"))
    private Company company;
    @Column(name = "descrip", length = 200)
    private String descriptionAircraft;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flight> flightSet = new HashSet<>();
    @ManyToMany(mappedBy = "aircraftList")
    private List<Place> places = new ArrayList<>();
}
