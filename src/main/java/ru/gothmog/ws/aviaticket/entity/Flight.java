package ru.gothmog.ws.aviaticket.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import ru.gothmog.ws.aviaticket.entity.spr.Aircraft;
import ru.gothmog.ws.aviaticket.entity.spr.City;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false, unique = true)
    private Long flightId;
    @Column(name = "code", nullable = false, length = 100)
    private String code;
    @Column(name = "date_depart")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateDepart;
    @Column(name = "date_come")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateCome;
    @ManyToOne
    @JoinColumn(name = "aircraftId", foreignKey = @ForeignKey(name = "fk_flight_spr_aircraft"))
    private Aircraft aircraft;
    @ManyToOne
    @JoinColumn(name = "cityId", foreignKey = @ForeignKey(name = "fk_flight_spr_from_city"))
    private City cityFrom;
    @ManyToOne
    @JoinColumn(name = "cityId", foreignKey = @ForeignKey(name = "fk_flight_spr_to_city"),insertable=false, updatable=false)
    private City cityTo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservationSet = new HashSet<>();
}
