/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ContentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author sinhv
 */
@Stateless
public class ContentSession implements ContentSessionLocal {
    @PersistenceContext(unitName = "KotlearnBackend-ejbPU")
    private EntityManager em;

    @Override
    public ContentEntity retrieveContentById(Integer id) {
        return em.find(ContentEntity.class, id);
    }

    @Override
    public void createContent(ContentEntity contentEntity) {
        em.persist(contentEntity);
    }

    @Override
    public void updateContent(ContentEntity contentEntity) {
        em.merge(contentEntity);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
