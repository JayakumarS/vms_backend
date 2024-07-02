package com.vms.supplies.identifiersLibrary;

import java.util.List;


public class IdentifiersLibraryBean {
	
	private Integer code;
	private Integer codemax;
	private Integer storageId;
	private String code1;
	private String code2;
	private Integer functionId;
	private Integer itemId;
	private Integer scale;
	private Integer locationId;
	
	

	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public Integer getStorageId() {
		return storageId;
	}
	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}
	public Integer getCodemax() {
		return codemax;
	}
	public void setCodemax(Integer codemax) {
		this.codemax = codemax;
	}
	private List<IdentifiersLibraryBean> identifiertable;
	private List<IdentifiersLibraryBean> identifiertable1;
	private List<IdentifiersLibraryBean> identifiertable2;

	
	public List<IdentifiersLibraryBean> getIdentifiertable2() {
		return identifiertable2;
	}
	public void setIdentifiertable2(List<IdentifiersLibraryBean> identifiertable2) {
		this.identifiertable2 = identifiertable2;
	}
	public List<IdentifiersLibraryBean> getIdentifiertable1() {
		return identifiertable1;
	}
	public void setIdentifiertable1(List<IdentifiersLibraryBean> identifiertable1) {
		this.identifiertable1 = identifiertable1;
	}
	public List<IdentifiersLibraryBean> getIdentifiertable() {
		return identifiertable;
	}
	public void setIdentifiertable(List<IdentifiersLibraryBean> identifiertable) {
		this.identifiertable = identifiertable;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	

}
