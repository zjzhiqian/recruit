//职位类别
var jobArr = ["人力", "行政", "管理", "销售", "客服", "采购", "淘宝", "市场", "媒介", "广告", "设计", "生产", "物流", "质控", "汽车", "网络", "通信", "电子", "法律", "教育", "翻译", "出版", "财会", "金融", "保险", "医疗", "制药", "环保", "建筑", "装修", "物业", "其他"];
var jobArrJson = {1:"人力",2:"行政",3:"管理",4:"销售",5:"客服",6:"采购",7:"淘宝",8:"市场",9:"媒介",10:"广告",11:"设计",12:"生产",13:"物流",14:"质控",15:"汽车",16:"网络",17:"通信",18:"电子",19:"法律",20:"教育",21:"翻译",22:"出版",23:"财会",24:"金融",25:"保险",26:"医疗",27:"制药",28:"环保",29:"建筑",30:"装修",31:"物业",32:"其他"};
var jobArrSearch = ["不限", "人力", "行政", "管理", "销售", "客服", "采购", "淘宝", "市场", "媒介", "广告", "设计", "生产", "物流", "质控", "汽车", "网络", "通信", "电子", "法律", "教育", "翻译", "出版", "财会", "金融", "保险", "医疗", "制药", "环保", "建筑", "装修", "物业", "其他"];
//工作年限
var yearArr = ["不限", "应届", "1年", "3年", "3年", "3-5年", "5-10年", "10年以上"];
var yearArrJson = {1: "应届", 2: "1年", 3: "3年", 4: "3年", 5: "3-5年", 6: "5-10年", 7: "10年以上"};
//学历
var studyArr = ["不限", "小学", "初中", "职高", "高中", "专科", "本科", "硕士"];
var StudyArrJson = {1: "小学", 2: "初中", 3: "职高", 4: "高中", 5: "专科", 6: "本科", 7: "硕士"};
//工作区域
var workArr = ["不限", "椒江", "路桥", "黄岩", "临海", "温岭", "天台", "三门", "仙居", "玉环", "金清"];
var workArrJson = {1:"不限",2:"椒江",3:"路桥",4:"黄岩",5:"临海",6:"温岭",7:"天台",8:"三门",9:"仙居",10:"玉环",11:"金清"};
//期望月薪
var moneyArr = ["不限", "2000以下", "2000~3000", "3000~4000", "4000~5000", "5000~6000", "6000~7000", "7000~8000", "8000~9000", "9000~10000", "1万以上"];
var moneyArrJson = {1:"不限",2:"2000以下",3:"2000~3000",4:"3000~4000",5:"4000~5000",6:"5000~6000",7:"6000~7000",8:"7000~8000",9:"8000~9000",10:"9000~10000",11:"1万以上"};
//二手车商家店铺类型
var carStoreArr = ["经济公司", "s店", "代理中介", "个人经纪"];
var carStoreArrJson = {
    1: "经济公司",
    2: "s店",
    3: "代理中介",
    4: "个人经纪"
};


//省份
var ProvinceArr = ["浙江省", "北京市", "天津市", "上海市", "重庆市", "河北省", "河南省", "云南省", "辽宁省", "黑龙江省", "湖南省", "安徽省", "山东省", "新疆维吾尔", "江苏省",
    "江西省", "湖北省", "广西壮族", "甘肃省", "山西省", "内蒙古", "陕西省", "吉林省", "福建省", "贵州省", "广东省", "青海省", "西藏", "四川省", "宁夏回族", "海南省", "台湾省"];
//
var carTypeArr = [
    "奥迪", "别克", "宝马", "比亚迪", "标致", "奔驰", "本田", "北汽绅宝", "北汽威旺", "宝骏", "保时捷", "北汽制造", "北汽幻速", "北京奔腾", "北汽新能源", "长安商用", "长安长城",
    "大众", "东风", "东南", "道奇", "DS", "福特", "丰田", "福田", "菲亚特", "福汽启腾", "广汽传祺", "观致", "广汽吉奥", "哈弗", "海马"
    , "Jeep", "江淮", "捷豹", "吉利汽车", "金杯江铃", "凯迪拉克", "开瑞", "克莱斯勒", "铃木雷诺", "路虎,", "雷克萨斯", "陆风", "力帆汽车", "力帆", "莲花汽车", "理念", "猎豹汽车",
    "马自达", "MG", "玛莎拉蒂", "纳智捷", "讴歌", "欧宝", "起亚", "奇瑞", "启辰", "荣威", "日产", "瑞麒", "斯柯达", "smart", "三菱", "斯巴鲁", "萨博思铭", "特斯拉",
    "五菱汽车", "沃尔沃", "威麟", "雪佛兰", "雪铁龙", "现代", "英菲尼迪一汽", "野马汽车", "中华", "众泰"
];


