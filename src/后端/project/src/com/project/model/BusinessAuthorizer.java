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
public class BusinessAuthorizer extends Model<BusinessAuthorizer> {

	private static final long serialVersionUID = 1L;
	public static final BusinessAuthorizer dao = new BusinessAuthorizer();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static BusinessAuthorizer getByBusiness(Object business_id) {
		
		return BusinessAuthorizer.dao.findFirst("select * from db_business_authorizer where business_id=?", business_id);
	}
}