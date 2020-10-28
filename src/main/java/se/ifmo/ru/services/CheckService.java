package se.ifmo.ru.services;

import org.springframework.stereotype.Service;

@Service
public class CheckService {
    public boolean check(double x, double y, double r){
        if(x<=0 && y>=0){
            return y<=r && x>=-r;
        }else if(x<=0 && y<=0){
            return -y <= 2 * x + r/2;
        }else if(x>=0 && y<=0){
            return x * x + y * y <= r * r;
        }else if(y>0 && x>0){
            return false;
        }else return false;
    }
}
