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
import javax.persistence.Query;
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
    public TopicEntity retrieveTopicByIndex(Long index) {
        Query query = em.createQuery("SELECT t FROM TopicEntity t WHERE t.headerIndex = :index");
        query.setParameter("index", index);
        List resultList = query.getResultList();
        if (resultList.size() == 0) return null;
        return (TopicEntity) resultList.get(0);
    }

    @Override
    public void createTopic(TopicEntity topicEntity) {
        em.persist(topicEntity);
    }

    @Override
    public void createTopic(String text, String content, Long index) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTopicHeader(text);
        topicEntity.setTopicContent(content);
        topicEntity.setHeaderIndex(index);
        em.persist(topicEntity);
    }

    @Override
    public void updateTopic(TopicEntity topicEntity) {
        em.merge(topicEntity);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
