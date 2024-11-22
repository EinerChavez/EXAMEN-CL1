package pe.edu.i202222698.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country; // Relación con Country

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private Double percentage;

    // Constructor vacío
    public CountryLanguage() {}

    // Constructor con parámetros
    public CountryLanguage(CountryLanguageId id, Country country, String isOfficial, Double percentage) {
        this.id = id;             // CountryLanguageId
        this.country = country;   // Country
        this.isOfficial = isOfficial; // Si el idioma es oficial
        this.percentage = percentage; // Porcentaje de hablantes
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", country=" + country.getCode() +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
    // Getters y Setters
    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }


}
