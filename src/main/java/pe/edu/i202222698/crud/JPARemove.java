package pe.edu.i202222698.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202222698.entity.Country;

public class JPARemove {

        public static void main(String[] args) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
            EntityManager em = emf.createEntityManager();

            Country country = em.find(Country.class, "PI");

            if (country != null) {

                em.getTransaction().begin();

                em.remove(country);

                em.getTransaction().commit();

                System.out.println("Eliminación exitosa: " +
                        "El país y sus ciudades y lenguajes han sido eliminados.");

            }

            em.close();
            emf.close();
        }
    }


