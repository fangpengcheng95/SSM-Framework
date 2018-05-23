package com.fpc.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fpc.Entity.User;
import com.fpc.Service.IUserService;
import com.fpc.Util.Page;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/showUser")
	@ResponseBody
	public ModelAndView toIndex( HttpServletRequest request , HttpServletResponse response) {
		List<User> users = (List<User>) this.userService.selectUser(0,1);
		ModelAndView mav=new ModelAndView("/user/showUser");
		mav.addObject("users",users);
		return mav;
	}
	
	@RequestMapping("/pagelist")
    public ModelAndView pageList(HttpServletRequest request, HttpServletResponse response) {
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int pageSize = 3;
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int currentResult = (currentPage - 1) * pageSize;

        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());

        Page page = new Page();
        page.setShowCount(pageSize);
        page.setCurrentResult(currentResult);
        List<User> users = userService.getUsersListPage(page);
        System.out.println("size : " + users.size());
        System.out.println(page);

        int totalCount = page.getTotalResult();

        int lastPage = 0;
        if (totalCount % pageSize == 0) {
            lastPage = totalCount % pageSize;
        } else {
            lastPage = 1 + totalCount / pageSize;
        }

        if (currentPage >= lastPage) {
            currentPage = lastPage;
        }

        String pageStr = "";

        pageStr = String.format("<a href=\"%s\">上一页</a>    <a href=\"%s\">下一页</a>", request.getRequestURI() + "?page=" + (currentPage - 1), request.getRequestURI() + "?page=" + (currentPage + 1));

        // 制定视图，也就是list.jsp
        ModelAndView mav = new ModelAndView("/pagelist");
        mav.addObject("users", users);
        mav.addObject("pageStr", pageStr);
        return mav;
    }
}
