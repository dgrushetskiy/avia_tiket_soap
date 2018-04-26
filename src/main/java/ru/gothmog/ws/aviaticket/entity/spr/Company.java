package ru.gothmog.ws.aviaticket.entity.spr;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spr_company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false, unique = true)
    private Long companyId;
    @Column(name = "name", length = 200)
    private String companyName;
    @Column(name = "descrip", length = 200)
    private String descriptionCompany;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Aircraft> aircraftSet = new HashSet<>();
}
