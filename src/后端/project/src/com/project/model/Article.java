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
public class Article extends Model<Article> {

	private static final long serialVersionUID = 1L;
	public static final Article dao = new Article();
	
    public final static int STATUS_ENABLE = 1;//启用
    public final static int STATUS_DELETED = 9;//删除
 
    public final static int SYSTEM_NO = 0;
    public final static int SYSTEM_YES = 1;//系统预置
    
    /**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Article> getList(String business_id) {

		return Article.dao.find("select * from db_article where status=? and business_id=? order by create_date desc", Article.STATUS_ENABLE, business_id);
	}
}