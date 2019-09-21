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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * This class represent the table <code>users</code> of the database
 * 
 * @author SirZiphon <https://github.com/sirziphon>
 * @version 1.0.0
 */
@Entity
@Table(name="users")
public class Users implements BaseEntity {
   
    @Id
    @Column(name = "username", unique = true, nullable = false, length = 10)
    private String username;

    @Column(name = "password", unique = false, nullable = false, length = 250)
    private String password;
    
    @Column(name = "email", unique = false, nullable = false, length = 50)
    private String email;
    
    /**
     * constructor
     */
    public Users() { 
        this.username = null;
        this.password = null;
        this.email = null;
    }
    
    /**
     * Constructor with params
     * 
     * @param username
     * @param password
     * @param email 
     */
    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // getters and setters
    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "User: (Username: " + this.username + ", Password: " + this.password + ", Email: " + this.email + ")";
    }    
}
