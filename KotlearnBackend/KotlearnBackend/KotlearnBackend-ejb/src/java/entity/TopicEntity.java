/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author sinhv
 */
@Entity
public class TopicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long headerIndex;

    private String topicHeader;
    @Lob
    private String topicContent;

    public TopicEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopicEntity)) {
            return false;
        }
        TopicEntity other = (TopicEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TopicEntity[ id=" + id + " ]";
    }

    public String getTopicHeader() {
        return topicHeader;
    }

    public void setTopicHeader(String text) {
        this.topicHeader = text;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String content) {
        this.topicContent = content;
    }

    public Long getHeaderIndex() {
        return headerIndex;
    }

    public void setHeaderIndex(Long index) {
        this.headerIndex = index;
    }
}
