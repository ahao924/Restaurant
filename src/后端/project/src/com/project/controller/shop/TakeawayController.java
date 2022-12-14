package com.project.controller.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.project.common.BaseController;
import com.project.model.Orders;
import com.project.model.OrdersItem;
import com.project.model.OrdersLog;
import com.project.model.Tables;
import com.project.model.User;
import com.project.util.DateUtil;

/**
 * 
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class TakeawayController extends BaseController{
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void index() throws Exception{
		
		//今日开始时间
		Date today_start_time = DateUtil.getStartTimeOfDay(new Date());
		setAttr("today_start_time", DateUtil.formatDate(today_start_time,"yyyy-MM-dd HH:mm"));
		//今日结束时间
		Date today_end_time = DateUtil.getEndTimeOfDay(new Date());
		setAttr("today_end_time", DateUtil.formatDate(today_end_time,"yyyy-MM-dd HH:mm"));
		//昨日开始时间
		Date yesterday_start_time = DateUtil.getStartTimeOfDay(DateUtil.getYesterday());
		setAttr("yesterday_start_time", DateUtil.formatDate(yesterday_start_time,"yyyy-MM-dd HH:mm"));
		//昨日结束时间
		Date yesterday_end_time = DateUtil.getEndTimeOfDay(DateUtil.getYesterday());
		setAttr("yesterday_end_time", DateUtil.formatDate(yesterday_end_time,"yyyy-MM-dd HH:mm"));
		//近7日开始时间
		Date seven_start_time = DateUtil.getStartTimeOfDay(DateUtil.getDayAfter(-7));
		setAttr("seven_start_time", DateUtil.formatDate(seven_start_time,"yyyy-MM-dd HH:mm"));
		System.out.println(DateUtil.formatDate(seven_start_time));
		//近7日结束时间
		Date seven_end_time = DateUtil.getEndTimeOfDay(DateUtil.getDayAfter(-1));
		setAttr("seven_end_time", DateUtil.formatDate(seven_end_time,"yyyy-MM-dd HH:mm"));
		//近30日开始时间
		Date thirty_start_time = DateUtil.getStartTimeOfDay(DateUtil.getDayAfter(-30));
		setAttr("thirty_start_time", DateUtil.formatDate(thirty_start_time,"yyyy-MM-dd HH:mm"));
		System.out.println(DateUtil.formatDate(thirty_start_time));
		//近30日结束时间
		Date thirty_end_time = DateUtil.getEndTimeOfDay(DateUtil.getDayAfter(-1));
		setAttr("thirty_end_time", DateUtil.formatDate(thirty_end_time,"yyyy-MM-dd HH:mm"));
		System.out.println(DateUtil.formatDate(thirty_end_time));
		int page=getParaToInt("p",1);
		List<Object> params = new ArrayList<Object>();
		String sSelect="select o.*, u.name user_name, u.img_url user_img_url";
		String sWhere=" from db_orders o left join db_user u on o.user_id=u.id where o.display=? and o.takeaway=? and o.shop_id=?";
		params.add(Orders.DISPLAY_YES);
		params.add(Orders.TAKEAWAY_YES);
		params.add(getLoginShopId());
		if(StrKit.notBlank(getPara("status"))){
			if (getPara("status").equals("-1")) {
				sWhere+=" and o.closed=?";
				params.add(Orders.CLOSED_YES);
			}else {
				sWhere+=" and o.status=? and o.closed=?";
				params.add(getPara("status"));
				params.add(Orders.CLOSED_NO);
			}
			setAttr("status", getParaToInt("status"));
		}
		if(StrKit.notBlank(getPara("startT"))){
			sWhere+=" and o.create_date>=?";
			params.add(DateUtil.stringToDate(getPara("startT"), "yyyy-MM-dd HH:mm"));
			setAttr("startT", getPara("startT"));
		}
		if(StrKit.notBlank(getPara("endT"))){
			sWhere+=" and o.create_date<=?";
			params.add(DateUtil.stringToDate(getPara("endT"), "yyyy-MM-dd HH:mm"));
			setAttr("endT", getPara("endT"));
		}
		if(StrKit.notBlank(getPara("content"))){
			sWhere+=" and (o.code like ? or o.take_name like ? or o.take_mobile like ? or u.name like ?)";
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			setAttr("content", getPara("content"));
		}
		sWhere+=" order by o.create_date desc";
		Page<Record> results=Db.paginate(page, 20, sSelect, sWhere, params.toArray());
		setAttr("results", results);
		setAttr("totalPage", results.getTotalPage());
		render("list.htm");
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void msg() throws Exception{
		
		Orders orders=Orders.dao.findById(getPara("id"));
		if(!orders.get("shop_id").toString().equals(getLoginShopId())){
			setAttr("msg", "没有操作权限");
			render("/shop/msg.htm");
			return;
		}
		setAttr("orders", orders);
		//会员
		User user = User.dao.findById(orders.get("user_id"));
		setAttr("user", user);
		//订单桌位
		Tables tables=Tables.dao.findById(orders.get("tables_id"));
		setAttr("tables", tables);
		//订单菜品
		List<Record> item_list=OrdersItem.getAll1(orders.get("id"));
		setAttr("item_list", item_list);
		//订单日志
		List<OrdersLog> log_list=OrdersLog.getByOrders(orders.get("id"));
		setAttr("log_list", log_list);
		render("msg.htm");
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	@Before(Tx.class)
	public void doPeisong() throws Exception{
		
		Orders orders=Orders.dao.findById(getPara("id"));
		if(!orders.get("shop_id").toString().equals(getLoginShopId())){
			setAttr("success", false);
			setAttr("msg", "没有操作权限");
			renderJson();
			return;
		}
		if(orders.getInt("takeaway")!=Orders.TAKEAWAY_YES || orders.getInt("status")!=Orders.STATUS_PAY){
			setAttr("success", false);
			setAttr("msg", "没有操作权限");
			renderJson();
			return;
		}
		orders.set("status", Orders.STATUS_PEISONG)
				.set("peisong_type", Orders.PRISONG_SHOP)
				.update();
		OrdersLog orders_log=new OrdersLog();
		orders_log.set("orders_id", orders.get("id"))
					.set("content", "门店|" + getLoginShopAdminName() + "（" + getLoginShopAdminId() + "）" + "开始配送")
					.set("create_date", new Date())
					.save();
		setAttr("success", true);
		setAttr("msg", "操作成功");
		renderJson();
		return;
	}
}
