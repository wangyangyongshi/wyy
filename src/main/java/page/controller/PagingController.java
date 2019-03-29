package page.controller;

import page.Entity.Movie;
import page.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 王二小
 * @date 2019/3/26 22:52
 */
@Controller
public class PagingController {

    @Autowired
    private MovieDao movieDao;
    @RequestMapping("/getBean")
    public ModelAndView getBean() {
        PageBean pageBean = new PageBean(1, 2, 5);
        Movie one = movieDao.findOne();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(pageBean);
        modelAndView.setViewName("index");
        return modelAndView;

    }


}
