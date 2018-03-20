package ru.ts.bestteam;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class HibernateUtil {
    public HibernateUtil(){
        try{
            this.sessionFactory=new Configuration().configure().buildSessionFactory();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
    }
    private SessionFactory sessionFactory;

    public  SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
