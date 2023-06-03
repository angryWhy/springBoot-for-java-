package springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result <T>{
    private String code;
    private String msg;
    private T data;
    public Result(T data){
        this.data = data;
    }
    public static Result success(){
        Result<Object> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
    public static Result error(){
        Result<Object> result = new Result<>();
        result.setCode("400");
        result.setMsg("error");
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
}
