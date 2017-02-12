package com.hzq.project.user.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.AESUtil;
import com.hzq.project.system.common.entity.CookieInfo;
import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.util.Roles;
import com.hzq.project.user.dao.entity.Company;
import com.hzq.project.user.dao.entity.User;
import com.hzq.project.user.exception.UserException;
import com.hzq.project.user.service.CompanyService;
import com.hzq.project.user.service.UserService;
import com.hzq.project.user.vo.CompanyInfo;
import com.hzq.project.user.vo.CompanyVo;
import com.hzq.project.user.vo.LogInVo;
import com.hzq.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * UserController
 * Created by hzq on 16/9/19.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    /**
     * 注册用户
     */
    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid UserVo userVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        if (!userVo.getPassword().equals(userVo.getPassword2()))
            throw new UserException("抱歉,输入密码不一致");
        User user = Creator.newInstance(userVo, User.class);
        userService.addUser(user);
        return new BaseResult("注册用户成功");
    }


    /**
     * 注册企业
     */
    @RequestMapping(path = "/registerCompany", method = RequestMethod.POST)
    public BaseResult registerCompany(@Valid CompanyVo companyVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        companyVo.setPicture("/upload/" + UpLoadController.COMPANY_PIC + "/" + companyVo.getPicture());
        if (!companyVo.getPassword().equals(companyVo.getPassword2()))
            throw new UserException("抱歉,输入密码不一致");
        Company company = Creator.newInstance(companyVo, Company.class);
        companyService.addCompany(company);
        return new BaseResult("注册企业成功");
    }


    /**
     * 获取企业详情
     */
    @RequestMapping(path = "/companyInfo/{id}", method = RequestMethod.GET)
    public CompanyInfo companyInfo(@PathVariable Integer id) {
        if (id == null)
            throw new UserException();
        return companyService.getCompanyInfoById(id);
    }


    /**
     * 获取企业详情(企业自己)
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/companyInfo", method = RequestMethod.GET)
    public CompanyInfo companyInfo() {
        return companyService.getCompanyInfoById(getCompanyId());
    }


    /**
     * 登录
     */
    @RequestMapping(path = "/logIn", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid LogInVo logInVo, BindingResult bindingResult, HttpServletResponse response) {
        ValidatorHelper.validBindingResult(bindingResult);
        Integer type = logInVo.getType();
        String userName = logInVo.getUserName();
        String password = logInVo.getPassword();

        UserInfo info;
        long time = System.currentTimeMillis();
        if (type == 1) {
            User user = userService.selectUserByUserName(userName);
            if (user == null || !password.equals(user.getPassword()))
                throw new UserException("账号或密码错误");
            info = Creator.newInstance(user, UserInfo.class);
        } else {
            Company company = companyService.selectCompanyByUserName(userName);
            if (company == null || !password.equals(company.getPassword()))
                throw new UserException("账号或密码错误");
            info = Creator.newInstance(company, UserInfo.class);
            type = 2;
        }
        info.setUserType(type);
        info.setLogInTime(time);
        String key = AESUtil.encrypt(userName, time);

        RedisHelper.set(key, JSON.toJSONString(info));
        RedisHelper.expire(key, 12 * 60 * 60);

        //权限cookie
        Cookie cookie = new Cookie("token", key);
        cookie.setMaxAge(3600 * 12);
        cookie.setPath("/");
        response.addCookie(cookie);

        //信息cookie
        CookieInfo cookieInfo = new CookieInfo();
        cookieInfo.setUserName(userName);
        cookieInfo.setUserType(type);
        Cookie cookie2 = new Cookie("info", JSON.toJSONString(cookieInfo));
        cookie2.setMaxAge(3600 * 12);
        cookie2.setPath("/");
        response.addCookie(cookie2);

        return new BaseResult("登录成功");
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"奥迪", "别克", "宝马", "比亚迪", "标致", "奔驰", "本田", "北汽绅宝", "北汽威旺", "宝骏", "保时捷", "北汽制造", "北汽幻速", "北京奔腾", "北汽新能源", "长安商用", "长安长城",
                "大众", "东风", "东南", "道奇", "DS", "福特", "丰田", "福田", "菲亚特", "福汽启腾", "广汽传祺", "观致", "广汽吉奥", "哈弗", "海马"
                , "Jeep", "江淮", "捷豹", "吉利汽车", "金杯江铃", "凯迪拉克", "开瑞", "克莱斯勒", "铃木雷诺", "路虎,", "雷克萨斯", "陆风", "力帆汽车", "力帆", "莲花汽车", "理念", "猎豹汽车",
                "马自达", "MG", "玛莎拉蒂", "纳智捷", "讴歌", "欧宝", "起亚", "奇瑞", "启辰", "荣威", "日产", "瑞麒", "斯柯达", "smart", "三菱", "斯巴鲁", "萨博", "特斯拉",
                "五菱汽车", "沃尔沃", "威麟", "雪佛兰", "雪铁龙", "现代", "英菲尼迪一汽", "野马汽车", "中华", "众泰",

                "AC Schnitzer", "ALPINA", "Arash", "ARCFOX", "阿尔法罗密欧 ", "阿斯顿·马丁", "安凯客车",
                "巴博斯", "宝沃北京", "北汽幻速", "北汽威旺", "比速汽车", "标致", "宾利", "布加迪",
                "Caterham", "昌河", "成功汽车", "长安商用", "长城", "长江EV",

                "Dacia", "DMC", "大发", "东风风度", "东风风光", "东风风行", "东风风神", "东风小康",
                "Faraday", "Future", "Fisker", "法拉利", "福迪", "福田乘用车",
                "GLM", "GMC", "Gumpert", "光冈",
                "Hennessey", "哈飞", "海格", "汉腾汽车", "悍马", "恒天", "红旗", "华凯", "华利", "华普", "华骐", "华颂", "华泰", "华泰新能源", "黄海霍顿",
                "江铃集团轻汽", "江铃集团新能源", "金龙", "金旅", "九龙",
                "KTM", "卡尔森", "卡威", "凯佰赫", "凯翼", "科尼赛克",
                "LeSEE", "LYNK&CO", "兰博基尼", "蓝旗亚", "朗世", "劳斯莱斯", "雷诺", "林肯", "铃木", "领志", "路特斯",
                "MINI", "迈巴赫", "迈凯伦", "摩根",
                "nanoFLOWCELL", "Noble", "南京金龙",
                "讴朗",
                //P
                "帕加尼", "佩奇奥",
                "前途",
                "Rezvani", "Rimac", "Rinspeed", "如虎", "瑞麒",
                "Scion", "SPIRRA", "SSC", "SWM斯威汽车", "赛麟", "上海", "上汽大通", "世爵", "双环", "双龙", "思铭",
                "腾势",
                "WEY", "威兹曼", "潍柴英致", "蔚来", "沃克斯豪尔", "五十铃",
                "西雅特", "雪佛兰",
                "一汽", "依维柯", "永源", "游侠驭胜",
                "Zenvo", "之诺", "知豆", "中兴"};
        Map<Integer, String> map = Maps.newHashMap();
        Map<String, Integer> map2 = Maps.newLinkedHashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(i + 1, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            map2.put(arr[i],i+1);
        }
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(map2));

    }

}
