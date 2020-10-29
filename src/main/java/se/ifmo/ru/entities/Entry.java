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

    public Entry(double x, double y, double r, long userID) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.userID = userID;
        check();
    }

    public void check(){
        if(x<=0 && y>=0){
            result =  y<=r && x>=-r;
        }else if(x<=0 && y<=0){
            result = -y <= 2 * x + r/2;
        }else if(x>=0 && y<=0){
            result = x * x + y * y <= r * r;
        }else if(y>0 && x>0){
            result = false;
        }else result = false;
    }
}
