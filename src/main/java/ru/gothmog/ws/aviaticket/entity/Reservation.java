package ru.gothmog.ws.aviaticket.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import ru.gothmog.ws.aviaticket.entity.spr.Place;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false, unique = true)
    private Long reservationId;
    @ManyToOne
    @JoinColumn(name = "flightId", foreignKey = @ForeignKey(name = "fk_reservation_flight"))
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "passengerId", foreignKey = @ForeignKey(name = "fk_reservation_passenger"))
    private Passenger passenger;
    @ManyToOne
    @JoinColumn(name = "placeId", foreignKey = @ForeignKey(name = "fk_reservation_spr_place"))
    private Place place;
    @Column(name = "add_info", length = 100)
    private String addInfo;
    @Column(name = "reserve_datetime")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date reserveDateTime;
    @Column(name = "code", length = 45)
    private String codeReservation;
}
