package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonToArray {
    public static <T> List<T> parseJSONArray(String jsonArray, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<T>();
        String datas = jsonArray.substring(1, jsonArray.length() - 1);
        String[] sps = datas.split("},");
        for (String sp : sps) {
            if (sp.indexOf("}") != sp.length() - 1) {
                sp = sp + "}";
            }
            ObjectMapper mapper = new ObjectMapper();
            T obj = mapper.readValue(sp, clazz);
            list.add(obj);
        }
        return list;
    }

}
