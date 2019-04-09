package page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import page.Entity.Movie;
import page.exception.MathException;
import page.mapper.MovieMapper;

import javax.annotation.Resource;

/**
 * @author 王二小
 * @date 2019/3/26 22:52
 */
@Controller
public class PagingController {
    @Resource
    private MovieMapper movieMapper;
    @RequestMapping("/getBean")
    public ModelAndView getBean() {
        PageBean pageBean = new PageBean(1, 2, 5);
        Movie one = movieMapper.findOneMovie();
        try {
            System.out.println(1 / 0);
        } catch (MathException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(pageBean);
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @RequestMapping("/index")
    public ModelAndView index() {
        System.out.println("我是中国工人");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }


}
