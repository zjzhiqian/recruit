package com.hzq.project.car.web;

import com.alibaba.fastjson.JSON;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.exception.CarException;
import com.hzq.project.car.service.SecondCarService;
import com.hzq.project.car.vo.SecondCarVo;
import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

/**
 * Created by hzq on 16/9/25.
 */
@RestController
@RequestMapping("secondCar")
public class SecondCarController extends BaseController {
    @Autowired
    private SecondCarService secondCarService;


    /**
     * 发布二手车
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addSecondCar", method = RequestMethod.POST)
    public BaseResult addSecondCar(@Valid SecondCarVo secondCarVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        secondCarVo.setUserId(getUserId());

        //驾照
        secondCarVo.setPictue("/upload/" + UpLoadController.CAR_MERCHANT + "/" + secondCarVo.getPictue());
        //汽车照片url
        StringJoiner joiner = new StringJoiner(",");

        String[] urls = secondCarVo.getCarPic().split(",");
        if (urls.length > 8)
            throw new CarException("最多只能上传8张汽车图片");

        Arrays.stream(secondCarVo.getCarPic().split(",")).forEach(str -> {
            str = "/upload/" + UpLoadController.CAR_MERCHANT + "/" + str;
            joiner.add(str);
        });
        secondCarVo.setCarPic(joiner.toString());
        SecondCar secondCar = Creator.newInstance(secondCarVo, SecondCar.class);
        secondCarService.addSecondCar(secondCar);
        return new BaseResult("发布二手车信息成功");
    }

    public static void main(String[] args) {
        String[] arr = new String[]{
                "奥迪", "别克", "宝马", "比亚迪", "标致", "奔驰", "本田", "北汽绅宝", "北汽威旺", "宝骏", "保时捷", "北汽制造", "北汽幻速", "北京奔腾", "北汽新能源", "长安商用", "长安长城",
                "大众", "东风", "东南", "道奇", "DS", "福特", "丰田", "福田", "菲亚特", "福汽启腾", "广汽传祺", "观致", "广汽吉奥", "哈弗","海马"
                , "Jeep", "江淮", "捷豹", "吉利汽车", "金杯江铃", "凯迪拉克", "开瑞","克莱斯勒", "铃木雷诺", "路虎,", "雷克萨斯", "陆风", "力帆汽车", "力帆","莲花汽车", "理念", "猎豹汽车",
                "马自达", "MG", "玛莎拉蒂", "纳智捷", "讴歌", "欧宝", "起亚", "奇瑞", "启辰", "荣威","日产", "瑞麒", "斯柯达", "smart", "三菱", "斯巴鲁", "萨博思铭", "特斯拉",
                "五菱汽车", "沃尔沃", "威麟", "雪佛兰", "雪铁龙", "现代", "英菲尼迪一汽", "野马汽车", "中华", "众泰"
                };

        LinkedHashMap map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i + 1);
        }
        String s = JSON.toJSONString(map);
        System.out.println(s);
        System.out.println(map);
    }

}
