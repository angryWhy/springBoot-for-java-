package springboot.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import springboot.bean.Furn;
import springboot.mapper.FurnMapper;
import springboot.service.FurnService;
@Service
public class FurnServiceImp extends ServiceImpl<FurnMapper, Furn> implements FurnService{
}
