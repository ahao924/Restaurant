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
public class Carousel extends Model<Carousel> {

	private static final long serialVersionUID = 1L;
	public static final Carousel dao = new Carousel();

    public final static int STATUS_ENABLE = 1;//启用
    public final static int STATUS_DELETED = 9;//删除
    
    /**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
	public static List<Carousel> getList(Object business_id) {
		
		return Carousel.dao.find("select c.*, a.title article_title from db_carousel c left join db_article a on c.article_id=a.id where c.status=? and c.business_id=? order by c.idx asc, c.create_date desc", Carousel.STATUS_ENABLE, business_id);
	}
}