//职位类别
var jobArr = ["人力", "行政", "管理", "销售", "客服", "采购", "淘宝", "市场", "媒介", "广告", "设计", "生产", "物流", "质控", "汽车", "网络", "通信", "电子", "法律", "教育", "翻译", "出版", "财会", "金融", "保险", "医疗", "制药", "环保", "建筑", "装修", "物业", "其他"];
var jobArrSearch = ["不限", "人力", "行政", "管理", "销售", "客服", "采购", "淘宝", "市场", "媒介", "广告", "设计", "生产", "物流", "质控", "汽车", "网络", "通信", "电子", "法律", "教育", "翻译", "出版", "财会", "金融", "保险", "医疗", "制药", "环保", "建筑", "装修", "物业", "其他"];
//工作年限
var yearArr = ["不限", "应届", "1年", "3年", "3年", "3-5年", "5-10年", "10年以上"];
//学历
var studyArr = ["不限", "小学", "初中", "职高", "高中", "专科", "本科", "硕士"];
//工作区域
var workArr = ["不限", "椒江", "路桥", "黄岩", "临海", "温岭", "天台", "三门", "仙居", "玉环", "金清"];
//期望月薪
var moneyArr = ["不限", "2000以下", "2000~3000", "3000~4000", "4000~5000", "5000~6000", "6000~7000", "7000~8000", "8000~9000", "9000~10000", "1万以上"];
//二手车商家店铺类型
var carStoreArr = ["经济公司", "s店", "代理中介", "个人经纪"];
//省份
var ProvinceArr = ["浙江省", "北京市", "天津市", "上海市", "重庆市", "河北省", "河南省", "云南省", "辽宁省", "黑龙江省", "湖南省", "安徽省", "山东省", "新疆维吾尔", "江苏省",
    "江西省", "湖北省", "广西壮族", "甘肃省", "山西省", "内蒙古", "陕西省", "吉林省", "福建省", "贵州省", "广东省", "青海省", "西藏", "四川省", "宁夏回族", "海南省", "台湾省"];
//
var carTypeArr = [
    "奥迪", "别克", "宝马", "比亚迪", "标致", "奔驰", "本田", "北汽绅宝", "北汽威旺", "宝骏", "保时捷", "北汽制造", "北汽幻速", "北京奔腾", "北汽新能源", "长安商用", "长安长城",
    "大众", "东风", "东南", "道奇", "DS", "福特", "丰田", "福田", "菲亚特", "福汽启腾", "广汽传祺", "观致", "广汽吉奥", "哈弗","海马"
    , "Jeep", "江淮", "捷豹", "吉利汽车", "金杯江铃", "凯迪拉克", "开瑞","克莱斯勒", "铃木雷诺", "路虎,", "雷克萨斯", "陆风", "力帆汽车", "力帆","莲花汽车", "理念", "猎豹汽车",
    "马自达", "MG", "玛莎拉蒂", "纳智捷", "讴歌", "欧宝", "起亚", "奇瑞", "启辰", "荣威","日产", "瑞麒", "斯柯达", "smart", "三菱", "斯巴鲁", "萨博思铭", "特斯拉",
    "五菱汽车", "沃尔沃", "威麟", "雪佛兰", "雪铁龙", "现代", "英菲尼迪一汽", "野马汽车", "中华", "众泰"
];

var carTypeJson = {"奥迪":1,"别克":2,"宝马":3,"比亚迪":4,"标致":5,"奔驰":6,"本田":7,"北汽绅宝":8,"北汽威旺":9,"宝骏":10,"保时捷":11,"北汽制造":12,"北汽幻速":13,"北京奔腾":14,"北汽新能源":15,"长安商用":16,"长安长城":17,"大众":18,"东风":19,"东南":20,"道奇":21,"DS":22,"福特":23,"丰田":24,"福田":25,"菲亚特":26,"福汽启腾":27,"广汽传祺":28,"观致":29,"广汽吉奥":30,"哈弗":31,"海马":32,"Jeep":33,"江淮":34,"捷豹":35,"吉利汽车":36,"金杯江铃":37,"凯迪拉克":38,"开瑞":39,"克莱斯勒":40,"铃木雷诺":41,"路虎,":42,"雷克萨斯":43,"陆风":44,"力帆汽车":45,"力帆":46,"莲花汽车":47,"理念":48,"猎豹汽车":49,"马自达":50,"MG":51,"玛莎拉蒂":52,"纳智捷":53,"讴歌":54,"欧宝":55,"起亚":56,"奇瑞":57,"启辰":58,"荣威":59,"日产":60,"瑞麒":61,"斯柯达":62,"smart":63,"三菱":64,"斯巴鲁":65,"萨博思铭":66,"特斯拉":67,"五菱汽车":68,"沃尔沃":69,"威麟":70,"雪佛兰":71,"雪铁龙":72,"现代":73,"英菲尼迪一汽":74,"野马汽车":75,"中华":76,"众泰":77};
