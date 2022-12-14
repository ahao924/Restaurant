package com.project.controller.admin;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.project.common.BaseController;
import com.project.model.Business;

/**
 * 预约桌位
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class YuyuezhuoweiController extends BaseController{
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void index() throws Exception{
		
		int page=getParaToInt("p",1);
		List<Object> params = new ArrayList<Object>();
		String sSelect="select y.*, tt.title tables_type_title, u.name user_name, u.img_url user_img_url, s.title shop_title, b.title business_title";
		String sWhere=" from db_yuyuezhuowei y left join db_tables_type tt on y.tables_type_id=tt.id left join db_user u on y.user_id=u.id left join db_shop s on y.shop_id=s.id left join db_business b on y.business_id=b.id where 1=1";
		if(StrKit.notBlank(getPara("bid"))){
			sWhere+=" and y.business_id=?";
			params.add(getPara("bid"));
			setAttr("bid", getParaToInt("bid"));
		}
		if(StrKit.notBlank(getPara("sid"))){
			sWhere+=" and y.shop_id=?";
			params.add(getPara("sid"));
			setAttr("sid", getParaToInt("sid"));
		}
		if(StrKit.notBlank(getPara("status"))){
			sWhere+=" and y.status=?";
			params.add(getPara("status"));
			setAttr("status", getParaToInt("status"));
		}
		if(StrKit.notBlank(getPara("content"))){
			sWhere+=" and (y.code like ? or y.name like ? or y.mobile like ? or y.daodianshijian like ? or u.name like ?)";
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			params.add("%" + getPara("content") + "%");
			setAttr("content", getPara("content"));
		}
		sWhere+=" order by y.create_date desc";
		Page<Record> results=Db.paginate(page, 20, sSelect, sWhere, params.toArray());
		setAttr("results", results);
		setAttr("totalPage", results.getTotalPage());
		//商家列表
		List<Business> business_list = Business.getList();
		setAttr("business_list", business_list);
		render("list.htm");
	}
}
