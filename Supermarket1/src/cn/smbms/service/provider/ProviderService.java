package cn.smbms.service.provider;

import java.util.List;

import cn.smbms.pojo.Provider;

public interface ProviderService {
	/**
	 * 查询所有供应商信息
	 * @param proName
	 * @return
	 */
	public List<Provider> getProviderList(String proName);
	/**
	 * 添加供应商信息
	 * @param pro
	 * @return
	 */
	public boolean addProviderSave(Provider pro);
}
