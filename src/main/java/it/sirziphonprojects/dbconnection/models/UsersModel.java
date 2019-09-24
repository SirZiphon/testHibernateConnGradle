/*
 * The MIT License
 *
 * Copyright 2019 SirZiphon <https://github.com/sirziphon>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package it.sirziphonprojects.dbconnection.models;

import it.sirziphonprojects.dbconnection.entities.Users;
import it.sirziphonprojects.dbconnection.entities.Users_;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * Model class of the entity Users; this class provides all methods to manage the 
 * entity with the database (INSERT, SELECT, DELETE)
 * 
 * @author SirZiphon {@literal <https://github.com/sirziphon>}
 * @version 1.0.1
 */
public class UsersModel extends BaseModel<Users, String> {

    private static UsersModel singleton = null;

    private UsersModel() {
        super();
    }

    /**
     * funtion that return the UsersModel singleton instance; if no instance is
     * present, a new one is created
     *
     * @return the UsersModel instance
     */
    public static UsersModel getModel() {
        // check if the singleton is already istantiated
        if (UsersModel.singleton == null) {
            UsersModel.singleton = new UsersModel();
        }

        // return the singleton instance
        return UsersModel.singleton;
    }

    @Override
    public List<Users> getList() {
        List<Users> list = null;

        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            CriteriaQuery<Users> criteria = session.getCriteriaBuilder().createQuery(Users.class);
            criteria.from(Users.class);
            list = session.createQuery(criteria).getResultList();
            
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return list;
    }

    @Override
    public Users getElement(String key) {
        Users element = null;

        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            // create criteria Builder
            CriteriaBuilder builder = session.getCriteriaBuilder();
            
            CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
            
            Root<Users> root = criteria.from(Users.class);
            
            criteria.select(root);
            
            criteria.where(builder.equal(root.get(Users_.username), key));
            
            List<Users> findedUsers = session.createQuery(criteria).getResultList();
            
            // check the result
            switch (findedUsers.size()) {
                case 0:
                    // no element found
                    break;
                    
                case 1: 
                    // element found
                    element = findedUsers.get(0);
                    break;
                    
                default: 
                    // more then one element found: WARNING! this case must be impossible because the passed parameter is a primary key
                    element = findedUsers.get(0);
                    System.err.println("WARNING: the method getElement of the Class UsersModel has found more then one tuple with the passed key: " + key);
            }
            
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return element;
    }

    @Override
    public boolean insertElement(Users element) {
        // check if the parameter is null
        if (element == null) 
            return false;   // no parameter; insertion failed
        
        // executing the db save procedure
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
        // save successful
        return true;
    }

    @Override
    public boolean deleteElement(Users element) {
        // check if the parameter is null
        if (element == null) 
            return false;   // no parameter; deletion failed
        
        // executing the db deletion procedure
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
        // deletion successful
        return true;
    }

    @Override
    public boolean deleteElement(String key) {
        Users userKey;
        
        // check if the key is empty
        if (key == null || key.equals("")) 
            return false;   // no key; deletion failed
        else 
            userKey = this.getElement(key);
        
        // check if the user exist 
        if (userKey == null)
            return false; // no user; deletion failed
        
        // executing the db deletion procedure
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(userKey);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
        // deletion successful
        return true;
    }
}
