package se.ifmo.ru.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "LAB4_HITS")
public class Entry {
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAB4_HITS_SEQ")
    @SequenceGenerator(name="LAB4_HITS_SEQ", sequenceName="LAB4_HITS_SEQ", allocationSize=1)
    private @Id long id;

    @Column(name = "X")
    private double x;

    @Column(name = "Y")
    private double y;

    @Column(name = "R")
    private double r;

    @Column(name = "RESULT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean result;

    @Column(name = "USER_ID")
    private long userID;

    public Entry(double x, double y, double r, boolean result, long clientID) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.userID = userID;
    }
}
