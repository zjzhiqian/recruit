package com.hzq.project.user.web;

import com.hzq.project.car.service.SecondCarService;
import com.hzq.project.house.dao.SecondHouseMapper;
import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.user.dao.entity.Favor;
import com.hzq.project.user.dao.entity.User;
import com.hzq.project.user.exception.FavorException;
import com.hzq.project.user.exception.UserException;
import com.hzq.project.user.service.FavorService;
import com.hzq.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by hzq on 17/1/26.
 */
@RestController
@RequestMapping("/favor")
public class FavorController extends BaseController {

    @Autowired
    FavorService favorService;

    @Autowired
    SecondCarService secondCarService;

    @Autowired
    RecruitmentMapper recruitmentMapper;

    @Autowired
    SecondHouseMapper secondHouseMapper;


    /**
     * 添加取消收藏/添加取消举报
     */
    @RequestMapping(path = "/doFavor/{isFavor}/{type}/{relationId}/{cancel}", method = RequestMethod.POST)
    public BaseResult favor(@PathVariable Integer type, @PathVariable Integer relationId, @PathVariable Integer isFavor, @PathVariable Integer cancel) {
        Integer userType = getUserType();
        if (cancel == 0) { //添加
            Favor favor = new Favor();
            favor.setUserType(userType);
            if (userType == 1) {
                favor.setUserId(getUserId().toString());
            } else {
                favor.setUserId(getCompanyId().toString());
            }
            String url;
            String title;
            //TODO 其他类型
            if (type == 0) {//二手车
                url = "TwBusDea.html?id=" + relationId;
                title = Optional.ofNullable(secondCarService.getSecondCarById(relationId)).orElseThrow(() -> new FavorException("二手车不存在")).getTitle();

            } else if (type == 1) {//职位
                url = "WorkInfo.html?id=" + relationId + "&companyId=17";
                title = Optional.ofNullable(recruitmentMapper.getByPk(relationId)).orElseThrow(() -> new FavorException("职位不存在")).getTitle();
            } else if (type == 2) {
                url = "TwHouDea.html?id=" + relationId;
                title = Optional.ofNullable(secondHouseMapper.getByPk(relationId)).orElseThrow(() -> new FavorException("二手房不存在")).getTitle();
            } else {
                return new BaseResult("");
            }
            favor.setUrl(url);
            favor.setTitle(title);
            favor.setType(type);
            favor.setIsFavor(isFavor);
            favor.setFavorId(relationId);
            favorService.addFavor(favor);
            return new BaseResult("操作成功");
        } else {
            //取消
            favorService.deleteByUserIdAndTypeAndRelationId(getUserId(), type, relationId, userType);
            return new BaseResult("操作成功");
        }
    }

    /**
     * 查看是否已经收藏举报
     */
    @RequestMapping(path = "/getFavor/{isFavor}/{type}/{relationId}", method = RequestMethod.GET)
    public Integer isFavor(@PathVariable Integer type, @PathVariable Integer relationId, @PathVariable Integer isFavor) {
        Integer userType = getUserType();
        Integer userId = 0;
        try {
            if (userType == 1) {
                userId = getUserId();
            } else {
                userId = getCompanyId();
            }
        } catch (Exception e) {
            return 0;
        }
        return favorService.getIsFavor(userId, type, relationId, isFavor, userType);
    }


    /**
     * 查看是否已经收藏举报
     */
    @RequestMapping(path = "/favorList", method = RequestMethod.GET)
    public List<Favor> favorList() {
        Integer userType = getUserType();
        Integer userId;
        if (userType == 1) {
            userId = getUserId();
        } else {
            userId = getCompanyId();
        }
        return favorService.favorList(userId, userType);
    }


}
