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
public class Notice extends Model<Notice> {

	private static final long serialVersionUID = 1L;
	public static final Notice dao = new Notice();
	
    public final static int STATUS_QIYONG = 1;//启用
    public final static int STATUS_JINYONG = 0;//禁用
    public final static int STATUS_SHANCHU = 9;//删除
    
    /**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Notice> getList1() {

		return Notice.dao.find("select * from db_notice where status=? order by create_date desc", Notice.STATUS_QIYONG);
	}
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：176-6401-7800
	 * 技术QQ：2511251392
	 */
	public static List<Notice> getAll1() {

		return Notice.dao.find("select * from db_notice where status!=? order by create_date desc", Notice.STATUS_SHANCHU);
	}
}