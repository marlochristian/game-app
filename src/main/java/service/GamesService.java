package service;

import entity.Games;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class GamesService {
    @PersistenceContext(unitName = "gamesPersistenceUnit")

    private EntityManager manager;

    public List<Games> getAll() {
        return manager.createNamedQuery("findAllGames", Games.class).getResultList();
    }

    public Games findById(long id) {
        return manager.find(Games.class, id);
    }

    @Transactional
    public void update(Games games){
        manager.getTransaction().begin();
        manager.merge(games);
        manager.getTransaction().commit();
    }

    @Transactional
    public void create(Games games){
        manager.getTransaction().begin();
        manager.persist(games);
        manager.getTransaction().commit();
    }

    @Transactional
    public void delete(Games games){
        manager.getTransaction().begin();
        if(!manager.contains(games)){
            games = manager.merge(games);
        }
        manager.remove(games);
        manager.getTransaction().commit();
    }
}
