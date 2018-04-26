package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spr_country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, unique = true)
    private Long countryId;
    @Column(name = "name", length = 200)
    private String countryName;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "flag")
    private byte[] flag;
    @Column(name = "descrip", length = 200)
    private String descriptionCountry;
    @Column(name = "code", length = 45)
    private String countryCode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<City> citySet = new HashSet<>();
}
