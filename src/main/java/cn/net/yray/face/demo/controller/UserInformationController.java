package cn.net.yray.face.demo.controller;

import cn.net.cfss.fgbp.api.demo.dto.ProdCategoryDto;
import cn.net.cfss.fgbp.api.demo.dto.ProdUserDto;
import cn.net.cfss.fgbp.api.demo.inte.IProdUserService;
import cn.net.cfss.fgbp.api.demo.vo.ProdCategoryVo;
import cn.net.cfss.fgbp.api.demo.vo.ProdUserVo;
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
@RequestMapping("/prod/User")
public class UserInformationController extends BaseController {

    @Autowired(required = false)
    private IProdUserService prodUserService;

    @ApiOperation("User新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody BaseParas paras) {
        ProdUserVo vo = JSONObject.toJavaObject(paras.getPlain(), ProdUserVo.class);
        prodUserService.add(vo);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("User批量新增")
    @RequestMapping(value = "/addBatch", method = RequestMethod.POST)
    public String addBatch(@RequestBody BaseParas paras) {
        JSONArray jsonArray = paras.getPlain().getJSONArray("prodUserDtos");
        List<ProdUserDto> prodUserDtos = jsonArray.toJavaList(ProdUserDto.class);
        prodUserService.batchInsert(prodUserDtos);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("User删除")
    @RequestMapping(value = "/delete/{prodUserId}", method = RequestMethod.GET)
    public String delete(@PathVariable Long prodUserId) {
        prodUserService.deleteByLogic(prodUserId);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("User批量删除")
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public String deleteBatch(@RequestBody BaseParas paras) {
        JSONArray jsonArray = paras.getPlain().getJSONArray("prodUserIds");
        List<Long> prodUserId = JSONObject.parseArray(jsonArray.toJSONString(), Long.class);
        prodUserService.deleteBatchByLogic(prodUserId);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("User修改")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody BaseParas paras) {
        ProdUserVo vo = JSONObject.toJavaObject(paras.getPlain(), ProdUserVo.class);
        vo.setUpdateBy(getUserId());
        prodUserService.edit(vo);
        return ReturnUtil.returnSucc();
    }

    @ApiOperation("User详情查询")
    @RequestMapping(value = "/get/{prodUserId}", method = RequestMethod.GET)
    public String get(@PathVariable Long prodUserId) {
        return ReturnUtil.returnSucc(prodUserService.get(prodUserId));
    }

    @ApiOperation("User分页查询")
    @RequestMapping(value = "/query/page", method = RequestMethod.POST)
    public String queryPage(@RequestBody BaseParas paras) {
        ProdUserVo search = JSONObject.toJavaObject(paras.getPlain().getJSONObject("search"), ProdUserVo.class);

        PageData<ProdUserVo> pageData = PageData.createPagerData(paras.getPlain().getIntValue("pageSize"),
                paras.getPlain().getIntValue("pageNum"), search);
        PageData<ProdUserVo> prodUserVoPageData = prodUserService.queryByPage(pageData);
        return ReturnUtil.returnSucc(prodUserVoPageData, prodUserVoPageData.getRows());
    }
}
