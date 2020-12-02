package com.jcuesoft.cuebridge.common.module;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CommonJPA extends BaseModule{
    
    /*protected static Logger logger = LoggerFactory.getLogger(CommonJPA.class);*/
    /*final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());*/
    
    public CommonJPA(){
        logger.debug("CommonJPAUtil.logger:" + logger.getName());
    }
    
    public static EntityManagerFactory getentityManagerFactory() throws Exception{
        logger.debug("Call CommonJPAUtil getentityManagerFactory...");
        EntityManagerFactory emf;
        
        if ("Y".equals(CommonSessionUtil.getCdCompany())) {
            emf = Persistence.createEntityManagerFactory("bridge_youi");
            logger.debug("getentityManagerFactory get Y");
        } else if ("S".equals(CommonSessionUtil.getCdCompany())) {
            emf = Persistence.createEntityManagerFactory("bridge_star");
            logger.debug("getentityManagerFactory get S");
        }else if ("M".equals(CommonSessionUtil.getCdCompany())) {
            emf = Persistence.createEntityManagerFactory("bridge_mill");
            logger.debug("getentityManagerFactory get M");
        } else {
            logger.error("<ERROR> ! CommonJPAUtil EntityManagerFactory : can not find any domain");
            throw new Exception("EntityManagerFactory : can not find any domain");
        }
        
        return emf;
    }

}
