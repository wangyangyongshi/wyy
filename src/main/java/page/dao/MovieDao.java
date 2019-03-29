package page.dao;


import org.mybatis.spring.annotation.MapperScan;
import page.Entity.Movie;

/**
 * @author 王二小
 * @date 2019/3/28 0:11
 */
@MapperScan
public interface MovieDao {

    Movie findOne();
}
