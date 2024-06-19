package com.vms.crew.certificates;

public interface CertificatesService {
	public CertificatesResultBean save(CertificatesBean bean);

	public CertificatesResultBean getList();

	public CertificatesResultBean edit(String id);

	public CertificatesResultBean delete(String id);

	public CertificatesResultBean update(CertificatesBean bean);
}
