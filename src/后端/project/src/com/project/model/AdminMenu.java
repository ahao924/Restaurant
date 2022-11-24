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
public class AdminMenu extends Model<AdminMenu>{
	
	private static final long serialVersionUID = 1L;
	public final static AdminMenu dao = new AdminMenu();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<AdminMenu> getMenus(Object admin_id){
		
		return AdminMenu.dao.find("select m.* from db_admin_menu am left join db_menu m on am.menu_id=m.id where am.admin_id=? order by m.idx asc", admin_id);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static AdminMenu getByAdminMenu(Object admin_id, Object menu_id) {
		
		return AdminMenu.dao.findFirst("select am.* from db_admin_menu am left join db_menu m on am.menu_id=m.id where am.admin_id=? and am.menu_id=?", admin_id, menu_id);
	}
}
