/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandre.kaamelottmemes.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alexandre
 */

@Entity
public class Meme
{
    // ------------------------- Attributes ------------------------------------
    
    @Id
    private String id;
    
    private List<String> tags;
    
    // ------------------------ Constructors -----------------------------------

    public Meme() {
    }

    public Meme(String link, List<String> tags) {
        this.id = link;
        this.tags = tags;
    }
    
    // -------------------------- Getters --------------------------------------

    public String getLink() {
        return id;
    }

    public List<String> getTags() {
        return tags;
    }
    
    // -------------------------- Setters --------------------------------------

    public void setId(String id) {
        this.id = id;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    // ----------------------- Other methods -----------------------------------

    @Override
    public String toString() {
        return "Meme{" + "link=" + id + ", tags=" + tags + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.tags);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Meme other = (Meme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
