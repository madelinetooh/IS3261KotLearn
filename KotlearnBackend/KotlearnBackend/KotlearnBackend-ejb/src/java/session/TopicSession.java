/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TopicEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author sinhv
 */
@Stateless
public class TopicSession implements TopicSessionLocal {
    @PersistenceContext(unitName = "KotlearnBackend-ejbPU")
    private EntityManager em;

    @Override
    public List<TopicEntity> retrieveAllTopics() {
        return em.createQuery("SELECT t FROM TopicEntity  t").getResultList();
    }

    @Override
    public TopicEntity retrieveTopicById(Integer id) {
        return em.find(TopicEntity.class, id);
    }

    @Override
    public void createTopic(TopicEntity topicEntity) {
        em.persist(topicEntity);
    }

    @Override
    public void updateTopic(TopicEntity topicEntity) {
        em.merge(topicEntity);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
