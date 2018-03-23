package dao;


import processing.DataBase;
import processing.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class CommentsDAO {
    final static Logger logger = Logger.getLogger(DataBase.class);
    public static void addComment(CommentsEntity commentsEntity) throws SQLException{
        logger.info("adding comment (DAO layer)");
        org.hibernate.Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(commentsEntity);
            session.getTransaction().commit();
            logger.info("adding comment (DAO layer) -> Success!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Some text", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Collection getCommentsList(int customerID){
        logger.info("getting comment list (DAO)!");
        Session session = null;
        List comments = new ArrayList<CommentsEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            comments = session.createCriteria(CommentsEntity.class).list();
            Query query = session.createQuery("FROM CommentsEntity as OE WHERE OE.customerId = :customerID");
            query.setParameter("customerID", customerID);
            comments = query.list();
            logger.info("getting comment list (DAO)!_> success!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return comments;
    }
}