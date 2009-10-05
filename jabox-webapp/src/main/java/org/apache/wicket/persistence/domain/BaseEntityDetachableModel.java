package org.apache.wicket.persistence.domain;

import org.apache.wicket.injection.web.InjectorHolder;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.persistence.provider.GeneralDao;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class BaseEntityDetachableModel<E extends BaseEntity> extends
		LoadableDetachableModel<E> {
	private static final long serialVersionUID = 501303796886245828L;

	@SpringBean(name = "GeneralDao")
	protected GeneralDao generalDao;

	private Long id;
	private Class<E> clazz;

	public BaseEntityDetachableModel() {
		InjectorHolder.getInjector().inject(this);
	}

	public BaseEntityDetachableModel(E baseEntity) {
		this();
		this.id = baseEntity.getId();
		this.clazz = (Class<E>) baseEntity.getClass();

	}

	public void setBaseEntityDetachableModel(BaseEntity baseEntity) {
		this.id = baseEntity.getId();
		this.clazz = (Class<E>) baseEntity.getClass();
	}

	@Override
	protected E load() {
		if (clazz != null) {

			return generalDao.findEntity(id, clazz);
		} else {
			return null;
		}
	}

}
