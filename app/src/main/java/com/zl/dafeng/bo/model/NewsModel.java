package com.zl.dafeng.bo.model;

import java.util.List;

/**
 * <新闻>
 *
 * @author DaFeng 2017-02-13 13:41
 * @email 598787663@qq.com
 */

public class NewsModel {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"pagebean":{"allPages":142,"contentlist":[{"pubDate":"2017-02-13 14:28:58","havePic":true,"title":"恒大将开始实施末位淘汰制 外援将开始只减不增","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/Y5Aj-fyamkqa5898097.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ger2-fyamvns5086360.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/pIrm-fyamkqa5898205.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/On7g-fyamkqa5898248.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/5U_z-fyamkpy9117879.jpg"}],"desc":"　　2月13日，广州恒大淘宝足球俱乐部在恒大中心召开新赛季全体会议，同时也是恒大足球系统2017年第一次全体会议。会议由恒大集团主管足球的副总裁刘永灼主持。恒大集团董事局主席许家印向球队提出2017赛季要夺取中超七连冠、蝉联足协杯和超级杯冠军，再夺亚冠冠军，实现四冠王，....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7470532.shtml"},{"pubDate":"2017-02-13 13:00:01","havePic":true,"title":"许家印提恒大2017目标四冠 2020全华班","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://inews.gtimg.com/newsapp_match/0/1133843341/0"}],"desc":"许家印明确提出球队的目标，2017赛季要实现四冠王，2020年实现全华班。","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"6991346830798428089","link":"http://xw.qq.com/sports/20170213022997/SPO2017021302299704"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159621","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 12:44:29","havePic":true,"title":"上港\u201c胸\u201d前保持中超最贵，亿元赞助已买不起\u201c埃尔克森\u201d","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/489.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/494.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/490.jpg"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/home40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/download40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/ydw_xqfx_zan.png"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/339.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/264.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/478/583.jpg"}],"desc":"上港集团和上汽集团举行战略合作发布会，上汽成为了2016年上港俱乐部胸前广告赞助商。","source":"澎湃新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"15201848982732398176","link":"http://www.thepaper.cn/baidu.jsp?contid=1617482"},{"pubDate":"2017-02-13 12:14:17","havePic":true,"title":"内蒙古70周年大庆将举办一下12项重点活动！","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://pic1.nmgnews.com.cn/0/11/46/72/11467262_907563.jpg"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"}],"desc":"内蒙古体育局对外公布《内蒙古自治区70周年大庆重点体育活动方案》。","source":"内蒙古新闻网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"2622362059722542686","link":"http://travel.nmgnews.com.cn/system/2017/02/13/012266333.shtml"},{"pubDate":"2017-02-13 12:10:54","havePic":true,"title":"观点:孔蒂点石成金因爱学习 受4名帅高等教育","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/121/203/2185/142131511.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/139/203/2185/142131529.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/149/203/2185/142131539.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/154/203/2185/142131544.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/164/203/2185/142131554.png"},{"height":0,"width":0,"url":"http://mat1.gtimg.com/sports/kluaswang/zuqiuyeka.gif"}],"desc":"有些球员能享受到在才华横溢的执教者手下的特权，并成为各项赛事的赢家。但前提是，他们得虚心向学。孔蒂在尤文图斯的职业生涯既是学习者也是传道者。这位坚韧的B2B中场的一双蓝眼睛极具洞察力，好像从电影里走出来的一样。从球员时代起就如此，比起比赛他更重视学习。纵观他的执教生涯，孔蒂可以说是接受了\u201c高等教育\u201d。","source":"国际足球新闻","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.qq.com/a/20170213/022692.htm"},{"pubDate":"2017-02-13 12:07:04","havePic":true,"title":"苏宁官方宣布杨博宇加盟球队 19岁小将同时来投","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/sP-p-fyamkra7180004.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/YZkP-fyamvns5066225.jpg"}],"desc":"　　2月13日，江苏苏宁官方宣布，球员杨博宇和高天意转会到球队，新赛季，他们将为江苏而战。高天意加盟球队　　苏宁今日在官方微博中分别宣布高天意和杨博宇加盟球队。据苏宁介绍，1998年7月1日出生于大连的高天意，身高185公分，体重79公斤，司职中场。高天意有着丰富的留洋经....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466702.shtml"},{"pubDate":"2017-02-13 11:59:10","havePic":true,"title":"广州政府重奖本地俱乐部 双冠王可获一亿元奖金","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ySus-fyamkqa5874913.jpg"}],"desc":"　　记者王伟报道广州重奖本地中超俱乐部！2月10日，广州市体育局官方发布了2017年部门预算，其中关于体育产业职业足球俱乐部奖励的项目内容为：一、获得中超参赛资格的职业足球俱乐部奖励2000万元；二、获得中超联赛冠军的职业足球俱乐部奖励3000万元；三、获得亚洲联赛冠....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466436.shtml"},{"pubDate":"2017-02-13 11:52:37","havePic":true,"title":"江苏苏宁队官方宣布高天意加盟 补强球队实力","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/113/208/2185/142132778.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/28/209/2185/142132948.jpg"}],"desc":"高天意加盟苏宁腾讯体育2月13日讯今日，中超俱乐部江苏苏宁官方宣布，小将高天意加盟。高天意出生于1998年，司职后腰，少年时期层留洋西班牙。2016年回到国内并和中甲俱乐部深圳队签约一年，为深圳出场17次。此次江苏苏宁与高天意签约4年，身着16号球衣。此前他已随苏宁一线队参加了冬训。苏宁公告如下：19岁小将高天意已","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/021809.htm"},{"pubDate":"2017-02-13 11:49:35","havePic":true,"title":"从总局局长讲话读中超改革方向 新政非拔苗助长","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/PuKs-fyamkra7176088.jpeg"}],"desc":"　　记者贾岩峰报道在2017年2月10日在北京召开的体育记者座谈会上，国家体育总局局长苟仲文表示足球改革为体育总局的改革提供了榜样，同时提出当前中超联赛依旧存在着花钱买繁荣等突出问题。这是对目前中超现状的一种批判，以后越是烧钱多的球队，反而越有可能成为被批判的....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466037.shtml"},{"pubDate":"2017-02-13 11:43:36","havePic":true,"title":"他若回国中国足球留洋没救了，4大希望之星全回来赖谁","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2D66405FC2DC33648D6DA377464CCABC7C213448_size34_w600_h380.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/E915DD647016FCD53B72B6E7ED3C1AF133799B33_size41_w640_h370.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2C69DFA46EBB0A99BE02966B520B95AB90091A37_size27_w500_h361.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/347EF37AACC4F57B108E77D9124F47F7BB8F6989_size20_w500_h332.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/C094896D62305803D7B7BFBB3699CE90636C2100_size50_w721_h475.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p2.ifengimg.com/a/2016/0810/204c433878d5cf9size1_w16_h16.png"}],"desc":"如果韦世豪也回来了，那么中国足球留洋将彻底没救了，在韦世豪之前，3位备受期待的小将杨立瑜、唐诗...","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8284983285607934950","link":"http://we.sportscn.com/viewnews-2246388.html"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159620","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:28:27","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"由于职业化进展缓慢，社会还没有进入真正的服务化时代，球迷是上帝，大多时候成为一句漂亮的口号。","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8037927807427244041","link":"http://we.sportscn.com/viewnews-2246281.html"},{"pubDate":"2017-02-13 11:13:21","havePic":true,"title":"徐亮加练任意球与埃帅打赌 笑称自己比贝克汉姆强","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/erLx-fyamkqa5864255.jpg"}],"desc":"　　记者王伟深圳报道昨天凌晨，深圳佳兆业经香港飞往阿联酋迪拜进行海外拉练，出发之前，球队核心徐亮在驻地深圳麒麟山庄接受了本报记者的独家专访，2016年初加入到深足的徐亮，经历了上赛季联赛和本赛季的冲超准备，他的经历就是佳兆业全力冲超的过程。采访中他谈到了球....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/b/2017-02-13/doc-ifyamkzq1269927.shtml"},{"sentiment_tag":{"id":"857","dim":"0","isbooked":0,"count":"132891","name":"足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:12:54","havePic":false,"title":"越城区校园足球定点学校顺利完成寒假集训工作","channelName":"国内最新","imageurls":[],"desc":"本次集训采用分散训练与拉练比赛相结合的方式。","source":"新民网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18379536889547114272","link":"http://bdnews.xinmin.cn/content/30829070"},{"sentiment_tag":{"id":"2955","dim":"0","isbooked":0,"count":"17232","name":"热刺","type":"senti","ishot":"0"},"pubDate":"2017-02-13 10:10:49","havePic":true,"title":"希勒：尽管战胜热刺 但利物浦已争冠无望","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://tu.qiumibao.com/uploads/news/day_170213/201702130939099580.jpg"}],"desc":"尽管本场比赛利物浦的表现令人信服，而且战胜的是争冠对手，但名宿阿兰-希勒认为，利物浦不可能赶上...","source":"直播吧","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18167316805862176432","link":"http://news.zhibo8.cc/zuqiu/2017-02-13/58a10e52a85e0.htm"},{"pubDate":"2017-02-13 09:44:47","havePic":false,"title":"苏宁推两种亲情套票售价400 享单独区域观赛","channelName":"国内足球最新","imageurls":[],"desc":"本报讯昨天下午，江苏苏宁足球俱乐部在苏宁体育奥体店开售下赛季亲情套票。亲情套票分为两种，一种是老人套票，限65岁以上老人购买，另外一种是亲子套票，限一大人一小孩的亲子组合，售价均为400元一套。同时，出于安全考虑，亲情套票将安排在单独区域。据悉，今年是江苏苏宁足球俱乐部首次推出亲情套票，其中老人套票是给","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013909.htm"},{"pubDate":"2017-02-13 09:34:46","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"球迷是上帝记者肖良志报道2017赛季，是80亿天价版权时代的第二年，各中俱乐部窜天猴般的烧钱速度，引进大牌外援的不断升级，每天都让人们产生着\u201c厉害了word俱乐部\u201d的感叹。人们担心中超门票也会坐地起价的时候，绝大多数俱乐部并没有像房地产一样变成吸血鬼，要么基本上没有涨价，要么象征意义大于实质本身。尤其是套票","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013163.htm"},{"pubDate":"2017-02-13 09:24:53","havePic":true,"title":"温格点名敲打厄齐尔:缺乏自信 该轮到你进球了","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/9rrW-fyamvns5029084.jpg"}],"desc":"","source":"新浪","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.sina.com.cn/g/pl/2017-02-13/doc-ifyamkzq1265587.shtml"},{"sentiment_tag":{"id":"22","dim":"0","isbooked":0,"count":"60183","name":"国际足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 09:24:24","havePic":true,"title":"穆里尼奥不服:别人踢得好叫艺术 我的队就不行？","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://www.he-nan.com/skin/2016/image/lazy.gif"}],"desc":"穆里尼奥在接受采访时也表示，曼联本赛季的攻势足球并没有得到应有的赞誉，尤其是和其他被媒体球迷捧...","source":"河南网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"13110970558277949746","link":"http://www.he-nan.com/show-313934.html"},{"pubDate":"2017-02-13 09:24:24","havePic":false,"title":"湖南将选送24名足球少年 赴西班牙学习","channelName":"国内最新","imageurls":[],"desc":"这次\u201c振兴足球，筑梦湖南\u201d选派青少年足球运动员赴西班牙训练学习的活动，是由省体育局在年前紧急发...","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"608948340708368797","link":"http://hn.qq.com/a/20170213/008102.htm"},{"pubDate":"2017-02-13 09:18:42","havePic":true,"title":"足协专题会议瞄2022和2026世界杯 里皮打基础","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/104/177/2185/142124864.jpg"}],"desc":"足协目标长远记者肖良志北京报道2月10日（周五），中国足协未雨绸缪，专题研如何拯救国字号队伍的未来，涉及到2020年东京奥运会、2022年和2026年世界杯、2024年奥运会。在现有的青训质量突破之前，采取什么样的措施才能提高国字号队伍的水平？参加会议的中国足协各部门负责人各抒己见，提出了很多意见和建议。除了2020年东","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/011906.htm"}],"currentPage":1,"allNum":2839,"maxResult":20}}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * pagebean : {"allPages":142,"contentlist":[{"pubDate":"2017-02-13 14:28:58","havePic":true,"title":"恒大将开始实施末位淘汰制 外援将开始只减不增","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/Y5Aj-fyamkqa5898097.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ger2-fyamvns5086360.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/pIrm-fyamkqa5898205.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/On7g-fyamkqa5898248.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/5U_z-fyamkpy9117879.jpg"}],"desc":"　　2月13日，广州恒大淘宝足球俱乐部在恒大中心召开新赛季全体会议，同时也是恒大足球系统2017年第一次全体会议。会议由恒大集团主管足球的副总裁刘永灼主持。恒大集团董事局主席许家印向球队提出2017赛季要夺取中超七连冠、蝉联足协杯和超级杯冠军，再夺亚冠冠军，实现四冠王，....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7470532.shtml"},{"pubDate":"2017-02-13 13:00:01","havePic":true,"title":"许家印提恒大2017目标四冠 2020全华班","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://inews.gtimg.com/newsapp_match/0/1133843341/0"}],"desc":"许家印明确提出球队的目标，2017赛季要实现四冠王，2020年实现全华班。","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"6991346830798428089","link":"http://xw.qq.com/sports/20170213022997/SPO2017021302299704"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159621","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 12:44:29","havePic":true,"title":"上港\u201c胸\u201d前保持中超最贵，亿元赞助已买不起\u201c埃尔克森\u201d","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/489.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/494.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/490.jpg"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/home40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/download40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/ydw_xqfx_zan.png"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/339.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/264.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/478/583.jpg"}],"desc":"上港集团和上汽集团举行战略合作发布会，上汽成为了2016年上港俱乐部胸前广告赞助商。","source":"澎湃新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"15201848982732398176","link":"http://www.thepaper.cn/baidu.jsp?contid=1617482"},{"pubDate":"2017-02-13 12:14:17","havePic":true,"title":"内蒙古70周年大庆将举办一下12项重点活动！","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://pic1.nmgnews.com.cn/0/11/46/72/11467262_907563.jpg"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"}],"desc":"内蒙古体育局对外公布《内蒙古自治区70周年大庆重点体育活动方案》。","source":"内蒙古新闻网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"2622362059722542686","link":"http://travel.nmgnews.com.cn/system/2017/02/13/012266333.shtml"},{"pubDate":"2017-02-13 12:10:54","havePic":true,"title":"观点:孔蒂点石成金因爱学习 受4名帅高等教育","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/121/203/2185/142131511.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/139/203/2185/142131529.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/149/203/2185/142131539.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/154/203/2185/142131544.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/164/203/2185/142131554.png"},{"height":0,"width":0,"url":"http://mat1.gtimg.com/sports/kluaswang/zuqiuyeka.gif"}],"desc":"有些球员能享受到在才华横溢的执教者手下的特权，并成为各项赛事的赢家。但前提是，他们得虚心向学。孔蒂在尤文图斯的职业生涯既是学习者也是传道者。这位坚韧的B2B中场的一双蓝眼睛极具洞察力，好像从电影里走出来的一样。从球员时代起就如此，比起比赛他更重视学习。纵观他的执教生涯，孔蒂可以说是接受了\u201c高等教育\u201d。","source":"国际足球新闻","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.qq.com/a/20170213/022692.htm"},{"pubDate":"2017-02-13 12:07:04","havePic":true,"title":"苏宁官方宣布杨博宇加盟球队 19岁小将同时来投","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/sP-p-fyamkra7180004.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/YZkP-fyamvns5066225.jpg"}],"desc":"　　2月13日，江苏苏宁官方宣布，球员杨博宇和高天意转会到球队，新赛季，他们将为江苏而战。高天意加盟球队　　苏宁今日在官方微博中分别宣布高天意和杨博宇加盟球队。据苏宁介绍，1998年7月1日出生于大连的高天意，身高185公分，体重79公斤，司职中场。高天意有着丰富的留洋经....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466702.shtml"},{"pubDate":"2017-02-13 11:59:10","havePic":true,"title":"广州政府重奖本地俱乐部 双冠王可获一亿元奖金","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ySus-fyamkqa5874913.jpg"}],"desc":"　　记者王伟报道广州重奖本地中超俱乐部！2月10日，广州市体育局官方发布了2017年部门预算，其中关于体育产业职业足球俱乐部奖励的项目内容为：一、获得中超参赛资格的职业足球俱乐部奖励2000万元；二、获得中超联赛冠军的职业足球俱乐部奖励3000万元；三、获得亚洲联赛冠....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466436.shtml"},{"pubDate":"2017-02-13 11:52:37","havePic":true,"title":"江苏苏宁队官方宣布高天意加盟 补强球队实力","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/113/208/2185/142132778.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/28/209/2185/142132948.jpg"}],"desc":"高天意加盟苏宁腾讯体育2月13日讯今日，中超俱乐部江苏苏宁官方宣布，小将高天意加盟。高天意出生于1998年，司职后腰，少年时期层留洋西班牙。2016年回到国内并和中甲俱乐部深圳队签约一年，为深圳出场17次。此次江苏苏宁与高天意签约4年，身着16号球衣。此前他已随苏宁一线队参加了冬训。苏宁公告如下：19岁小将高天意已","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/021809.htm"},{"pubDate":"2017-02-13 11:49:35","havePic":true,"title":"从总局局长讲话读中超改革方向 新政非拔苗助长","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/PuKs-fyamkra7176088.jpeg"}],"desc":"　　记者贾岩峰报道在2017年2月10日在北京召开的体育记者座谈会上，国家体育总局局长苟仲文表示足球改革为体育总局的改革提供了榜样，同时提出当前中超联赛依旧存在着花钱买繁荣等突出问题。这是对目前中超现状的一种批判，以后越是烧钱多的球队，反而越有可能成为被批判的....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466037.shtml"},{"pubDate":"2017-02-13 11:43:36","havePic":true,"title":"他若回国中国足球留洋没救了，4大希望之星全回来赖谁","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2D66405FC2DC33648D6DA377464CCABC7C213448_size34_w600_h380.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/E915DD647016FCD53B72B6E7ED3C1AF133799B33_size41_w640_h370.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2C69DFA46EBB0A99BE02966B520B95AB90091A37_size27_w500_h361.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/347EF37AACC4F57B108E77D9124F47F7BB8F6989_size20_w500_h332.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/C094896D62305803D7B7BFBB3699CE90636C2100_size50_w721_h475.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p2.ifengimg.com/a/2016/0810/204c433878d5cf9size1_w16_h16.png"}],"desc":"如果韦世豪也回来了，那么中国足球留洋将彻底没救了，在韦世豪之前，3位备受期待的小将杨立瑜、唐诗...","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8284983285607934950","link":"http://we.sportscn.com/viewnews-2246388.html"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159620","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:28:27","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"由于职业化进展缓慢，社会还没有进入真正的服务化时代，球迷是上帝，大多时候成为一句漂亮的口号。","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8037927807427244041","link":"http://we.sportscn.com/viewnews-2246281.html"},{"pubDate":"2017-02-13 11:13:21","havePic":true,"title":"徐亮加练任意球与埃帅打赌 笑称自己比贝克汉姆强","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/erLx-fyamkqa5864255.jpg"}],"desc":"　　记者王伟深圳报道昨天凌晨，深圳佳兆业经香港飞往阿联酋迪拜进行海外拉练，出发之前，球队核心徐亮在驻地深圳麒麟山庄接受了本报记者的独家专访，2016年初加入到深足的徐亮，经历了上赛季联赛和本赛季的冲超准备，他的经历就是佳兆业全力冲超的过程。采访中他谈到了球....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/b/2017-02-13/doc-ifyamkzq1269927.shtml"},{"sentiment_tag":{"id":"857","dim":"0","isbooked":0,"count":"132891","name":"足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:12:54","havePic":false,"title":"越城区校园足球定点学校顺利完成寒假集训工作","channelName":"国内最新","imageurls":[],"desc":"本次集训采用分散训练与拉练比赛相结合的方式。","source":"新民网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18379536889547114272","link":"http://bdnews.xinmin.cn/content/30829070"},{"sentiment_tag":{"id":"2955","dim":"0","isbooked":0,"count":"17232","name":"热刺","type":"senti","ishot":"0"},"pubDate":"2017-02-13 10:10:49","havePic":true,"title":"希勒：尽管战胜热刺 但利物浦已争冠无望","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://tu.qiumibao.com/uploads/news/day_170213/201702130939099580.jpg"}],"desc":"尽管本场比赛利物浦的表现令人信服，而且战胜的是争冠对手，但名宿阿兰-希勒认为，利物浦不可能赶上...","source":"直播吧","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18167316805862176432","link":"http://news.zhibo8.cc/zuqiu/2017-02-13/58a10e52a85e0.htm"},{"pubDate":"2017-02-13 09:44:47","havePic":false,"title":"苏宁推两种亲情套票售价400 享单独区域观赛","channelName":"国内足球最新","imageurls":[],"desc":"本报讯昨天下午，江苏苏宁足球俱乐部在苏宁体育奥体店开售下赛季亲情套票。亲情套票分为两种，一种是老人套票，限65岁以上老人购买，另外一种是亲子套票，限一大人一小孩的亲子组合，售价均为400元一套。同时，出于安全考虑，亲情套票将安排在单独区域。据悉，今年是江苏苏宁足球俱乐部首次推出亲情套票，其中老人套票是给","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013909.htm"},{"pubDate":"2017-02-13 09:34:46","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"球迷是上帝记者肖良志报道2017赛季，是80亿天价版权时代的第二年，各中俱乐部窜天猴般的烧钱速度，引进大牌外援的不断升级，每天都让人们产生着\u201c厉害了word俱乐部\u201d的感叹。人们担心中超门票也会坐地起价的时候，绝大多数俱乐部并没有像房地产一样变成吸血鬼，要么基本上没有涨价，要么象征意义大于实质本身。尤其是套票","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013163.htm"},{"pubDate":"2017-02-13 09:24:53","havePic":true,"title":"温格点名敲打厄齐尔:缺乏自信 该轮到你进球了","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/9rrW-fyamvns5029084.jpg"}],"desc":"","source":"新浪","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.sina.com.cn/g/pl/2017-02-13/doc-ifyamkzq1265587.shtml"},{"sentiment_tag":{"id":"22","dim":"0","isbooked":0,"count":"60183","name":"国际足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 09:24:24","havePic":true,"title":"穆里尼奥不服:别人踢得好叫艺术 我的队就不行？","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://www.he-nan.com/skin/2016/image/lazy.gif"}],"desc":"穆里尼奥在接受采访时也表示，曼联本赛季的攻势足球并没有得到应有的赞誉，尤其是和其他被媒体球迷捧...","source":"河南网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"13110970558277949746","link":"http://www.he-nan.com/show-313934.html"},{"pubDate":"2017-02-13 09:24:24","havePic":false,"title":"湖南将选送24名足球少年 赴西班牙学习","channelName":"国内最新","imageurls":[],"desc":"这次\u201c振兴足球，筑梦湖南\u201d选派青少年足球运动员赴西班牙训练学习的活动，是由省体育局在年前紧急发...","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"608948340708368797","link":"http://hn.qq.com/a/20170213/008102.htm"},{"pubDate":"2017-02-13 09:18:42","havePic":true,"title":"足协专题会议瞄2022和2026世界杯 里皮打基础","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/104/177/2185/142124864.jpg"}],"desc":"足协目标长远记者肖良志北京报道2月10日（周五），中国足协未雨绸缪，专题研如何拯救国字号队伍的未来，涉及到2020年东京奥运会、2022年和2026年世界杯、2024年奥运会。在现有的青训质量突破之前，采取什么样的措施才能提高国字号队伍的水平？参加会议的中国足协各部门负责人各抒己见，提出了很多意见和建议。除了2020年东","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/011906.htm"}],"currentPage":1,"allNum":2839,"maxResult":20}
         */

        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            /**
             * allPages : 142
             * contentlist : [{"pubDate":"2017-02-13 14:28:58","havePic":true,"title":"恒大将开始实施末位淘汰制 外援将开始只减不增","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/Y5Aj-fyamkqa5898097.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ger2-fyamvns5086360.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/pIrm-fyamkqa5898205.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/On7g-fyamkqa5898248.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/5U_z-fyamkpy9117879.jpg"}],"desc":"　　2月13日，广州恒大淘宝足球俱乐部在恒大中心召开新赛季全体会议，同时也是恒大足球系统2017年第一次全体会议。会议由恒大集团主管足球的副总裁刘永灼主持。恒大集团董事局主席许家印向球队提出2017赛季要夺取中超七连冠、蝉联足协杯和超级杯冠军，再夺亚冠冠军，实现四冠王，....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7470532.shtml"},{"pubDate":"2017-02-13 13:00:01","havePic":true,"title":"许家印提恒大2017目标四冠 2020全华班","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://inews.gtimg.com/newsapp_match/0/1133843341/0"}],"desc":"许家印明确提出球队的目标，2017赛季要实现四冠王，2020年实现全华班。","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"6991346830798428089","link":"http://xw.qq.com/sports/20170213022997/SPO2017021302299704"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159621","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 12:44:29","havePic":true,"title":"上港\u201c胸\u201d前保持中超最贵，亿元赞助已买不起\u201c埃尔克森\u201d","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/489.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/494.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/www/image/5/479/490.jpg"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/home40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/download40.png"},{"height":0,"width":0,"url":"http://www.thepaper.cn/../img/ydw_xqfx_zan.png"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/339.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/479/264.jpg"},{"height":0,"width":0,"url":"http://image.thepaper.cn/image/5/478/583.jpg"}],"desc":"上港集团和上汽集团举行战略合作发布会，上汽成为了2016年上港俱乐部胸前广告赞助商。","source":"澎湃新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"15201848982732398176","link":"http://www.thepaper.cn/baidu.jsp?contid=1617482"},{"pubDate":"2017-02-13 12:14:17","havePic":true,"title":"内蒙古70周年大庆将举办一下12项重点活动！","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://pic1.nmgnews.com.cn/0/11/46/72/11467262_907563.jpg"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"},{"height":0,"width":0,"url":"http://travel.nmgnews.com.cn/system/2017/02/13/data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyBpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYwIDYxLjEzNDc3NywgMjAxMC8wMi8xMi0xNzozMjowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBXaW5kb3dzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkJDQzA1MTVGNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkJDQzA1MTYwNkE2MjExRTRBRjEzODVCM0Q0NEVFMjFBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QkNDMDUxNUQ2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QkNDMDUxNUU2QTYyMTFFNEFGMTM4NUIzRDQ0RUUyMUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6p+a6fAAAAD0lEQVR42mJ89/Y1QIABAAWXAsgVS/hWAAAAAElFTkSuQmCC"}],"desc":"内蒙古体育局对外公布《内蒙古自治区70周年大庆重点体育活动方案》。","source":"内蒙古新闻网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"2622362059722542686","link":"http://travel.nmgnews.com.cn/system/2017/02/13/012266333.shtml"},{"pubDate":"2017-02-13 12:10:54","havePic":true,"title":"观点:孔蒂点石成金因爱学习 受4名帅高等教育","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/121/203/2185/142131511.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/139/203/2185/142131529.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/149/203/2185/142131539.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/154/203/2185/142131544.png"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/164/203/2185/142131554.png"},{"height":0,"width":0,"url":"http://mat1.gtimg.com/sports/kluaswang/zuqiuyeka.gif"}],"desc":"有些球员能享受到在才华横溢的执教者手下的特权，并成为各项赛事的赢家。但前提是，他们得虚心向学。孔蒂在尤文图斯的职业生涯既是学习者也是传道者。这位坚韧的B2B中场的一双蓝眼睛极具洞察力，好像从电影里走出来的一样。从球员时代起就如此，比起比赛他更重视学习。纵观他的执教生涯，孔蒂可以说是接受了\u201c高等教育\u201d。","source":"国际足球新闻","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.qq.com/a/20170213/022692.htm"},{"pubDate":"2017-02-13 12:07:04","havePic":true,"title":"苏宁官方宣布杨博宇加盟球队 19岁小将同时来投","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/sP-p-fyamkra7180004.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/YZkP-fyamvns5066225.jpg"}],"desc":"　　2月13日，江苏苏宁官方宣布，球员杨博宇和高天意转会到球队，新赛季，他们将为江苏而战。高天意加盟球队　　苏宁今日在官方微博中分别宣布高天意和杨博宇加盟球队。据苏宁介绍，1998年7月1日出生于大连的高天意，身高185公分，体重79公斤，司职中场。高天意有着丰富的留洋经....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466702.shtml"},{"pubDate":"2017-02-13 11:59:10","havePic":true,"title":"广州政府重奖本地俱乐部 双冠王可获一亿元奖金","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ySus-fyamkqa5874913.jpg"}],"desc":"　　记者王伟报道广州重奖本地中超俱乐部！2月10日，广州市体育局官方发布了2017年部门预算，其中关于体育产业职业足球俱乐部奖励的项目内容为：一、获得中超参赛资格的职业足球俱乐部奖励2000万元；二、获得中超联赛冠军的职业足球俱乐部奖励3000万元；三、获得亚洲联赛冠....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466436.shtml"},{"pubDate":"2017-02-13 11:52:37","havePic":true,"title":"江苏苏宁队官方宣布高天意加盟 补强球队实力","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/113/208/2185/142132778.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/28/209/2185/142132948.jpg"}],"desc":"高天意加盟苏宁腾讯体育2月13日讯今日，中超俱乐部江苏苏宁官方宣布，小将高天意加盟。高天意出生于1998年，司职后腰，少年时期层留洋西班牙。2016年回到国内并和中甲俱乐部深圳队签约一年，为深圳出场17次。此次江苏苏宁与高天意签约4年，身着16号球衣。此前他已随苏宁一线队参加了冬训。苏宁公告如下：19岁小将高天意已","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/021809.htm"},{"pubDate":"2017-02-13 11:49:35","havePic":true,"title":"从总局局长讲话读中超改革方向 新政非拔苗助长","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/PuKs-fyamkra7176088.jpeg"}],"desc":"　　记者贾岩峰报道在2017年2月10日在北京召开的体育记者座谈会上，国家体育总局局长苟仲文表示足球改革为体育总局的改革提供了榜样，同时提出当前中超联赛依旧存在着花钱买繁荣等突出问题。这是对目前中超现状的一种批判，以后越是烧钱多的球队，反而越有可能成为被批判的....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7466037.shtml"},{"pubDate":"2017-02-13 11:43:36","havePic":true,"title":"他若回国中国足球留洋没救了，4大希望之星全回来赖谁","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2D66405FC2DC33648D6DA377464CCABC7C213448_size34_w600_h380.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/E915DD647016FCD53B72B6E7ED3C1AF133799B33_size41_w640_h370.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/2C69DFA46EBB0A99BE02966B520B95AB90091A37_size27_w500_h361.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/347EF37AACC4F57B108E77D9124F47F7BB8F6989_size20_w500_h332.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p0.ifengimg.com/pmop/2017/0213/C094896D62305803D7B7BFBB3699CE90636C2100_size50_w721_h475.jpeg"},{"height":0,"width":0,"url":"http://img.sportscn.com/q.jpg?http://p2.ifengimg.com/a/2016/0810/204c433878d5cf9size1_w16_h16.png"}],"desc":"如果韦世豪也回来了，那么中国足球留洋将彻底没救了，在韦世豪之前，3位备受期待的小将杨立瑜、唐诗...","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8284983285607934950","link":"http://we.sportscn.com/viewnews-2246388.html"},{"sentiment_tag":{"id":"76","dim":"0","isbooked":0,"count":"159620","name":"中超","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:28:27","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"由于职业化进展缓慢，社会还没有进入真正的服务化时代，球迷是上帝，大多时候成为一句漂亮的口号。","source":"华体网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"8037927807427244041","link":"http://we.sportscn.com/viewnews-2246281.html"},{"pubDate":"2017-02-13 11:13:21","havePic":true,"title":"徐亮加练任意球与埃帅打赌 笑称自己比贝克汉姆强","channelName":"体育焦点","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/erLx-fyamkqa5864255.jpg"}],"desc":"　　记者王伟深圳报道昨天凌晨，深圳佳兆业经香港飞往阿联酋迪拜进行海外拉练，出发之前，球队核心徐亮在驻地深圳麒麟山庄接受了本报记者的独家专访，2016年初加入到深足的徐亮，经历了上赛季联赛和本赛季的冲超准备，他的经历就是佳兆业全力冲超的过程。采访中他谈到了球....","source":"新浪","channelId":"5572a108b3cdc86cf39001d4","link":"http://sports.sina.com.cn/china/b/2017-02-13/doc-ifyamkzq1269927.shtml"},{"sentiment_tag":{"id":"857","dim":"0","isbooked":0,"count":"132891","name":"足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 11:12:54","havePic":false,"title":"越城区校园足球定点学校顺利完成寒假集训工作","channelName":"国内最新","imageurls":[],"desc":"本次集训采用分散训练与拉练比赛相结合的方式。","source":"新民网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18379536889547114272","link":"http://bdnews.xinmin.cn/content/30829070"},{"sentiment_tag":{"id":"2955","dim":"0","isbooked":0,"count":"17232","name":"热刺","type":"senti","ishot":"0"},"pubDate":"2017-02-13 10:10:49","havePic":true,"title":"希勒：尽管战胜热刺 但利物浦已争冠无望","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://tu.qiumibao.com/uploads/news/day_170213/201702130939099580.jpg"}],"desc":"尽管本场比赛利物浦的表现令人信服，而且战胜的是争冠对手，但名宿阿兰-希勒认为，利物浦不可能赶上...","source":"直播吧","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"18167316805862176432","link":"http://news.zhibo8.cc/zuqiu/2017-02-13/58a10e52a85e0.htm"},{"pubDate":"2017-02-13 09:44:47","havePic":false,"title":"苏宁推两种亲情套票售价400 享单独区域观赛","channelName":"国内足球最新","imageurls":[],"desc":"本报讯昨天下午，江苏苏宁足球俱乐部在苏宁体育奥体店开售下赛季亲情套票。亲情套票分为两种，一种是老人套票，限65岁以上老人购买，另外一种是亲子套票，限一大人一小孩的亲子组合，售价均为400元一套。同时，出于安全考虑，亲情套票将安排在单独区域。据悉，今年是江苏苏宁足球俱乐部首次推出亲情套票，其中老人套票是给","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013909.htm"},{"pubDate":"2017-02-13 09:34:46","havePic":true,"title":"中超球票基本没涨价 俱乐部：把球迷当做上帝","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/237/181/2185/142126017.jpg"},{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/37/182/2185/142126072.jpg"}],"desc":"球迷是上帝记者肖良志报道2017赛季，是80亿天价版权时代的第二年，各中俱乐部窜天猴般的烧钱速度，引进大牌外援的不断升级，每天都让人们产生着\u201c厉害了word俱乐部\u201d的感叹。人们担心中超门票也会坐地起价的时候，绝大多数俱乐部并没有像房地产一样变成吸血鬼，要么基本上没有涨价，要么象征意义大于实质本身。尤其是套票","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/013163.htm"},{"pubDate":"2017-02-13 09:24:53","havePic":true,"title":"温格点名敲打厄齐尔:缺乏自信 该轮到你进球了","channelName":"国际足球最新","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/9rrW-fyamvns5029084.jpg"}],"desc":"","source":"新浪","channelId":"5572a10ab3cdc86cf39001e7","link":"http://sports.sina.com.cn/g/pl/2017-02-13/doc-ifyamkzq1265587.shtml"},{"sentiment_tag":{"id":"22","dim":"0","isbooked":0,"count":"60183","name":"国际足球","type":"senti","ishot":"0"},"pubDate":"2017-02-13 09:24:24","havePic":true,"title":"穆里尼奥不服:别人踢得好叫艺术 我的队就不行？","channelName":"国内最新","imageurls":[{"height":0,"width":0,"url":"http://www.he-nan.com/skin/2016/image/lazy.gif"}],"desc":"穆里尼奥在接受采访时也表示，曼联本赛季的攻势足球并没有得到应有的赞誉，尤其是和其他被媒体球迷捧...","source":"河南网","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"13110970558277949746","link":"http://www.he-nan.com/show-313934.html"},{"pubDate":"2017-02-13 09:24:24","havePic":false,"title":"湖南将选送24名足球少年 赴西班牙学习","channelName":"国内最新","imageurls":[],"desc":"这次\u201c振兴足球，筑梦湖南\u201d选派青少年足球运动员赴西班牙训练学习的活动，是由省体育局在年前紧急发...","source":"腾讯新闻","sentiment_display":0,"channelId":"5572a109b3cdc86cf39001db","nid":"608948340708368797","link":"http://hn.qq.com/a/20170213/008102.htm"},{"pubDate":"2017-02-13 09:18:42","havePic":true,"title":"足协专题会议瞄2022和2026世界杯 里皮打基础","channelName":"国内足球最新","imageurls":[{"height":0,"width":0,"url":"http://img1.gtimg.com/sports/pics/hv1/104/177/2185/142124864.jpg"}],"desc":"足协目标长远记者肖良志北京报道2月10日（周五），中国足协未雨绸缪，专题研如何拯救国字号队伍的未来，涉及到2020年东京奥运会、2022年和2026年世界杯、2024年奥运会。在现有的青训质量突破之前，采取什么样的措施才能提高国字号队伍的水平？参加会议的中国足协各部门负责人各抒己见，提出了很多意见和建议。除了2020年东","source":"国内足球新闻","channelId":"5572a10ab3cdc86cf39001e8","link":"http://sports.qq.com/a/20170213/011906.htm"}]
             * currentPage : 1
             * allNum : 2839
             * maxResult : 20
             */

            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            private List<ContentlistBean> contentlist;

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                /**
                 * pubDate : 2017-02-13 14:28:58
                 * havePic : true
                 * title : 恒大将开始实施末位淘汰制 外援将开始只减不增
                 * channelName : 体育焦点
                 * imageurls : [{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/Y5Aj-fyamkqa5898097.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/ger2-fyamvns5086360.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/pIrm-fyamkqa5898205.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/On7g-fyamkqa5898248.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/sports/transform/20170213/5U_z-fyamkpy9117879.jpg"}]
                 * desc : 　　2月13日，广州恒大淘宝足球俱乐部在恒大中心召开新赛季全体会议，同时也是恒大足球系统2017年第一次全体会议。会议由恒大集团主管足球的副总裁刘永灼主持。恒大集团董事局主席许家印向球队提出2017赛季要夺取中超七连冠、蝉联足协杯和超级杯冠军，再夺亚冠冠军，实现四冠王，....
                 * source : 新浪
                 * channelId : 5572a108b3cdc86cf39001d4
                 * link : http://sports.sina.com.cn/china/j/2017-02-13/doc-ifyameqr7470532.shtml
                 * sentiment_display : 0
                 * nid : 6991346830798428089
                 * sentiment_tag : {"id":"76","dim":"0","isbooked":0,"count":"159621","name":"中超","type":"senti","ishot":"0"}
                 */

                private String pubDate;
                private boolean havePic;
                private String title;
                private String channelName;
                private String desc;
                private String source;
                private String channelId;
                private String link;
                private int sentiment_display;
                private String nid;
                private SentimentTagBean sentiment_tag;
                private List<ImageurlsBean> imageurls;

                public String getPubDate() {
                    return pubDate;
                }

                public void setPubDate(String pubDate) {
                    this.pubDate = pubDate;
                }

                public boolean isHavePic() {
                    return havePic;
                }

                public void setHavePic(boolean havePic) {
                    this.havePic = havePic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getChannelName() {
                    return channelName;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getChannelId() {
                    return channelId;
                }

                public void setChannelId(String channelId) {
                    this.channelId = channelId;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public int getSentiment_display() {
                    return sentiment_display;
                }

                public void setSentiment_display(int sentiment_display) {
                    this.sentiment_display = sentiment_display;
                }

                public String getNid() {
                    return nid;
                }

                public void setNid(String nid) {
                    this.nid = nid;
                }

                public SentimentTagBean getSentiment_tag() {
                    return sentiment_tag;
                }

                public void setSentiment_tag(SentimentTagBean sentiment_tag) {
                    this.sentiment_tag = sentiment_tag;
                }

                public List<ImageurlsBean> getImageurls() {
                    return imageurls;
                }

                public void setImageurls(List<ImageurlsBean> imageurls) {
                    this.imageurls = imageurls;
                }

                public static class SentimentTagBean {
                    /**
                     * id : 76
                     * dim : 0
                     * isbooked : 0
                     * count : 159621
                     * name : 中超
                     * type : senti
                     * ishot : 0
                     */

                    private String id;
                    private String dim;
                    private int isbooked;
                    private String count;
                    private String name;
                    private String type;
                    private String ishot;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getDim() {
                        return dim;
                    }

                    public void setDim(String dim) {
                        this.dim = dim;
                    }

                    public int getIsbooked() {
                        return isbooked;
                    }

                    public void setIsbooked(int isbooked) {
                        this.isbooked = isbooked;
                    }

                    public String getCount() {
                        return count;
                    }

                    public void setCount(String count) {
                        this.count = count;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getIshot() {
                        return ishot;
                    }

                    public void setIshot(String ishot) {
                        this.ishot = ishot;
                    }
                }

                public static class ImageurlsBean {
                    /**
                     * height : 0
                     * width : 0
                     * url : http://n.sinaimg.cn/sports/transform/20170213/Y5Aj-fyamkqa5898097.jpg
                     */

                    private int height;
                    private int width;
                    private String url;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }
}
