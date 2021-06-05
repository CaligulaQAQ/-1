package util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 作者：威哥
 * 时间：2021/4/16 11:38
 * 描述：永无bug
 */
public class FileUploadUtil {

    public static String upload(HttpServletRequest req) throws IOException, ServletException {
        //拿到文件对象
        Part part = req.getPart("file");
        //将上传的图片保存到D://workspace//upload
        File file = new File("D:\\workspace\\upload");
        if(!file.exists()){
            file.mkdirs();
        }
        //获取新名称
        String fileName = getNewFileName(part.getSubmittedFileName());
        //将图片保存到指定位置
        part.write("D:\\workspace\\upload\\"+fileName);
        //返回保存到数据库的路径
        return "upload/"+fileName;
    }

    public static String getNewFileName(String fileName){
        //取出文件名后缀
        String fileExt = fileName.substring(fileName.lastIndexOf("."));
        //生成uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        //返回新的名称
        return uuid+fileExt;
    }

}
