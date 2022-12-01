package com.project.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * 
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class BusinessAdmin extends Model<BusinessAdmin> {

	private static final long serialVersionUID = 1L;
	public static final BusinessAdmin dao = new BusinessAdmin();
    
	public final static int STATUS_ENABLE = 1;//启用
	public final static int STATUS_DELETED = 9;//删除
	
	public final static int TYPE_1 = 1;
	public final static int TYPE_2 = 2;
    
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static BusinessAdmin getByEmailMd5Pwd(String email, String password) {

		return BusinessAdmin.dao.findFirst("select * from db_business_admin where email=? and password=? and status=?", email, password, BusinessAdmin.STATUS_ENABLE);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static BusinessAdmin getByEmail(String email) {

		return BusinessAdmin.dao.findFirst("select * from db_business_admin where email=? and status=?", email, BusinessAdmin.STATUS_ENABLE);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getByBusiness(String business_id) {

		return Db.find("select * from db_business_admin where business_id=? and status=?", business_id, BusinessAdmin.STATUS_ENABLE);
	}
}