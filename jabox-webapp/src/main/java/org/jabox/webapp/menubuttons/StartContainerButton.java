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
package org.jabox.webapp.menubuttons;

import org.apache.wicket.Page;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.form.ImageButton;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.persistence.provider.GeneralDao;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jabox.model.Container;

public final class StartContainerButton extends ImageButton {
	private static final ResourceReference START_IMG = new ResourceReference(
			StartContainerButton.class, "edit-delete.png");
	private static final long serialVersionUID = 1L;
	private final Container _item;
	private Class<? extends Page> _responsePage;

	public StartContainerButton(final String id, final Container item,
			final Class<? extends Page> responsePage) {
		super(id, START_IMG);
		_item = item;
		_responsePage = responsePage;
	}

	public StartContainerButton(final String id,
			final ListItem<Container> item,
			final Class<? extends Page> responsePage) {
		this(id, item.getModelObject(), responsePage);
	}

	@SpringBean(name = "GeneralDao")
	protected GeneralDao generalDao;

	/**
	 * Delete from persistent storage, commit transaction.
	 */
	@Override
	public void onSubmit() {
		_item.start();
		setResponsePage(_responsePage);
	}
}