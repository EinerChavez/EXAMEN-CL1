package pe.edu.i202222698.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202222698.entity.Country;
import pe.edu.i202222698.entity.City;
import pe.edu.i202222698.entity.CountryLanguage;
import pe.edu.i202222698.entity.CountryLanguageId;


import java.util.HashSet;
import java.util.Set;

public class JPAPersist {

    public static void main(String[] args) {
        // Crear EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {

            Country country = new Country("PI", "Imagine",
                    "2", "Imaginario", 1000000.0,
                    2000, 5000000, 80.0, 50000.0,
                    48000.0, "Imaginaria",
                    "República", "Juan Pérez",
                    1, "IM"
                    , new HashSet<>(), new HashSet<>());

            City city1 = new City(null, "CiudadUno", country, "Distrito1", 1000000);
            City city2 = new City(null, "CiudadDos", country, "Distrito2", 2000000);
            City city3 = new City(null, "CiudadTres", country, "Distrito3", 1500000);

            Set<City> cities = new HashSet<>();
            cities.add(city1);
            cities.add(city2);
            cities.add(city3);
            country.setCities(cities);

            CountryLanguageId countryLanguageId1 = new CountryLanguageId();
            countryLanguageId1.setCountryCode(country.getCode());
            countryLanguageId1.setLanguage("Imaginario");
            CountryLanguage countryLanguage1 = new CountryLanguage(countryLanguageId1, country, "F", 90.0);

            CountryLanguageId countryLanguageId2 = new CountryLanguageId();
            countryLanguageId2.setCountryCode(country.getCode());
            countryLanguageId2.setLanguage("Imaginario2");
            CountryLanguage countryLanguage2 = new CountryLanguage(countryLanguageId2, country, "F", 80.0);

            Set<CountryLanguage> countryLanguages = new HashSet<>();
            countryLanguages.add(countryLanguage1);
            countryLanguages.add(countryLanguage2);
            country.setCountryLanguages(countryLanguages);

            em.persist(country);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
