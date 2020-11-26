/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author tasanajb
 */
public class DvdTable {
    public static Vector<Dvd> findAllDvd(EntityManager em) {
        Vector<Dvd> dvdList = null;
        try {
            dvdList = (Vector<Dvd>) em.createNamedQuery("Dvd.findAll").getResultList();
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvdList;
    }

    public static Dvd findDvdByName(EntityManager em, String dvdname) {
        Dvd dvd = null;
        try {
            dvd = em.find(Dvd.class, dvdname);
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvd;
    }

    public static int insertDvd(EntityManager em, Dvd dvd) {
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, dvd.getDvdname());
            if (target != null) {
                return 0;
            }
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }
}
