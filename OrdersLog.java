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
public class OrdersLog extends Model<OrdersLog> {

	private static final long serialVersionUID = 1L;
	public static final OrdersLog dao = new OrdersLog();
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<OrdersLog> getByOrders(Object orders_id) {

		return OrdersLog.dao.find("select * from db_orders_log where orders_id=? order by create_date desc", orders_id);
	}
}