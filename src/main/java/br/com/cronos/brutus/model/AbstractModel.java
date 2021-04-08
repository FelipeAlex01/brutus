package br.com.cronos.brutus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int UNIT_VALUE_FRACTION = 4;

	public static final int DOUBLE_UNIT_VALUE_FRACTION = 2;

	@Column(name = "data_cadastro")
	private Date insertDate;

	@Column(name = "data_alteracao")
	private Date updateDate;

	public abstract Long getId();

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@PrePersist
	private void persist() {
		this.setInsertDate(new Date());
	}

	@PreUpdate
	private void update() {
		this.setUpdateDate(new Date());
	}

}
