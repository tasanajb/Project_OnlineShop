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
public class ShopcartTable {
    public static Vector<Shopcart> findAllShopcart(EntityManager em) {
        Vector<Shopcart> ShopcartList = null;
        try {
            ShopcartList = (Vector<Shopcart>) em.createNamedQuery("Shopcart.findAll").getResultList();
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return ShopcartList;
    }

    public static Shopcart findShopcartByName(EntityManager em, String dvdname) {
        Shopcart sc = null;
        try {
            sc = em.find(Shopcart.class, dvdname);
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return sc;
    }

    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateShopcart(EntityManager em, Shopcart sc) {
        try {
            em.getTransaction().begin();
            Shopcart target = em.find(Shopcart.class, sc.getDvdname());
            if (target == null) {
                return 0;
            }
            target.setQuantity(sc.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;

    }

    public static int removeShopcart(EntityManager em, String dvdname) {
        try {
            em.getTransaction().begin();
            Shopcart target = em.find(Shopcart.class, dvdname);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }

    public static int insertShopcart(EntityManager em, Shopcart sc) {
        try {
            em.getTransaction().begin();
            Shopcart target = em.find(Shopcart.class, sc.getDvdname());
            if (target != null) {
                return 0;
            }
            em.persist(sc);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }
}
