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

import it.sirziphonprojects.UnitTest;
import it.sirziphonprojects.dbconnection.entities.Users;
import it.sirziphonprojects.dbconnection.utils.HibernateUtil;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

/**
 *
 * @author SirZiphon <https://github.com/sirziphon>
 * @version 1.0.0
 */
@Category(UnitTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsersModelTest {

    private final UsersModel usersModel;
    private final Users userTest1;
    private final Users userTest2;
    
    public UsersModelTest() { 
        this.usersModel = UsersModel.getModel();
        this.userTest1 = new Users("test1", "test1pass", "test1@test1.test1");
        this.userTest2 = new Users("test2", "test2pass", "test2@test2.test2");
    }
    
    @AfterClass
    public static void end() {
        HibernateUtil.shutdown();
    }
    
    /**
     * Test of getModel method, of class UsersModel.
     */
    @Test
    public void a_testGetModel() {
        System.out.println("getModel");
        assertTrue(this.usersModel instanceof UsersModel);
    }

    /**
     * Test of getList method, of class UsersModel.
     */
    @Test
    public void d_testGetList() {
        System.out.println("getList");
        
        List<Users> list = this.usersModel.getList();
        
        assertTrue(list != null);
        assertTrue(list.size() >= 1);
    }

    /**
     * Test of getElement method, of class UsersModel.
     */
    @Test
    public void c_testGetElement() {
        System.out.println("getElement");

        Users foundElement = this.usersModel.getElement(this.userTest1.getUsername());

        if (foundElement != null) {
            assertTrue(this.userTest1.getUsername().equals(foundElement.getUsername()));
            assertTrue(this.userTest1.getPassword().equals(foundElement.getPassword()));
            assertTrue(this.userTest1.getEmail().equals(foundElement.getEmail()));
        } else {
            Assert.fail("no element found!");
        }
    }

    /**
     * Test of insertElement method, of class UsersModel.
     */
    @Test
    public void b_testInsertElement() {
        System.out.println("insertElement");

        boolean result1 = this.usersModel.insertElement(this.userTest1);
        boolean result2 = this.usersModel.insertElement(this.userTest2);

        assertTrue(result1);
        assertTrue(result2);
    }

    /**
     * Test of deleteElement method, of class UsersModel.
     */
    @Test
    public void e_testDeleteElement_Users() {
        System.out.println("deleteElement");
        
        assertTrue(this.usersModel.deleteElement(this.userTest1.getUsername()));
    }

    /**
     * Test of deleteElement method, of class UsersModel.
     */
    @Test
    public void f_testDeleteElement_String() {
        System.out.println("deleteElement");
        
        assertTrue(this.usersModel.deleteElement(this.userTest2));
    }

}
