package pl.jacekrg.AlpineGuesthouse.domain.guest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class GuestRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createNewGuest(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        Guest newOne = new Guest(firstName, lastName, dateOfBirth, gender);
        entityManager.persist(newOne);
    }

    @Transactional
    public void removeById(long id) {
        this.entityManager.remove(this.getById(id));
    }

    public Guest getById(long id) {
        return this.entityManager.find(Guest.class, id);
    }

    public List<Guest> findAll() {
        return this.entityManager
                .createQuery("SELECT guest FROM Guest guest", Guest.class)
                .getResultList();
    }

    @Transactional
    public Guest update(Guest guest) {
        return this.entityManager.merge(guest);
    }
}