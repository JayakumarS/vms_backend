package com.vms.userRights;

public class UserRightsPropertyListBean {
	private Long formPropertyId;
	
	public Long getFormPropertyId() {
		return formPropertyId;
	}
	public void setFormPropertyId(Long formPropertyId) {
		this.formPropertyId = formPropertyId;
	}
		
	
	 //Mobile User Rigts

		private String userId;
		private String form_code;
		private String form_name;
		private String form_code_parent;
		private String form_url;

		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getForm_code() {
			return form_code;
		}
		public void setForm_code(String form_code) {
			this.form_code = form_code;
		}
		public String getForm_name() {
			return form_name;
		}
		public void setForm_name(String form_name) {
			this.form_name = form_name;
		}
		public String getForm_code_parent() {
			return form_code_parent;
		}
		public void setForm_code_parent(String form_code_parent) {
			this.form_code_parent = form_code_parent;
		}
		public String getForm_url() {
			return form_url;
		}
		public void setForm_url(String form_url) {
			this.form_url = form_url;
		}
	

}
