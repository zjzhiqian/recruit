package com.hzq.car;

import com.alibaba.fastjson.JSON;
import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.SecondCar;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * CarTest
 * Created by hzq on 16/11/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CarTest {
    @Autowired
    SecondCarMapper secondCarMapper;


    private static final CloseableHttpClient client = HttpClients.custom().build();
    private static final String TOKEN_URL_TEST = "http://42.96.134.15:20009/oauth/AccessToken/token.json";
    private static final String TOKEN_URL_PROD = "https://open.souche.com/oauth/AccessToken/token.json";
    private static final String DATA_URL_TEST = "http://42.96.134.15:20009/api/car/queryCar.json";
    private static final String DATA_URL_PROD = "https://open.souche.com/api/car/queryCar.json";
    private static final boolean isProd = true;
    private static Logger logger = LoggerFactory.getLogger(CarTest.class);


    /**
     * 获取token接口
     */
    private String getToken() throws IOException {
        String url = TOKEN_URL_TEST;
        List<NameValuePair> params = new ArrayList<>();
        if (isProd) {
            url = TOKEN_URL_PROD;
            params.add(new BasicNameValuePair("username", "cx0576"));
            params.add(new BasicNameValuePair("password", "D9C67CBD875F94BFC0F4C16297AEC2AE"));
            params.add(new BasicNameValuePair("client_id", "cx0576"));
            params.add(new BasicNameValuePair("client_secret", "8114a135-8fc2-4b72-8b34-fd2fc210c722"));
            params.add(new BasicNameValuePair("grant_type", "password"));
        } else {
            params.add(new BasicNameValuePair("username", "cx0576"));
            params.add(new BasicNameValuePair("password", "cx0576"));
            params.add(new BasicNameValuePair("client_id", "cx0576"));
            params.add(new BasicNameValuePair("client_secret", "227b39f8-9cd4-4d4b-b74c-7ef41af2f238"));
            params.add(new BasicNameValuePair("grant_type", "password"));
        }
        String s = sendAndGetResponse(url, params);
        Map map = JSON.parseObject(s, Map.class);
        return (String) ((Map) map.get("data")).get("access_token");
    }

    @Test
    public void test02() throws IOException {
        String token = getToken();
        logger.warn("getToken: {}", token);
    }

    @Test
    public void test01() throws IOException, ParseException {


//        String token = getToken();
//        logger.warn("getToken: {}", token);
        String token = "932039219c9b5bf0ab65b9b50023ee56";
        String url = DATA_URL_TEST;
        if (isProd) url = DATA_URL_PROD;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2017-03-07"); //跑完后 把这个时间改当天时间
        calendar.setTime(parse);
//        calendar.add(Calendar.MONTH, -6);
        Date grabDate = calendar.getTime();

//        Calendar NOW = Calendar.getInstance();
//        NOW.add(Calendar.DATE, -2);

        while (grabDate.before(new Date())) {
            try {
                sendAndSave(token, grabDate, url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            calendar.add(Calendar.DATE, 1);
            grabDate = calendar.getTime();
        }

    }


    /**
     * 发送post请求,并返回json结果
     */
    private String sendAndGetResponse(String url, List<NameValuePair> params) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        StringBuilder messageBuilder = new StringBuilder("\n");
        messageBuilder.append(post.getMethod());
        messageBuilder.append("  ");
        messageBuilder.append(post.getURI());
        messageBuilder.append("  ");
        HttpEntity entity = post.getEntity();
        String body = IOUtils.toString(entity.getContent());
        List<NameValuePair> parse = URLEncodedUtils.parse(body, ContentType.get(entity).getCharset());
        parse.stream().forEach(pair -> {
            messageBuilder.append(pair.getName());
            messageBuilder.append(":");
            messageBuilder.append(pair.getValue());
            messageBuilder.append(" ");
        });
        logger.warn("send httpRequest: {}", messageBuilder.toString());
        CloseableHttpResponse response = client.execute(post);
        InputStream content = response.getEntity().getContent();
        String s = IOUtils.toString(content);
        response.close();
        logger.warn("get httpResponse: \n{}", s);
        return s;
    }

    /**
     * 转换日期
     */
    private String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }


    /**
     * 获取总页数
     */
    private Integer getPages(String token, Date date, String url) throws IOException, ParseException {
        Map map = getData(token, date, url, 0);
        Map result = (Map) (((Map) map.get("data")).get("pager"));
        return (Integer) result.get("total_pages");
    }

    /**
     * 获取每页数据
     */
    private Map getData(String token, Date date, String url, Integer pageIndex) throws ParseException, IOException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("access_token", token));
        params.add(new BasicNameValuePair("timestamp", formatIso8601Date(new Date())));
        params.add(new BasicNameValuePair("signNonce", new Random().nextInt(1000000) + ""));
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String str = format + " 00:00:00";
        String str2 = format + " 23:59:59";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = fmt.parse(str);
        Date date2 = fmt.parse(str2);
        params.add(new BasicNameValuePair("startQueryTime", formatIso8601Date(date1)));
        params.add(new BasicNameValuePair("endQueryTime", formatIso8601Date(date2)));
        params.add(new BasicNameValuePair("pageIndex", pageIndex.toString()));
        params.add(new BasicNameValuePair("pageSize", "20"));
        params.add(new BasicNameValuePair("carDealerType", "all"));
        params.add(new BasicNameValuePair("province", "浙江"));
        params.add(new BasicNameValuePair("city", "台州"));
        String s = sendAndGetResponse(url, params);
        Map map = JSON.parseObject(s, Map.class);
        if (!"10000".equals(map.get("code")))
            throw new RuntimeException("获取数据失败 " + url + "  " + date.toString() + " pageIndex" + pageIndex);
        return map;
    }


    private void sendAndSave(String token, Date date, String url) throws ParseException, IOException {
        Integer pages = getPages(token, date, url);
        for (int i = 0; i <= pages; i++) {
            Map map = getData(token, date, url, i);
            List<Map> o = (List<Map>) ((Map) ((Map) map.get("data")).get("pager")).get("items");

            o.stream().filter(secondCar -> "在售".equals(secondCar.get("status")) && "上架".equals(secondCar.get("upShelf")))
                    .forEach(data1 -> {
                        SecondCar car = new SecondCar();
                        car.setUserId(-1);
                        car.setMerchantId(0);
                        car.setIsMerchant(0);
                        //汽车品牌
                        String brand = (String) data1.get("brand");
                        if (brand != null) {
                            Integer type = getCarType(brand);
                            car.setType(type);
                        }
                        //汽车标题
                        String model = (String) data1.get("model");
                        car.setTitle(model);
                        //汽车行程 journey
                        String mileage = (String) data1.get("mileage");
                        BigDecimal journey = new BigDecimal(mileage).divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP);
                        car.setJourney(journey);

                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
                        //首次上牌时间
                        String firstLicensePlateDate = (String) data1.get("firstLicensePlateDate");
                        try {
                            firstLicensePlateDate = fmt2.format(fmt.parse(firstLicensePlateDate));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        car.setLicenseTime(firstLicensePlateDate);

                        //购买时间
                        car.setBuyTime(firstLicensePlateDate);

                        //交强险到期时间
                        String insuranceExpiresDate = (String) data1.get("insuranceExpiresDate");
                        try {
                            if (insuranceExpiresDate != null && !"null".equals(insuranceExpiresDate)) {
                                insuranceExpiresDate = fmt2.format(fmt.parse(insuranceExpiresDate));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        car.setInsuranceDeadtime(insuranceExpiresDate);
                        //描述
                        String carDescribe = (String) data1.get("carDescribe");
                        car.setIntroduction(carDescribe);
                        //是否运营 nature
                        Integer usage = 0;
                        String useType = (String) data1.get("useType");
                        if ("营运".equals(useType)) usage = 1;
                        car.setNature(usage.toString());
                        //排气量 exhaust
                        BigDecimal engineVolume = new BigDecimal((String) data1.get("engineVolume"));
                        car.setExhaust(engineVolume);
                        //汽车图片 carPicture
                        List<String> carPicture = (List<String>) data1.get("carPicture");
                        if (carPicture.size() > 0) {
                            car.setPictue(carPicture.get(0));
                            StringJoiner joiner = new StringJoiner(",");
                            carPicture.forEach(joiner::add);
                            car.setCarPic(joiner.toString());
                        }
                        //汽车售价 salePrice
                        Integer salePrice = Integer.parseInt((String) data1.get("salePrice"));
                        BigDecimal price = new BigDecimal(salePrice).divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP);
                        car.setPrice(price);
                        //使用年限枚举  firstLicensePlateDate
                        Integer year = Integer.parseInt(firstLicensePlateDate.substring(0, 4));
                        Integer toSet = 0;
                        int now = 2017 - year;
                        if (now <= 1) toSet = 0;
                        if (now > 1 && now <= 3) toSet = 1;
                        if (now > 3 && now <= 5) toSet = 3;
                        if (now > 5 && now <= 8) toSet = 4;
                        if (now > 8 && now <= 10) toSet = 5;
                        if (now > 10) toSet = 6;
                        car.setYear(toSet);
                        //车身颜色
                        String color = (String) data1.get("color");
                        Integer resultColor = 15;
                        if (color != null) {
                            if (color.contains("黑")) resultColor = 1;
                            if (color.contains("白")) resultColor = 2;
                            if (color.contains("银")) resultColor = 3;
                            if (color.contains("灰")) resultColor = 4;
                            if (color.contains("红")) resultColor = 5;
                            if (color.contains("蓝")) resultColor = 6;
                            if (color.contains("黄")) resultColor = 7;
                            if (color.contains("棕")) resultColor = 8;
                            if (color.contains("绿")) resultColor = 9;
                            if (color.contains("橙")) resultColor = 10;
                            if (color.contains("紫")) resultColor = 11;
                            if (color.contains("香槟")) resultColor = 12;
                            if (color.contains("金")) resultColor = 13;
                            if (color.contains("粉红")) resultColor = 14;
                        }
                        car.setColor(resultColor);
                        //联系人,联系电话 contactPerson  phone
                        String contactPerson = (String) data1.get("contactPerson");
                        String phone = (String) data1.get("phone");
                        car.setConcactName(contactPerson);
                        car.setConcactPhone(phone);
                        //过户次数
                        Integer transferNumber = (Integer) data1.get("transferNumber");
                        car.setTimes(transferNumber);
                        //创建时间
                        try {
                            car.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) data1.get("upShelfDate")));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            secondCarMapper.insert(car);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });


        }

    }

    @SuppressWarnings("all")
    private Integer getCarType(String type) {

        String carType =
                "  {\"奥迪\": 1,\n" +
                        "    \"别克\": 2,\n" +
                        "    \"宝马\": 3,\n" +
                        "    \"比亚迪\": 4,\n" +
                        "    \"标致\": 90,\n" +
                        "    \"奔驰\": 6,\n" +
                        "    \"本田\": 7,\n" +
                        "    \"北汽绅宝\": 8,\n" +
                        "    \"北汽威旺\": 88,\n" +
                        "    \"宝骏\": 10,\n" +
                        "    \"保时捷\": 11,\n" +
                        "    \"北汽制造\": 12,\n" +
                        "    \"北汽幻速\": 87,\n" +
                        "    \"北京奔腾\": 14,\n" +
                        "    \"北汽新能源\": 15,\n" +
                        "    \"长安商用\": 96,\n" +
                        "    \"长安长城\": 17,\n" +
                        "    \"大众\": 18,\n" +
                        "    \"东风\": 19,\n" +
                        "    \"东南\": 20,\n" +
                        "    \"道奇\": 21,\n" +
                        "    \"DS\": 22,\n" +
                        "    \"福特\": 23,\n" +
                        "    \"丰田\": 24,\n" +
                        "    \"福田\": 25,\n" +
                        "    \"菲亚特\": 26,\n" +
                        "    \"福汽启腾\": 27,\n" +
                        "    \"广汽传祺\": 28,\n" +
                        "    \"观致\": 29,\n" +
                        "    \"广汽吉奥\": 30,\n" +
                        "    \"哈弗\": 31,\n" +
                        "    \"海马\": 32,\n" +
                        "    \"Jeep\": 33,\n" +
                        "    \"江淮\": 34,\n" +
                        "    \"捷豹\": 35,\n" +
                        "    \"吉利汽车\": 36,\n" +
                        "    \"金杯江铃\": 37,\n" +
                        "    \"凯迪拉克\": 38,\n" +
                        "    \"开瑞\": 39,\n" +
                        "    \"克莱斯勒\": 40,\n" +
                        "    \"铃木雷诺\": 41,\n" +
                        "    \"路虎,\": 42,\n" +
                        "    \"雷克萨斯\": 43,\n" +
                        "    \"陆风\": 44,\n" +
                        "    \"力帆汽车\": 45,\n" +
                        "    \"力帆\": 46,\n" +
                        "    \"莲花汽车\": 47,\n" +
                        "    \"理念\": 48,\n" +
                        "    \"猎豹汽车\": 49,\n" +
                        "    \"马自达\": 50,\n" +
                        "    \"MG\": 51,\n" +
                        "    \"玛莎拉蒂\": 52,\n" +
                        "    \"纳智捷\": 53,\n" +
                        "    \"讴歌\": 54,\n" +
                        "    \"欧宝\": 55,\n" +
                        "    \"起亚\": 56,\n" +
                        "    \"奇瑞\": 57,\n" +
                        "    \"启辰\": 58,\n" +
                        "    \"荣威\": 59,\n" +
                        "    \"日产\": 60,\n" +
                        "    \"瑞麒\": 169,\n" +
                        "    \"斯柯达\": 62,\n" +
                        "    \"smart\": 63,\n" +
                        "    \"三菱\": 64,\n" +
                        "    \"斯巴鲁\": 65,\n" +
                        "    \"萨博\": 66,\n" +
                        "    \"特斯拉\": 67,\n" +
                        "    \"五菱汽车\": 68,\n" +
                        "    \"沃尔沃\": 69,\n" +
                        "    \"威麟\": 70,\n" +
                        "    \"雪佛兰\": 189,\n" +
                        "    \"雪铁龙\": 72,\n" +
                        "    \"现代\": 73,\n" +
                        "    \"英菲尼迪一汽\": 74,\n" +
                        "    \"野马汽车\": 75,\n" +
                        "    \"中华\": 76,\n" +
                        "    \"众泰\": 77,\n" +
                        "    \"AC Schnitzer\": 78,\n" +
                        "    \"ALPINA\": 79,\n" +
                        "    \"Arash\": 80,\n" +
                        "    \"ARCFOX\": 81,\n" +
                        "    \"阿尔法罗密欧 \": 82,\n" +
                        "    \"阿斯顿·马丁\": 83,\n" +
                        "    \"安凯客车\": 84,\n" +
                        "    \"巴博斯\": 85,\n" +
                        "    \"宝沃北京\": 86,\n" +
                        "    \"比速汽车\": 89,\n" +
                        "    \"宾利\": 91,\n" +
                        "    \"布加迪\": 92,\n" +
                        "    \"Caterham\": 93,\n" +
                        "    \"昌河\": 94,\n" +
                        "    \"成功汽车\": 95,\n" +
                        "    \"长城\": 97,\n" +
                        "    \"长江EV\": 98,\n" +
                        "    \"Dacia\": 99,\n" +
                        "    \"DMC\": 100,\n" +
                        "    \"大发\": 101,\n" +
                        "    \"东风风度\": 102,\n" +
                        "    \"东风风光\": 103,\n" +
                        "    \"东风风行\": 104,\n" +
                        "    \"东风风神\": 105,\n" +
                        "    \"东风小康\": 106,\n" +
                        "    \"Faraday\": 107,\n" +
                        "    \"Future\": 108,\n" +
                        "    \"Fisker\": 109,\n" +
                        "    \"法拉利\": 110,\n" +
                        "    \"福迪\": 111,\n" +
                        "    \"福田乘用车\": 112,\n" +
                        "    \"GLM\": 113,\n" +
                        "    \"GMC\": 114,\n" +
                        "    \"Gumpert\": 115,\n" +
                        "    \"光冈\": 116,\n" +
                        "    \"Hennessey\": 117,\n" +
                        "    \"哈飞\": 118,\n" +
                        "    \"海格\": 119,\n" +
                        "    \"汉腾汽车\": 120,\n" +
                        "    \"悍马\": 121,\n" +
                        "    \"恒天\": 122,\n" +
                        "    \"红旗\": 123,\n" +
                        "    \"华凯\": 124,\n" +
                        "    \"华利\": 125,\n" +
                        "    \"华普\": 126,\n" +
                        "    \"华骐\": 127,\n" +
                        "    \"华颂\": 128,\n" +
                        "    \"华泰\": 129,\n" +
                        "    \"华泰新能源\": 130,\n" +
                        "    \"黄海霍顿\": 131,\n" +
                        "    \"江铃集团轻汽\": 132,\n" +
                        "    \"江铃集团新能源\": 133,\n" +
                        "    \"金龙\": 134,\n" +
                        "    \"金旅\": 135,\n" +
                        "    \"九龙\": 136,\n" +
                        "    \"KTM\": 137,\n" +
                        "    \"卡尔森\": 138,\n" +
                        "    \"卡威\": 139,\n" +
                        "    \"凯佰赫\": 140,\n" +
                        "    \"凯翼\": 141,\n" +
                        "    \"科尼赛克\": 142,\n" +
                        "    \"LeSEE\": 143,\n" +
                        "    \"LYNK&CO\": 144,\n" +
                        "    \"兰博基尼\": 145,\n" +
                        "    \"蓝旗亚\": 146,\n" +
                        "    \"朗世\": 147,\n" +
                        "    \"劳斯莱斯\": 148,\n" +
                        "    \"雷诺\": 149,\n" +
                        "    \"林肯\": 150,\n" +
                        "    \"铃木\": 151,\n" +
                        "    \"领志\": 152,\n" +
                        "    \"路特斯\": 153,\n" +
                        "    \"MINI\": 154,\n" +
                        "    \"迈巴赫\": 155,\n" +
                        "    \"迈凯伦\": 156,\n" +
                        "    \"摩根\": 157,\n" +
                        "    \"nanoFLOWCELL\": 158,\n" +
                        "    \"Noble\": 159,\n" +
                        "    \"南京金龙\": 160,\n" +
                        "    \"讴朗\": 161,\n" +
                        "    \"帕加尼\": 162,\n" +
                        "    \"佩奇奥\": 163,\n" +
                        "    \"前途\": 164,\n" +
                        "    \"Rezvani\": 165,\n" +
                        "    \"Rimac\": 166,\n" +
                        "    \"Rinspeed\": 167,\n" +
                        "    \"如虎\": 168,\n" +
                        "    \"Scion\": 170,\n" +
                        "    \"SPIRRA\": 171,\n" +
                        "    \"SSC\": 172,\n" +
                        "    \"SWM斯威汽车\": 173,\n" +
                        "    \"赛麟\": 174,\n" +
                        "    \"上海\": 175,\n" +
                        "    \"上汽大通\": 176,\n" +
                        "    \"世爵\": 177,\n" +
                        "    \"双环\": 178,\n" +
                        "    \"双龙\": 179,\n" +
                        "    \"思铭\": 180,\n" +
                        "    \"腾势\": 181,\n" +
                        "    \"WEY\": 182,\n" +
                        "    \"威兹曼\": 183,\n" +
                        "    \"潍柴英致\": 184,\n" +
                        "    \"蔚来\": 185,\n" +
                        "    \"沃克斯豪尔\": 186,\n" +
                        "    \"五十铃\": 187,\n" +
                        "    \"西雅特\": 188,\n" +
                        "    \"一汽\": 190,\n" +
                        "    \"依维柯\": 191,\n" +
                        "    \"永源\": 192,\n" +
                        "    \"游侠驭胜\": 193,\n" +
                        "    \"Zenvo\": 194,\n" +
                        "    \"之诺\": 195,\n" +
                        "    \"知豆\": 196,\n" +
                        "    \"中兴\": 197\n" +
                        "}\n";


        Map map = JSON.parseObject(carType, Map.class);
        Object o = map.get(type);
        Integer result = -1;
        if (o != null)
            result = (Integer) o;
        return result;
    }
}
