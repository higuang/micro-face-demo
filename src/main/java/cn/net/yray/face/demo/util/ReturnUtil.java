package cn.net.yray.face.demo.util;

import cn.net.cfss.fgbp.base.constant.ErrCodeEnum;
import cn.net.cfss.fgbp.base.page.PageData;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class ReturnUtil {

    public static String returnErr(String errMsg) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.ERR.getValue());
        plainJson.put("resultMsg", errMsg);
        log.error(errMsg);
        return signAndBase64(plainJson);
    }

    public static String returnErr(ErrCodeEnum errMsg) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", errMsg.getValue());
        plainJson.put("resultMsg", errMsg.getDisplayName());
        log.error(errMsg.getDisplayName());
        return signAndBase64(plainJson);
    }

    public static String returnSucc() {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.SUCC.getValue());
        plainJson.put("resultMsg", ErrCodeEnum.SUCC.getDisplayName());
        return signAndBase64(plainJson);
    }

    public static String returnSucc(Map details) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.SUCC.getValue());
        plainJson.put("resultMsg", ErrCodeEnum.SUCC.getDisplayName());
        if (details != null && details.size() > 0) {
            plainJson.put("details", details);
        }
        return signAndBase64(plainJson);
    }

    public static String returnSucc(PageData page, List items) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.SUCC.getValue());
        plainJson.put("resultMsg", ErrCodeEnum.SUCC.getDisplayName());
        if (page != null) {
            JSONObject details = new JSONObject();
            details.put("pageSum", page.getPageSum());
            details.put("pageNum", page.getPageNum());
            details.put("total", page.getTotal());
            details.put("items", items);
            plainJson.put("details", details);
        }
        return signAndBase64(plainJson);
    }

    private static String signAndBase64(JSONObject plain) {
        JSONObject packet = new JSONObject();
        packet.put("plain", plain);
        // packet.put("signature", SecurityUtil.msgSign(plain,"no"));
        // packet.put("signature", "");
        return JSONObject.toJSONString(packet, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
        // return SecurityUtil.encryptBASE64(packet.toString().getBytes()) ;
    }

    public static String returnSucc(List details) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.SUCC.getValue());
        plainJson.put("resultMsg", ErrCodeEnum.SUCC.getDisplayName());
        // 处理返回的时间
        // JsonConfig jsonConfig = new JsonConfig();
        // jsonConfig.registerJsonValueProcessor(Date.class, new Jsonconf());
        // jsonConfig.registerJsonValueProcessor(Long.class, new Jsonconf());
        // JSONArray jsonArray = JSONArray.fromObject(details, jsonConfig);
        plainJson.put("details", details);
        return signAndBase64(plainJson);
    }

    public static String returnSucc(Object object) {
        JSONObject plainJson = new JSONObject();
        plainJson.put("resultCode", ErrCodeEnum.SUCC.getValue());
        plainJson.put("resultMsg", ErrCodeEnum.SUCC.getDisplayName());
        // 处理返回时间
        // JsonConfig jsonConfig = new JsonConfig();
        // jsonConfig.registerJsonValueProcessor(Date.class, new Jsonconf());
        // jsonConfig.registerJsonValueProcessor(Long.class, new Jsonconf());
        // JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
        plainJson.put("details", object);
        return signAndBase64(plainJson);
    }
}
