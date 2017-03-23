package kayttaytyminen;

import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class PaaLuokka {
    //Main metodissa luomme muista luokista Behavior olioita jotka sijoitamme
    //sitten Behavior taulukkoon. Kun annamme taulukon sitten Arbitratorin
    //käsiteltäväksi, se looppaa taulukon olioita ja siten niiden metodeja
    //loputtomiin kunnes robotin virta katkaistaan.
    public static void main(String[] args) {
        //int arvo; //vaihtoehtoisessa do-while ehdossa hyödynnettävä muuttuja
        Behavior osa1 = new AjaEteenpain();
        Behavior osa2 = new HuomaaSeina(SensorPort.S1);
        Behavior [] taulu = {osa1, osa2};
        Arbitrator arby = new Arbitrator(taulu);
        //do { //do-while ehto, tee arby.start() 10 kertaa, ei takuita toimivuudesta
        arby.start(); //käynnistää Arbitratorin ja looppaa sen toimintaa aina.
        //arvo++;
        //} while (arvo > 11);
    }
    
}
