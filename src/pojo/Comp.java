package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//投诉表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comp {
    private Integer id;
    private String cname;
    private String people;
    private String name;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    private Integer status;
    @JsonIgnore
    private String file;
}
