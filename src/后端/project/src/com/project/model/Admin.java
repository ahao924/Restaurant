package com.project.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class Admin extends Model<Admin> {

	private static final long serialVersionUID = 1L;
	public static final Admin dao = new Admin();
	
	public final static int TYPE_1 = 1;//ROOT
	public final static int TYPE_2 = 2;//管理员添加
    
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static Admin getByAccountMd5Pwd(String account, String password) {

		return Admin.dao.findFirst("select * from db_admin where account=? and password=?", account, password);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static Admin getByAccount(String account) {
		
		return Admin.dao.findFirst("select * from db_admin where account=?", account);
	}
}