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
public class OrdersItem extends Model<OrdersItem> {

	private static final long serialVersionUID = 1L;
	public static final OrdersItem dao = new OrdersItem();
	
	public final static int STATUS_YITUICAN = 0;//已退餐
	public final static int STATUS_DAITUICAN = 1;
	
	public final static int TYPE_ADD = 1;//下单
	public final static int TYPE_EDIT = 2;//加餐
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getAll1(Object orders_id) {
		
		return Db.find("select oi.* from db_orders_item oi where oi.orders_id=?", orders_id);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getList1(Object orders_id) {
		
		return Db.find("select oi.* from db_orders_item oi where oi.orders_id=? and status=?", orders_id, OrdersItem.STATUS_DAITUICAN);
	}
}