package springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.bean.Furn;
import springboot.mapper.FurnMapper;
import springboot.service.FurnService;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestApp {
    @Resource
    private FurnMapper furnMapper;
    @Resource
    private FurnService furnService;
    @Test
    public void test(){
        System.out.println(furnMapper);
        List<Furn> list = furnService.list();
        System.out.println(list);
    }
}
