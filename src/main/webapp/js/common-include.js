function includeHeader() {


    $("#header").html(
        " <div id=\"header-top\">\n" +
        "            <div id=\"headcon\">\n" +
        "                <div id=\"logo\">\n" +
        "                    <a href=\"Index.html\"><img src=\"images/logo.png\" alt=\"\"></a>\n" +
        "                </div>\n" +
        "                <div id=\"adres\">\n" +
        "                    <ul>\n" +
        "                        <li class=\"address\"><span class=\"adrname\">台州</span><small onclick=\"this.className='city_nav city_hover';document.getElementById('city_link').className='city_link city_hovers'\">[切换城市]</small></li>\n" +
        "                        <!-- onmouseover= /vs/onclick= -->\n" +
        "                        <div id=\"city_link\" class=\"city_link\">\n" +
        "                            <a class=\"city_links\" href=\"#\">椒江</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">路桥</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">黄岩</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">临海</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">温岭</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">天台</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">三门</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">仙居</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">玉环</a>\n" +
        "                            <a class=\"city_links\" href=\"#\">金清</a>\n" +
        "                        </div>\n" +
        "                        <li class=\"wheater\">\n" +
        "                            <iframe allowtransparency=\"true\" frameborder=\"0\" width=\"166\" height=\"36\" scrolling=\"no\" src=\"http://tianqi.2345.com/plugin/widget/index.htm?s=3&z=2&t=1&v=0&d=1&bd=0&k=&f=&q=0&e=1&a=0&c=58651&w=166&h=36&align=right\" style=\"margin-top:11px;\"></iframe>\n" +
        "                        </li>\n" +
        "                        <li class=\"time\"></li>\n" +
        "                    </ul>\n" +
        "                </div>\n" +
        "                <div id=\"message\">\n" +
        "                    <ul>\n" +
        "                        <li>\n" +
        "                            <a href=\"Message.html\" target=\"_blank\">\n" +
        "                                <div id=\"infowr\">\n" +
        "                                    <div id=\"inf\">通知</div>\n" +
        "                                    <div id=\"nums\">0</div>\n" +
        "                                </div>\n" +
        "                            </a>\n" +
        "                        </li>\n" +
        "                        <li><a href=\"Login.html\" target=\"_blank\">个人登录</a></li>\n" +
        "                        <li><a href=\"Login.html?type=companyLogIn\" target=\"_blank\">企业登录</a></li>\n" +
        "                        <li><a href=\"Register.html\" target=\"_blank\">新用户注册</a></li>\n" +
        "                        <li><a href=\"\" class=\"issue\" target=\"_blank\">免费发布信息</a></li>\n" +
        "                    </ul>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>"

        +

        " <div id=\"header-banner\">\n" +
        "            <!-- 广告S -->\n" +
        "            <div id=\"banner\">\n" +
        "                <ul>\n" +
        "                    <li><a href=\"Contact.html\" target=\"_blank\"><img src=\"images/banner.png\" alt=\"\"></a></li>\n" +
        "                    <li><a href=\"Contact.html\" target=\"_blank\"> <img src=\"images/banner_2.png\" alt=\"\"></a></li>\n" +
        "                    <li> <a href=\"Contact.html\" target=\"_blank\"><img src=\"images/banner_3.png\" alt=\"\"></a></li>\n" +
        "                </ul>\n" +
        "                <ol>\n" +
        "                    <li></li>\n" +
        "                    <li></li>\n" +
        "                    <li></li>\n" +
        "                </ol>\n" +
        "            </div>\n" +
        "            <!-- 广告E -->\n" +
        "        </div>"

        +

        "<div class=\"clearbox\"></div>"

        +

        " <div id=\"menu\">\n" +
        "        <ul>\n" +
        "            <li><a href=\"Index.html\" target=\"_blank\">全部招聘</a></li>\n" +
        "            <li><a href=\"PartTimeJob.html\" target=\"_blank\">兼职招聘</a></li>\n" +
        "            <li class=\"high-end\"><a href=\"HighJob.html\" target=\"_blank\">高端招聘</a><img src=\"images/new.png\" alt=\"\"></li>\n" +
        "            <li><a href=\"Poerscenter.html\" target=\"_blank\">个人中心</a></li>\n" +
        "            <li><a href=\"BusSear.html\" target=\"_blank\">二手车</a></li>\n" +
        "            <li><a href=\"HousSear.html\" target=\"_blank\">二手房</a></li>\n" +
        "            <li><a href=\"Consult.html\" target=\"_blank\">合作咨询</a></li>\n" +
        "        </ul>\n" +
        "    </div>"
    );
    //
    // <!--调用Luara示例-->
    $("#banner").luara({
        width: "100%",
        height: "313",
        interval: 6000,
        selected: "seleted"
    });

    <!-- 切换城市 -->
    <!-- 显示城市名称 -->
    $('.city_link a').click(function () {
        $(this).parent().each(function () { //移除其余非点中状态
            $('.city_link a').removeClass("special_color");
        });
        $(this).addClass("special_color"); //给所点中的增加样式
        // alert($(this).text()); //输出所点的a的内容
        $(".adrname").text($(this).text());

    });
    $('.city_link').click(function () {
        this.className = 'city_nav city_hovers';
        document.getElementById('city_link').className = 'city_link city_hover'
    });


    var mydate = new Date();
    var str = mydate.getDay();
    var str1 = mydate.getFullYear();
    var str2 = mydate.getMonth() + 1;
    var str3 = mydate.getDate();
    var xq;
    switch (str) {
        case 0:
            xq = "（周日）";
            break;
        case 1:
            xq = "（周一）";
            break;
        case 2:
            xq = "（周二）";
            break;
        case 3:
            xq = "（周三）";
            break;
        case 4:
            xq = "（周四）";
            break;
        case 5:
            xq = "(周五)";
            break;
        case 6:
            xq = "(周六)";
            break;
    }
    $("li.time").html(str1 + "年" + str2 + "月" + str3 + "日" + xq);

}


