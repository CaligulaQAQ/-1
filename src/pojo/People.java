package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    private Integer id;
    private String buildname;
    private String cname;
    private String peoplename;
    private String peopleimg;
    private Integer peoplenum;
    private Integer phonenum;
    private String job;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date borndate;
    private String sex;
    private String mentype;
    private String note;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonIgnore
    private String file;

}
