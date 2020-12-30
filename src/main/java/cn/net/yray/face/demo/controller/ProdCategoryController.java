package cn.net.yray.face.demo.controller;

import cn.net.cfss.fgbp.api.demo.inte.IProdCategoryService;
import cn.net.cfss.fgbp.api.demo.vo.ProdCategoryVo;
import cn.net.cfss.fgbp.base.common.GlobalConstants;
import cn.net.cfss.fgbp.base.controller.BaseController;
import cn.net.cfss.fgbp.base.page.PageData;
import cn.net.cfss.fgbp.base.util.ReturnUtil;
import cn.net.cfss.fgbp.base.vo.BaseParas;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/prod/category")
public class ProdCategoryController extends BaseController {

    @Autowired(required = false)
    private IProdCategoryService prodCategoryService;

    @ApiOperation("产品类别新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody BaseParas paras) {
        ProdCategoryVo vo = JSONObject.toJavaObject(paras.getPlain(), ProdCategoryVo.class);
        vo.setCreateBy(getUserId());
        prodCategoryService.add(vo);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("产品类别修改")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody BaseParas paras) {
        ProdCategoryVo vo = JSONObject.toJavaObject(paras.getPlain(), ProdCategoryVo.class);
        vo.setUpdateBy(getUserId());
        prodCategoryService.edit(vo);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("产品类别逻辑删除")
    @RequestMapping(value = "/delete/{prodCategoryId}", method = RequestMethod.GET)
    public String delete(@PathVariable Long prodCategoryId) {
        prodCategoryService.deleteByLogic(prodCategoryId);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("产品类别批量删除")
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public String deleteBatch(@RequestBody BaseParas paras) {
        JSONArray jsonArray = paras.getPlain().getJSONArray("prodCategoryIds");
        List<Long> prodCategoryId = JSONObject.parseArray(jsonArray.toJSONString(), Long.class);
        prodCategoryService.deleteBatchByLogic(prodCategoryId);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("产品类别详情查询")
    @RequestMapping(value = "/get/{prodCategoryId}", method = RequestMethod.GET)
    public String get(@PathVariable Long prodCategoryId) {
        return ReturnUtil.returnSucc(prodCategoryService.get(prodCategoryId));
    }

    @ApiOperation("产品类别分页查询")
    @RequestMapping(value = "/query/page", method = RequestMethod.POST)
    public String queryPage(@RequestBody BaseParas paras) {
        ProdCategoryVo search = JSONObject.toJavaObject(paras.getPlain().getJSONObject("search"), ProdCategoryVo.class);

        PageData<ProdCategoryVo> pageData = PageData.createPagerData(paras.getPlain().getIntValue("pageSize"),
                paras.getPlain().getIntValue("pageNum"), search);
        pageData = prodCategoryService.queryByPage(pageData);
        return ReturnUtil.returnSucc(pageData, pageData.getRows());
    }

    @ApiOperation("产品类别名称的唯一性校验")
    @RequestMapping(value = "/uniqueCheck", method = RequestMethod.POST)
    public String uniqueCheck(@RequestBody BaseParas paras) {
        try {
            String categoryName = paras.getPlain().getString("categoryName");
            Long id = paras.getPlain().getLong("id");
            return ReturnUtil.returnSucc(prodCategoryService.uniqueCheck(categoryName, id));
        } catch (Exception e) {
            log.error("用户唯一校验请求失败！", e.getMessage());
            return ReturnUtil.returnErr("用户唯一校验请求失败！");
        }

    }

}
