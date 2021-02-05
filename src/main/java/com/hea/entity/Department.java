package com.hea.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {

	@Id
	private String idDept;

	private String departmentName;

	private String location;

	public String getIdDept() {
		return idDept;
	}

	public void setIdDept(String idDept) {
		this.idDept = idDept;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
