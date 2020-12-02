package com.jcuesoft.cuebridge.common.module;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class CommonJPAUtil extends BaseModule{

    public EntityManager getEm()  throws Exception{
        return CommonJPA.getentityManagerFactory().createEntityManager();
    }    
    
    public void doTX(EntityManager em, Runnable code) throws Exception{
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();        
        try{
            code.run();
        }catch (RuntimeException re){
            doRE(tx, re);
        }catch (Exception e){
            doE(tx, e);
        }
        tx.commit();
    }
    
    public void doRE(EntityTransaction tx, RuntimeException re) throws Exception{
        logger.debug("Call CommonJPAUtil doRE...");
        logger.debug(Arrays.toString(re.getStackTrace()).replaceAll(", ", "\n"));
        if (tx.isActive ())
            tx.rollback ();   // Alternative: Fix error and retry.
    }
    
    public void doE(EntityTransaction tx, Exception e) throws Exception{
        logger.debug("Call CommonJPAUtil doE...");
        logger.debug(Arrays.toString(e.getStackTrace()).replaceAll(", ", "\n"));
        if (tx.isActive ())
            tx.rollback ();   // Alternative: Fix error and retry.
    }    

    public Object selectOneQuery(Query q) throws Exception{
        Object result = null;
        try {            
            result = q.getSingleResult();
        } catch (NoResultException e) {
            result = null;
            logger.debug("Call CommonJPAUtil selectOneQuery NoResultException :" + q.toString());
        }
        return result;
    }
    
    public int insertQuery(Query q) throws Exception{
        int count = 0;
        count = q.executeUpdate();
        if (count > 0) {
            logger.debug(count + ": insertCount record!");
        }else{
            logger.debug("<Notice> 0 insertCount record!");
        }
        
        return count;
    }    
    
    public int updateQuery(Query q) throws Exception{
        int count = 0;
        count = q.executeUpdate();
        if (count > 0) {
            logger.debug(count + ": updateCount record!");
        }else{
            logger.debug("<Notice> 0 updateCount record!");
        }
        
        return count;        
    }
    
    public int deleteQuery(Query q) throws Exception{
        int count = 0;
        count = q.executeUpdate();
        if (count > 0) {
            logger.debug(count + ": deleteCount record!");
        }else{
            logger.debug("<Notice> 0 deleteCount record!");
        }
        
        return count;        
    }    
}


