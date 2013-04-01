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
package org.jabox.scm.gitlab;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.jabox.model.Server;

public class GitlabConnectorEditor extends Panel {
    private static final long serialVersionUID = -4137475647749541936L;

    public GitlabConnectorEditor(final String id,
            final IModel<Server> model) {
        super(id, new CompoundPropertyModel<Server>(model));
        TextField<String> username = new TextField<String>("username");
        PasswordTextField password = new PasswordTextField("password");
        TextField<String> url = new TextField<String>("server.url");

        add(username.setRequired(true));
        add(password.setRequired(true));

        add(url.add(new GitlabLoginValidator(username, password))
            .setRequired(true));
    }
}