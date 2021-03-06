/*
 * Jabox Open Source Version
 * Copyright (C) 2009-2010 Dimitris Kapanidis                                                                                                                          
 * 
 * This file is part of Jabox
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package org.jabox.model;

import java.io.Serializable;

import org.apache.wicket.persistence.domain.BaseEntity;
import org.mindrot.jbcrypt.BCrypt;

public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 840333278259987092L;

    private String login;

    private String firstName;

    private String lastName;

    private String passwordHash;

    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * Always return empty password, used for Forms.
     * 
     * @return
     */
    public String getPassword() {
        return "";
    }

    /**
     * Hashes the password and stores it to passwordHash
     * 
     * @param password
     *            the password
     */
    public void setPassword(final String password) {
        passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return login;
    }

    /**
     * @return Returns the passwordHash.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash
     *            The passwordHash to set.
     */
    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
