package page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import page.Entity.Movie;
import page.aop.JdkProxy;
import page.service.PageService;
import page.service.PageServiceImpl;

import javax.annotation.Resource;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author 王二小
 * @date 2019/3/26 22:52
 */
@Controller
public class PagingController {
    @Resource
    private PageService pageService;
    @RequestMapping("/getBean")
    public ModelAndView getBean() {
        PageBean pageBean = new PageBean(1, 2, 5);
        Movie one = pageService.findOneMovie();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(pageBean);
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @RequestMapping("/index")
    public ModelAndView index() throws UndeclaredThrowableException {
        JdkProxy jdkProxy = new JdkProxy();
        PageService pageService = (PageService) jdkProxy.getJdkProxy(new PageServiceImpl());

//        CgLibProxy cgLibProxy = new CgLibProxy();
//        PageService pageService =  (PageService) cgLibProxy.getCglibProxy(new PageServiceImpl());
        Movie one = pageService.findOneMovie();
        System.out.println(one.toString());
        System.out.println("我是中国工人");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }


}
