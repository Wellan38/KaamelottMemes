/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandre.kaamelottmemes.dao;

import alexandre.kaamelottmemes.model.Meme;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Alex-Laptop
 */
public class MemeDao {
    
    public void create(Meme m) throws Throwable
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        
        try
        {
            em.persist(m);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public Meme update(Meme m) throws Throwable {
        EntityManager em = JpaUtil.obtenirEntityManager();
        try {
            m = em.merge(m);
        }
        catch(Exception e){
            throw e;
        }
        return m;
    }
    
    public Meme findById(String id) throws Throwable {
        EntityManager em = JpaUtil.obtenirEntityManager();
        Meme m = null;
        try {
            m = em.find(Meme.class, id);
        }
        catch(Exception e) {
            throw e;
        }
        return m;
    }
    
    public List<Meme> findAll() throws Throwable {
        EntityManager em = JpaUtil.obtenirEntityManager();
        List<Meme> memes = null;
        try {
            Query q = em.createQuery("SELECT m FROM Meme m");
            memes = (List<Meme>) q.getResultList();
        }
        catch(Exception e) {
            throw e;
        }
        
        return memes;
    }
    
    public void remove(Meme m) throws Throwable
    {
        EntityManager em = JpaUtil.obtenirEntityManager();
        
        try
        {
            em.remove(em.find(m.getClass(), m.getLink()));
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
