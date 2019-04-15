package page.service;

import org.springframework.stereotype.Service;
import page.Entity.Movie;
import page.mapper.MovieMapper;

import javax.annotation.Resource;

/**
 * Created by wangyang on 2019/4/15.
 */
@Service("pageService")
public class PageServiceImpl implements PageService {
    @Resource
    private MovieMapper movieMapper;
    @Override
    public Movie findOneMovie() {
        System.out.println("使用jdk动态代理----这里没有对象");

        return movieMapper.findOneMovie();
    }
}
