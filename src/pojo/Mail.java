package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private Integer id;
    private String cname;
    private String source;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private String createtime;
    private Integer status;
    @JsonIgnore
    private String file;
}
