package com.vms.userRights;

public class PermissionResultBean {
	
	public boolean success;
	public boolean add;
	public boolean modify;
	public boolean delete;
	public boolean search;
	public boolean exportXL;
	public boolean view;
	public boolean print;
	
	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}
	public boolean isPrint() {
		return print;
	}
	public void setPrint(boolean print) {
		this.print = print;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isAdd() {
		return add;
	}
	public void setAdd(boolean add) {
		this.add = add;
	}
	public boolean isModify() {
		return modify;
	}
	public void setModify(boolean modify) {
		this.modify = modify;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public boolean isExportXL() {
		return exportXL;
	}
	public void setExportXL(boolean exportXL) {
		this.exportXL = exportXL;
	}

}
