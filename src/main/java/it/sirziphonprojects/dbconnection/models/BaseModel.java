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

import it.sirziphonprojects.dbconnection.entities.BaseEntity;
import it.sirziphonprojects.dbconnection.utils.HibernateUtil;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * This class will be used as base for the implementation of all entities models
 * class
 * 
 * @author SirZiphon {@literal <https://github.com/sirziphon>}
 * @version 1.0.1
 * @param <T> the Entity class
 * @param <K> the type of the entity class primary key
 */
public abstract class BaseModel<T extends BaseEntity, K> {
    
    protected final SessionFactory sessionFactory;
    
    protected BaseModel() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    /**
     * this method return the current list of entities
     * 
     * @return List of T entities
     */
    abstract public List<T> getList();
            
    /**
     * this method return the searched element; if no element match the passed 
     * key, <code>null</code> will be return
     * 
     * @param key the param to search the element 
     * @return the element searched or <code>null</code>
     */
    abstract public T getElement(K key);
    
    /**
     * this method insert the passed element into the db; return <code>true</code>
     * if the element is successfully inserted, <code>false</code> otherwise
     * 
     * @param element the element to insert
     * @return <code>true</code> for successfully insetion, <code>false</code> otherwise
     */
    abstract public boolean insertElement(T element);
    
    /**
     * this method delete the passed element from the db; return <code>true</code>
     * if the element is successfully deleted, <code>false</code> otherwise
     * 
     * @param element the element to delete
     * @return <code>true</code> for successfully deletion, <code>false</code> otherwise
     */
    abstract public boolean deleteElement(T element);
    
    /**
     * variation of the deleteElement(T element), in this case the element is delete
     * using only the primary key
     * 
     * @param key the primary key of the element to delete
     * @return  <code>true</code> for successfully deletion, <code>false</code> otherwise
     */
    abstract public boolean deleteElement(K key);
}
