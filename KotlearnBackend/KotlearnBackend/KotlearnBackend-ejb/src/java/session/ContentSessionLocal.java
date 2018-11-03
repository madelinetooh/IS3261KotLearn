/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ContentEntity;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author sinhv
 */
@Local
public interface ContentSessionLocal {
    ContentEntity retrieveContentById(Integer id);
    void createContent(ContentEntity contentEntity);
    void updateContent(ContentEntity contentEntity);
}
