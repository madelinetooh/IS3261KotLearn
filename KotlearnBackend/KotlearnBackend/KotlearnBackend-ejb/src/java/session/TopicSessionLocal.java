/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TopicEntity;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author sinhv
 */
@Local
public interface TopicSessionLocal {
    List<TopicEntity> retrieveAllTopics();
    TopicEntity retrieveTopicByIndex(Long index);
    void createTopic(TopicEntity topicEntity);
    void createTopic(String text, String content, Long index);
    void updateTopic(TopicEntity topicEntity);
}
