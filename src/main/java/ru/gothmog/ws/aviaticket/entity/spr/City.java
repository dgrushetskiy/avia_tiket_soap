package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;
import ru.gothmog.ws.aviaticket.entity.Flight;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spr_city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false, unique = true)
    private Long cityId;
    @Column(name = "name", length = 200)
    private String cityName;
    @ManyToOne(optional=false)
    @JoinColumn(name = "countryId", foreignKey = @ForeignKey(name = "fk_spr_city_spr_country"))
    private Country country;
    @Column(name = "descrip", length = 200)
    private String descriptionCity;
    @Column(name = "code", length = 45)
    private String codeCity;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityFrom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flight> flightSetFrom = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flight> flightSetTo = new HashSet<>();
}
