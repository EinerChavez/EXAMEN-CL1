package pe.edu.i202222698.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202222698.entity.City;
import pe.edu.i202222698.entity.Country;

import java.util.Set;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        if (country != null) {
            Set<City> cities = country.getCities();
            cities.stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println("Ciudad peruana con poblacion > 700000  es: " + city.getName()));
        } else {
            System.out.println("No se encontró el país con el código PER.");
        }

        em.close();
        emf.close();
    }
}

