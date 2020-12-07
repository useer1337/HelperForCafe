package com.koval.HelperForCafe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ROLE")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SEQ_ROLE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<Person> personList;

    @Override
    public String getAuthority() {
        return getName();
    }

}