function includeFoot() {

    $("#footer").html(
        " <div id=\"footer-main\">\n" +
        "            <div id=\"footerlef\"><img src=\"images/photo.png\" alt=\"\">\n" +
        "                <div>客服：0576-82875986</div>\n" +
        "                <div class=\"clearboth\"></div>\n" +
        "            </div>\n" +
        "            <div id=\"footermid\">\n" +
        "              <ul>\n" +
        "                    <li>\n" +
        "                        <div class=\"about\">关于我们</div>\n" +
        "                        <div id=\"aboutmain\">\n" +
        "                            <a href=\"About.html\" target=\"_blank\">关于我们</a>\n" +
        "                            <a href=\"Register.html\" target=\"_blank\">加入我们</a> <a href=\"Contact.html\">联系我们</a><a href=\"javascipt:;\">媒体报道</a>\n" +
        "                        </div>\n" +
        "                    </li>\n" +
        "                    <li>\n" +
        "                        <div class=\"work\">找工作</div>\n" +
        "                        <div id=\"workmain\">\n" +
        "                            <a href=\"Resume.html\" target=\"_blank\">创建简历</a><a href=\"SeaResult.html\" target=\"_blank\">搜索职位</a> <a href=\"PartTimeJob.html\" target=\"_blank\">实习生招聘</a><a href=\"Index.html\" target=\"_blank\">全部招聘</a>\n" +
        "                        </div>\n" +
        "                    </li>\n" +
        "                    <li>\n" +
        "                        <div class=\"talents\">招人才</div>\n" +
        "                        <div id=\"talentsmain\">\n" +
        "                            <a href=\"PostJob.html\">发布工作</a>\n" +
        "                            <a href=\"SeaResult.html\">招聘管理</a> <a href=\"index.html\">招聘职位大全</a><a href=\"SeaResult.html\">创新企业名录</a>\n" +
        "                        </div>\n" +
        "                    </li>\n" +
        "                    <li>\n" +
        "                        <div class=\"help\">消息发布</div>\n" +
        "                        <div id=\"helpmain\">\n" +
        "                            \n" +
        "                            <a href=\"HouRelease.html\">二手房发布</a><a href=\"CarsRelease.html\">二手车发布</a> <a href=\"HousSear.html\">二手房大全</a><a href=\"BusSear.html\">二手车大全</a>\n" +
        "                        </div>\n" +
        "                    </li>\n" +
        "                </ul>\n" +
        "            </div>\n" +
        "            <div id=\"footerrig\">\n" +
        "                <img src=\"images/wc.png\" alt=\"\">\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <div id=\"copy\">ICP经营许可证编号 京ICP证060405号 京ICP备10012705号-12 京公网安备11010502027237号 Copyright 北京五八信息技术有限公司 版权所有</div>\n" +
        "        <div id=\"footer-photo\">\n" +
        "            <img src=\"images/ba.png\" alt=\"\">\n" +
        "            <img src=\"images/wl.png\" alt=\"\">\n" +
        "        </div>"
    )

}

function includeLink() {
    $("#link").html(
        " <div id=\"linkle\">\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/albb.png\" alt=\"\"></a>\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"> <img src=\"images/newyork.png\" alt=\"\"></a>\n" +
        "        </div>\n" +
        "        <div id=\"linkmid\">\n" +
        "            <ul>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/hxbank.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/bm.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/sh.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/zg.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/xzbank.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/rczp.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/bjjz.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "                <li>\n" +
        "                    <a href=\"FrmDea.html\" target=\"_blank\"><img src=\"images/yn.png\" alt=\"\"></a>\n" +
        "                </li>\n" +
        "            </ul>\n" +
        "        </div>\n" +
        "        <div id=\"linkri\">\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"> <img src=\"images/chto.png\" alt=\"\"></a>\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"> <img src=\"images/chd.png\" alt=\"\"></a>\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"> <img src=\"images/yd.png\" alt=\"\"></a>\n" +
        "            <a href=\"FrmDea.html\" target=\"_blank\"> <img src=\"images/cpyc.png\" alt=\"\"></a>\n" +
        "        </div>"
    );
}


