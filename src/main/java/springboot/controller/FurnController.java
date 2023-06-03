package springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springboot.bean.Furn;
import springboot.service.FurnService;
import springboot.util.Result;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FurnController {
    @Resource
    private FurnService furnService;

    @RequestMapping("/list")
    public Result<?> list(){
        List<Furn> list = furnService.list();
        Result<List<Furn>> result = Result.success(list);
        return result;
    }
    @RequestMapping("/save")
    public Result save(@RequestBody Furn furn){
        boolean save = furnService.save(furn);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody Furn furn){
        furnService.updateById(furn);
        return Result.success();
    }
    @DeleteMapping("/deleted/{id}")
    public Result deleted(@PathVariable("id") Integer id){
        furnService.removeById(id);
        return Result.success();
    }
    @RequestMapping("/list/{id}")
    public Result<?> listById(@PathVariable("id") Integer id){
        Furn furn = furnService.getById(id);
        Result<Furn> result = Result.success(furn);
        return result;
    }

    @RequestMapping("/listByPage")
    public Result<?> listByPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20") Integer pageSize){
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize));
        Result success = Result.success();
        success.setData(page);
        return success;
    }
    @RequestMapping("/listByCondition")
    public Result listFurnByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam(defaultValue = "") String search){
        QueryWrapper<Furn> query = Wrappers.query();
        if(StringUtils.hasText(search)){
            query.like("name", search);
        }
        Page<Furn> list = furnService.page(new Page<>(pageNum, pageSize), query);
        Result success = Result.success();
        success.setData(list);
        return success;
    }

    @RequestMapping("/listByCondition2")
    public Result listFurnByConditionPage2(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Furn> lambdaQuery = Wrappers.<Furn>lambdaQuery();
        if(StringUtils.hasText(search)){
            lambdaQuery.like(Furn::getName,search);
        }
        Page<Furn> list = furnService.page(new Page<>(pageNum, pageSize), lambdaQuery);
        Result success = Result.success();
        success.setData(list);
        return success;
    }
}
