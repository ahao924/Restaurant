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
public class DishesFormat extends Model<DishesFormat> {

	private static final long serialVersionUID = 1L;
	public static final DishesFormat dao = new DishesFormat();

	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<DishesFormat> getList(Object dishes_id) {
		
		return DishesFormat.dao.find("select * from db_dishes_format where dishes_id=?", dishes_id);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getList1(Object dishes_id) {
		
		return Db.find("select distinct(title_1) from db_dishes_format where dishes_id=?", dishes_id);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getList2(Object dishes_id, Object title_1) {
		
		return Db.find("select distinct(title_2) from db_dishes_format where dishes_id=? and title_1=?", dishes_id, title_1);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Record> getList3(Object dishes_id, Object title_1, Object title_2) {
		
		return Db.find("select * from db_dishes_format where dishes_id=? and title_1=? and title_2=?", dishes_id, title_1, title_2);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static DishesFormat getByDishesTitle(Object dishes_id, Object title_1, Object title_2, Object title_3) {

		return DishesFormat.dao.findFirst("select * from db_dishes_format where dishes_id=? and title_1=? and title_2=? and title_3=?", dishes_id, title_1, title_2, title_3);
	}
}