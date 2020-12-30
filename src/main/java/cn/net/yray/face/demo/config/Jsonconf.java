package cn.net.yray.face.demo.config;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author oygq
 * @title: Jsonconf
 * @description: date 类型序列化处理
 * @date 2019/4/22 10:05
 */
public class Jsonconf implements JsonValueProcessor {

    private String datePattern = "yyyy-MM-dd HH:mm:ss";//默认样式

    public Jsonconf() {
        super();
    }

    public Jsonconf(String datePattern) {
        super();
        this.datePattern = datePattern;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        try {
            if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
                Date date = (Date) value;
                return sdf.format(date);
            }
            return value == null ? null : value.toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return processArrayValue(value, jsonConfig);
    }
}
