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
public class BusinessLicense extends Model<BusinessLicense> {

	private static final long serialVersionUID = 1L;
	public static final BusinessLicense dao = new BusinessLicense();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static BusinessLicense getByBusiness(Object business_id) {
		
		return BusinessLicense.dao.findFirst("select * from db_business_license where business_id=?", business_id);
	}
}