function getUserInfo() {

    var str =
        "                            <div class=\"pubmainmenu\">\n" +
        "                                <ul>\n" +
        "                                    <li class=\"pubmainmese\">最近发布</li>\n" +
        "                                    <li>浏览过的</li>\n" +
        "                                </ul>\n" +
        "                                <div class=\"clearbox\"></div>\n" +
        "                            </div>\n" +
        "                            <div class=\"pubmaincon\">\n" +
        "                                <div class=\"maincon\" style=\"display:block\">\n" +
        "                                    <ul>\n" +
        "                                        <li>\n" +
        "                                            <div class=\"maintit\">法国代购求清仓</div>\n" +
        "                                            <div class=\"maintimes\">阅读9</div>\n" +
        "                                        </li>\n" +
        "                                        <li>\n" +
        "                                            <div class=\"maintit\">法国代购求清仓</div>\n" +
        "                                            <div class=\"maintimes\">阅读9</div>\n" +
        "                                        </li>\n" +
        "                                    </ul>\n" +
        "                                </div>\n" +
        "                                <div class=\"maincon\" style=\"display:none\">\n" +
        "                                    <ul>\n" +
        "                                        <li>\n" +
        "                                            <div class=\"maintit\">法国代购求清仓</div>\n" +
        "                                            <div class=\"maintimes\">阅读9</div>\n" +
        "                                        </li>\n" +
        "                                        <li>\n" +
        "                                            <div class=\"maintit\">法国代购求清仓</div>\n" +
        "                                            <div class=\"maintimes\">阅读9</div>\n" +
        "                                        </li>\n" +
        "                                    </ul>\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </div>";

    $("#pub01").html(str);
    $("#pub02").html(str);

}


function getCompanyInfo() {

    var str = "                            <div class=\"pubmainmenu\">\n" +
        "                                <ul>\n" +
        "                                    <li class=\"pubmainmese\">最近发布</li>\n" +
        "                                    <li>浏览过的</li>\n" +
        "                                </ul>\n" +
        "                                <div class=\"clearbox\"></div>\n" +
        "                            </div>\n" +
        "                            <div class=\"pubmaincon\">\n" +
        "                                <div class=\"maincon\" style=\"display:block\">\n" +
        "                                    <ul>\n" +
        "                                        <li>\n" +
        "                                            <ul class=\"jobwant\">\n" +
        "                                                <li style=\"width:300px\">Alibaba</li>\n" +
        "                                                <li style=\"width:500px\">UED/10-20k</li>\n" +
        "                                                <li style=\"width:70px\">今天</li>\n" +
        "                                                <li class=\"times\" style=\"width:250px\">被查看36次</li>\n" +
        "                                            </ul>\n" +
        "                                        </li>\n" +
        "                                        <li>\n" +
        "                                            <ul class=\"jobwant\">\n" +
        "                                                <li style=\"width:300px\">Alibaba</li>\n" +
        "                                                <li style=\"width:500px\">UED/10-20k</li>\n" +
        "                                                <li style=\"width:70px\">今天</li>\n" +
        "                                                <li class=\"times\" style=\"width:250px\">被查看36次</li>\n" +
        "                                            </ul>\n" +
        "                                        </li>\n" +
        "                                    </ul>\n" +
        "                                </div>\n" +
        "                                <div class=\"maincon\" style=\"display:none\">\n" +
        "                                    <ul>\n" +
        "                                        <li>\n" +
        "                                            <ul class=\"jobwant\">\n" +
        "                                                <li style=\"width:300px\">小飞</li>\n" +
        "                                                <li style=\"width:500px\">UED/10-20k</li>\n" +
        "                                                <li style=\"width:70px\">今天</li>\n" +
        "                                                <li class=\"times\" style=\"width:250px\">查看简历</li>\n" +
        "                                            </ul>\n" +
        "                                        </li>\n" +
        "                                        <li class=\"saw\">\n" +
        "                                            <ul class=\"jobwant\">\n" +
        "                                                <li style=\"width:300px\">小飞</li>\n" +
        "                                                <li style=\"width:500px\">UED/10-20k</li>\n" +
        "                                                <li style=\"width:70px\">今天</li>\n" +
        "                                                <li class=\"times\" style=\"width:250px\">已查看</li>\n" +
        "                                            </ul>\n" +
        "                                        </li>\n" +
        "                                    </ul>\n" +
        "                                </div>\n" +
        "                            </div>";

    $("#pub03").html(str);


}


function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)return r[2];
    return null;
}


$.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};

