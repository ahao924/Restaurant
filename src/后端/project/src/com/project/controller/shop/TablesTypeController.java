package com.project.controller.shop;

import java.util.Date;
import java.util.List;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Record;
import com.project.common.BaseController;
import com.project.model.TablesType;

/**
 * 
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class TablesTypeController extends BaseController{
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void index() throws Exception{
		
		List<Record> list = TablesType.getList(getLoginShopId());
		setAttr("list",list);
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
	public void add() throws Exception{
		
		render("add.htm");
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void save() throws Exception{
		
		String title=getPara("title");
		String idx=getPara("idx");
		String number=getPara("number");
		if(StrKit.isBlank(title)){
			setAttr("success", false);
			setAttr("msg", "标题不能为空");
			renderJson();
			return;
		}
		if(StrKit.isBlank(idx)){
			setAttr("success", false);
			setAttr("msg", "排序不能为空");
			renderJson();
			return;
		}
		if(StrKit.isBlank(number)){
			setAttr("success", false);
			setAttr("msg", "容纳人数不能为空");
			renderJson();
			return;
		}
		TablesType tables_type=new TablesType();
		tables_type.set("title", title)
					.set("idx", idx)
					.set("number", number)
					.set("shop_id", getLoginShopId())
					.set("status", TablesType.STATUS_ENABLE)
					.set("create_date", new Date())
					.save();
		setAttr("success", true);
		setAttr("msg", "操作成功");
		renderJson();
		return;
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void edit() throws Exception{
		
		TablesType tables_type=TablesType.dao.findById(getPara("id"));
		if(!tables_type.get("shop_id").toString().equals(getLoginShopId())){
			setAttr("msg", "没有操作权限");
			render("/shop/msg.htm");
			return;
		}
		setAttr("tables_type", tables_type);
		render("edit.htm");
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void update() throws Exception{
		
		TablesType tables_type=TablesType.dao.findById(getPara("id"));
		if(!tables_type.get("shop_id").toString().equals(getLoginShopId())){
			setAttr("success", false);
			setAttr("msg", "没有操作权限");
			renderJson();
			return;
		}
		String title=getPara("title");
		String idx=getPara("idx");
		String number=getPara("number");
		if(StrKit.isBlank(title)){
			setAttr("success", false);
			setAttr("msg", "标题不能为空");
			renderJson();
			return;
		}
		if(StrKit.isBlank(idx)){
			setAttr("success", false);
			setAttr("msg", "排序不能为空");
			renderJson();
			return;
		}
		if(StrKit.isBlank(number)){
			setAttr("success", false);
			setAttr("msg", "容纳人数不能为空");
			renderJson();
			return;
		}
		tables_type.set("title", title)
					.set("idx", idx)
					.set("number", number)
					.update();
		setAttr("success", true);
		setAttr("msg", "操作成功");
		renderJson();
		return;
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public void changeStatus() throws Exception{

		TablesType tables_type=TablesType.dao.findById(getPara("id"));
		if(!tables_type.get("shop_id").toString().equals(getLoginShopId())){
			setAttr("success", false);
			setAttr("msg", "没有操作权限");
			renderJson();
			return;
		}
		tables_type.set("status", getPara("status"))
					.update();
		setAttr("success", true);
		setAttr("msg", "操作成功");
		renderJson();
		return;
	}
}
