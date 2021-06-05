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
public class Com {
    private Integer id;
    private String cno;
    private String cname;
    private Double area;
    private String caddress;
    private Integer numbuild;
    private Integer numfamily;
    private Double greenrate;
    private String img;
    private String developer;
    private String company;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    private Integer status;
    @JsonIgnore
    private String file;
}
