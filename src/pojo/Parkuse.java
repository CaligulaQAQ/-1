package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parkuse {
    private Integer id;
    private String cname;
    private String parknum;
    private String carnum;
    private String carnumimg;
    private String carowner;
    private Integer phonenum;
    private Integer cost;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date starttime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endtime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    private Integer status;
    @JsonIgnore
    private String file;
}
