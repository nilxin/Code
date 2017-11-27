package com.cdsf.configure;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel extends AbstractBaseAll {

	public abstract String toString();

	private Integer ownUser;
	private Integer ownDept;
	private Integer ownArea;
	private List<String> operates = new ArrayList<String>();

	public Integer getOwnUser() {
		return ownUser;
	}

	public void setOwnUser(Integer ownUser) {
		this.ownUser = ownUser;
	}

	public Integer getOwnDept() {
		return ownDept;
	}

	public void setOwnDept(Integer ownDept) {
		this.ownDept = ownDept;
	}

	public Integer getOwnArea() {
		return ownArea;
	}

	public void setOwnArea(Integer ownArea) {
		this.ownArea = ownArea;
	}

	public List<String> getOperates() {
		return operates;
	}

	public void setOperates(List<String> operates) {
		this.operates = operates;
	}

}
