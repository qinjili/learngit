package cn.smbms.service.provider;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.provider.ProviderDao;
import cn.smbms.pojo.Provider;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Resource
	private ProviderDao dao;
	@Override
	public List<Provider> getProviderList(String proName) {
		return dao.getProviderList(proName);
	}
	@Override
	public boolean addProviderSave(Provider pro) {
		return dao.addProviderSave(pro);
	}

}
