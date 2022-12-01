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
public class BusinessRenew extends Model<BusinessRenew> {

	private static final long serialVersionUID = 1L;
	public static final BusinessRenew dao = new BusinessRenew();
	
	public final static int STATUS_DAIFUKUAN = 0;
	public final static int STATUS_YIFUKUAN = 1;
	
	public final static int PAYMENT_WX = 1;//微信
	public final static int PAYMENT_ALIPAY = 2;//支付宝
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static BusinessRenew getByCode(String code) {

		return BusinessRenew.dao.findFirst("select * from db_business_renew where code=?", code);
	}
}