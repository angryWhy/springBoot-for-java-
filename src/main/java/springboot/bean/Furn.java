package springboot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName(value = "furn")
public class Furn {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String marker;

    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String img_path;
}
