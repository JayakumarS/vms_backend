package com.vms.crew.certificates;

import java.util.List;

public interface CertificatesService {
	public CertificatesResultBean save(CertificatesBean bean);

	public CertificatesResultBean getList();

	public CertificatesResultBean edit(Integer id);

	public CertificatesResultBean delete(Integer id);

	public CertificatesResultBean update(CertificatesBean bean);
	
    CertificatesBean getSequenceCode();

}
