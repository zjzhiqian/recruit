package com.hzq.project.house.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class SecondHouseVo {

    private Integer userId;

    @NotNull(message = "房屋所属区域不能为空")
    private Integer area;

    @Length(min = 1,max = 80,message = "地址必须在1~80位之间")
    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotNull(message = "房屋几室不能为空")
    private Integer shi;

    @NotNull(message = "房屋几厅不能为空")
    private Integer ting;

    @NotNull(message = "房屋几卫不能为空")
    private Integer wei;

    @NotNull(message = "房屋面积不能为空")
    private Integer big;

    @Length(min = 1,max = 80,message = "房屋楼层必须在1~80位之间")
    @NotNull(message = "房屋楼层不能为空")
    private String lou;

    @NotNull(message = "房屋层数不能为空")
    private Integer ceng;

    @Length(min = 1,max = 80,message = "房屋朝向不能为空")
    @NotNull(message = "房屋朝向不能为空")
    private String toward;

    @Length(min = 1,max = 80,message = "房屋装修情况不能为空")
    @NotNull(message = "房屋装修情况不能为空")
    private String decorate;

    @Length(min = 1,max = 80,message = "房屋类型情况不能为空")
    @NotNull(message = "房屋类型情况不能为空")
    private String type;

    @Length(min = 1,max = 80,message = "房屋产权情况不能为空")
    @NotNull(message = "房屋产权情况不能为空")
    private String year;

    @NotNull(message = "请输入房屋价格")
    private BigDecimal price;

    @Length(min = 1,max = 80,message = "标题必须在1~80位之间")
    @NotEmpty(message = "标题不能为空")
    private String title;

    @Length(min = 1,max = 200,message = "介绍必须在1~200位之间")
    @NotNull(message = "描述不能为空")
    private String introduction;

    @Length(min = 1,max = 2000,message = "汽车图片url不合法,请联系管理员")
    @NotNull(message = "请上传汽车图片")
    private String carPic;

    @Length(min = 1,max = 50,message = "联系人姓名长度必须在1~50位之间")
    @NotNull(message = "联系人姓名不能为空")
    private String concactName;

    @Length(min = 1,max = 50,message = "联系人电话长度必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String concactPhone;


    public String getConcactPhone() {
        return concactPhone;
    }

    public void setConcactPhone(String concactPhone) {
        this.concactPhone = concactPhone;
    }

    public String getConcactName() {
        return concactName;
    }

    public void setConcactName(String concactName) {
        this.concactName = concactName;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public Integer getCeng() {
        return ceng;
    }

    public void setCeng(Integer ceng) {
        this.ceng = ceng;
    }

    public String getLou() {
        return lou;
    }

    public void setLou(String lou) {
        this.lou = lou;
    }

    public Integer getBig() {
        return big;
    }

    public void setBig(Integer big) {
        this.big = big;
    }

    public Integer getWei() {
        return wei;
    }

    public void setWei(Integer wei) {
        this.wei = wei;
    }

    public Integer getTing() {
        return ting;
    }

    public void setTing(Integer ting) {
        this.ting = ting;
    }

    public Integer getShi() {
        return shi;
    }

    public void setShi(Integer shi) {
        this.shi = shi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}