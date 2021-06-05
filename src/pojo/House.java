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
public class House {
    private Integer id;
    private String cname;
    private String buildname;
    private String haddress;
    private String owner;
    private Integer phonenum;
    private Integer roomnum;
    private Integer unit;
    private Integer floor;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date movetime;
    @JsonIgnore
    private String file;
}
