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
package it.sirziphonprojects.dbconnection.entities;

import it.sirziphonprojects.UnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 *
 * @author SirZiphon <https://github.com/sirziphon>
 * @version 1.0.0
 */
@Category(UnitTest.class)
public class UsersTest {
    
    private final Users user;
    
    public UsersTest() {
        this.user = new Users("User1", "User1Pass", "User1email@mail.ma");
    }
    
    /**
     * Test of getUsername method, of class Users.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        
        Assert.assertEquals("User1", this.user.getUsername());
    }

    /**
     * Test of setUsername method, of class Users.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        
        this.user.setUsername("User2");
        Assert.assertEquals("User2", this.user.getUsername());
    }

    /**
     * Test of getPassword method, of class Users.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        
        Assert.assertEquals("User1Pass", this.user.getPassword());
    }

    /**
     * Test of setPassword method, of class Users.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        
        this.user.setPassword("User2Pass");
        Assert.assertEquals("User2Pass", this.user.getPassword());
    }

    /**
     * Test of getEmail method, of class Users.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        
        Assert.assertEquals("User1email@mail.ma", this.user.getEmail());
    }

    /**
     * Test of setEmail method, of class Users.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        
        this.user.setEmail("User2email@mail.ma");
        Assert.assertEquals("User2email@mail.ma", this.user.getEmail());
    }

    /**
     * Test of toString method, of class Users.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String expResult = "User: (Username: User1, Password: User1Pass, Email: User1email@mail.ma)";
        Assert.assertEquals(expResult, this.user.toString());
    }
    
}