var carColorJson = {
    "1": "黑",
    "2": "白",
    "3": "银",
    "4": "灰",
    "5": "红",
    "6": "蓝",
    "7": "黄",
    "8": "棕",
    "9": "绿",
    "10": "橙",
    "11": "紫",
    "12": "香槟",
    "13": "金",
    "14": "粉红",
    "15": "其他"
};


var carTypeJson = {
    "奥迪": 1,
    "别克": 2,
    "宝马": 3,
    "比亚迪": 4,
    "标致": 5,
    "奔驰": 6,
    "本田": 7,
    "北汽绅宝": 8,
    "北汽威旺": 9,
    "宝骏": 10,
    "保时捷": 11,
    "北汽制造": 12,
    "北汽幻速": 13,
    "北京奔腾": 14,
    "北汽新能源": 15,
    "长安商用": 16,
    "长安长城": 17,
    "大众": 18,
    "东风": 19,
    "东南": 20,
    "道奇": 21,
    "DS": 22,
    "福特": 23,
    "丰田": 24,
    "福田": 25,
    "菲亚特": 26,
    "福汽启腾": 27,
    "广汽传祺": 28,
    "观致": 29,
    "广汽吉奥": 30,
    "哈弗": 31,
    "海马": 32,
    "Jeep": 33,
    "江淮": 34,
    "捷豹": 35,
    "吉利汽车": 36,
    "金杯江铃": 37,
    "凯迪拉克": 38,
    "开瑞": 39,
    "克莱斯勒": 40,
    "铃木雷诺": 41,
    "路虎,": 42,
    "雷克萨斯": 43,
    "陆风": 44,
    "力帆汽车": 45,
    "力帆": 46,
    "莲花汽车": 47,
    "理念": 48,
    "猎豹汽车": 49,
    "马自达": 50,
    "MG": 51,
    "玛莎拉蒂": 52,
    "纳智捷": 53,
    "讴歌": 54,
    "欧宝": 55,
    "起亚": 56,
    "奇瑞": 57,
    "启辰": 58,
    "荣威": 59,
    "日产": 60,
    "瑞麒": 61,
    "斯柯达": 62,
    "smart": 63,
    "三菱": 64,
    "斯巴鲁": 65,
    "萨博思铭": 66,
    "特斯拉": 67,
    "五菱汽车": 68,
    "沃尔沃": 69,
    "威麟": 70,
    "雪佛兰": 71,
    "雪铁龙": 72,
    "现代": 73,
    "英菲尼迪一汽": 74,
    "野马汽车": 75,
    "中华": 76,
    "众泰": 77
};
var carTypeJson2 = {
    0: "未知",
    1: "奥迪",
    2: "别克",
    3: "宝马",
    4: "比亚迪",
    5: "标致",
    6: "奔驰",
    7: "本田",
    8: "北汽绅宝",
    9: "北汽威旺",
    10: "宝骏",
    11: "保时捷",
    12: "北汽制造",
    13: "北汽幻速",
    14: "北京奔腾",
    15: "北汽新能源",
    16: "长安商用",
    17: "长安长城",
    18: "大众",
    19: "东风",
    20: "东南",
    21: "道奇",
    22: "DS",
    23: "福特",
    24: "丰田",
    25: "福田",
    26: "菲亚特",
    27: "福汽启腾",
    28: "广汽传祺",
    29: "观致",
    30: "广汽吉奥",
    31: "哈弗",
    32: "海马",
    33: "Jeep",
    34: "江淮",
    35: "捷豹",
    36: "吉利汽车",
    37: "金杯江铃",
    38: "凯迪拉克",
    39: "开瑞",
    40: "克莱斯勒",
    41: "铃木雷诺",
    42: "路虎,",
    43: "雷克萨斯",
    44: "陆风",
    45: "力帆汽车",
    46: "力帆",
    47: "莲花汽车",
    48: "理念",
    49: "猎豹汽车",
    50: "马自达",
    51: "MG",
    52: "玛莎拉蒂",
    53: "纳智捷",
    54: "讴歌",
    55: "欧宝",
    56: "起亚",
    57: "奇瑞",
    58: "启辰",
    59: "荣威",
    60: "日产",
    61: "瑞麒",
    62: "斯柯达",
    63: "smart",
    64: "三菱",
    65: "斯巴鲁",
    66: "萨博思铭",
    67: "特斯拉",
    68: "五菱汽车",
    69: "沃尔沃",
    70: "威麟",
    71: "雪佛兰",
    72: "雪铁龙",
    73: "现代",
    74: "英菲尼迪一汽",
    75: "野马汽车",
    76: "中华",
    77: "众泰"
};