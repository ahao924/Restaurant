package com.project.aop;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.project.common.BaseController;
import com.project.model.BusinessAdmin;

/**
 * 商家端拦截器
 * 
 * 青岛蓝图科技网络有限公司
 * http://www.xiaodaofuli.com
 * 联系方式：137-9192-7167
 * 技术QQ：2511251392
 */
public class BusinessRootInterceptor implements Interceptor{
	
	/**
	 * 
	 * 
	 * 青岛蓝图科技网络有限公司
	 * http://www.xiaodaofuli.com
	 * 联系方式：137-9192-7167
	 * 技术QQ：2511251392
	 */
    public void intercept(Invocation ai) {

    	BaseController controller=(BaseController) ai.getController();
    	HttpServletRequest request=controller.getRequest();
    	String header=request.getHeader("X-Requested-With");
    	boolean isAjax="XMLHttpRequest".equalsIgnoreCase(header);
    	BusinessAdmin business_amdin=BusinessAdmin.dao.findById(controller.getLoginBusinessAdminId());
    	if(business_amdin.getInt("type")!=BusinessAdmin.TYPE_1){
    		if(isAjax){
				 controller.setAttr("success", false);
				 controller.setAttr("msg", "没有操作权限");
				 controller.renderJson();
				 return;
			 }else{
				 controller.setAttr("msg", "没有操作权限");
				 controller.render("/business/msg.htm");
				 return;
			 }
    	}
    	ai.invoke();
    }
}
