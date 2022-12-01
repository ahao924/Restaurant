package com.project.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

/**
 * 
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class BusinessAdminMenu extends Model<BusinessAdminMenu>{
	
	private static final long serialVersionUID = 1L;
	public final static BusinessAdminMenu dao = new BusinessAdminMenu();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：176-6401-7800
	 * 技术QQ：2511251392
	 */
	public static List<BusinessAdminMenu> getMenus(Object business_admin_id) {
		
		return BusinessAdminMenu.dao.find("select bm.* from db_business_admin_menu bam left join db_business_menu bm on bam.business_menu_id=bm.id where bam.business_admin_id=? order by bm.idx asc", business_admin_id);
	}
	
}
