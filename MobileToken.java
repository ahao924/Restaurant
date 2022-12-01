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
public class MobileToken extends Model<MobileToken> {

	private static final long serialVersionUID = 1L;
	public static final MobileToken dao = new MobileToken();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static MobileToken getByMobileCode(Object mobile, Object token) {

		return MobileToken.dao.findFirst("select * from db_mobile_token where mobile=? and token=? order by create_date desc", mobile, token);
	}
}