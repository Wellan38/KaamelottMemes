/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandre.kaamelottmemes.service;

import alexandre.kaamelottmemes.model.*;
import alexandre.kaamelottmemes.dao.*;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Service
{
    public static Boolean createMeme(Meme meme) throws Throwable
    {
        Boolean res = Boolean.TRUE;
        
        if (meme == null)
        {
            res = Boolean.FALSE;
        }
        else if (findMemeByLink(meme.getLink()) != null)
        {
            res = Boolean.FALSE;
        }
        else
        {
            JpaUtil.creerEntityManager();

            JpaUtil.ouvrirTransaction();

            new MemeDao().create(meme);

            JpaUtil.validerTransaction();
        }
        
        JpaUtil.fermerEntityManager();
        
        return res;
    }
    
    public static Meme findMemeByLink(String link) throws Throwable
    {
        JpaUtil.creerEntityManager();
        
        MemeDao dao = new MemeDao();
        
        List<Meme> memes = dao.findAll();
        
        for (Meme m : memes)
        {
            if (m.getLink().equals(link))
            {
                JpaUtil.fermerEntityManager();
                
                return m;
            }
        }
        
        JpaUtil.fermerEntityManager();
        
        return null;
    }
    
    private static Boolean updateMeme(Meme m) throws Throwable
    {
        if (m == null)
        {
            return Boolean.FALSE;
        }
        else
        {
            JpaUtil.creerEntityManager();

            JpaUtil.ouvrirTransaction();
            
            new MemeDao().update(m);
            
            JpaUtil.validerTransaction();
            
            JpaUtil.fermerEntityManager();
            
            return Boolean.TRUE;
        }
    }
    
    public static Boolean removeMeme(Meme m) throws Throwable
    {
        if (m == null)
        {
            return Boolean.FALSE;
        }
        else
        {
            JpaUtil.creerEntityManager();

            JpaUtil.ouvrirTransaction();
            
            new MemeDao().remove(m);
            
            JpaUtil.validerTransaction();
            
            JpaUtil.fermerEntityManager();
            
            return Boolean.TRUE;
        }
    }
}
