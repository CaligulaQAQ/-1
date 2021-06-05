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
public class Pet {
    private Integer id;
    private String petimg;
    private String owner;
    private String petname;
    private String petcolor;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date adopttime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonIgnore
    private String file;
}
