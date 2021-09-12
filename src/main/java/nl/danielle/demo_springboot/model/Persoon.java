package nl.danielle.demo_springboot.model;

import javax.persistence.*;

@Entity(name = "person")
public class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nr")
    public long id; // primary key

    @Column(name = "first_name")
    public String voornaam;
    @Column(name = "last_name")
    public String achternaam;
    @Column(name = "city")
    public String woonplaats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
