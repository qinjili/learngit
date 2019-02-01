package cn.smbms.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.Log;

@Controller
@RequestMapping("/pro")
public class ProviderController {
	@Resource
	private ProviderService service;
	//查询所有供应商
	@RequestMapping(value="/providerList.html")
	public String getProviderList(Model model,
				  @RequestParam(value="proName",required=false)String proName){
		List<Provider> proList = null;
		proList = service.getProviderList(proName);
		model.addAttribute("proList", proList);
		return "providerList";
	}
	//添加供应商
	@RequestMapping(value="/providerAdd.html",method=RequestMethod.GET)
	public String providerAdd(@ModelAttribute("pro")Provider pro){
		return "providerAdd";
	}
	@RequestMapping(value="/addsave.html",method=RequestMethod.POST)
	public String addUserSave(Provider pro,HttpSession session) throws ParseException{
		pro.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
		pro.setCreationDate(new Date());
		if(service.addProviderSave(pro)){
			return "redirect:/pro/providerList.html";
		}
		return "providerAdd";
	}
}
