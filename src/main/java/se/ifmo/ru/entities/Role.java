package se.ifmo.ru.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="ROLES")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
    @SequenceGenerator(name="ROLES_SEQ", sequenceName="ROLES_SEQ", allocationSize=1)
    private @Id long id;

    @Column(name = "NAME")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(
                    name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(
                    name = "USER_ID", referencedColumnName = "ID"))
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
