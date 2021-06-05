package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：威哥
 * 时间：2021/4/20 15:56
 * 描述：永无bug
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> {
    private Integer code; //10000 20000   自定义的响应码
    private String msg ;// 响应信息
    private T data;    //表示查询时候的数据
    private Integer count;

    public DataResult(Integer code , String msg){
        this.code = code;
        this.msg = msg;
    }
    public DataResult(Integer code , String msg, T t){
        this.code = code;
        this.msg = msg;
        this.data = t;
    }
}
