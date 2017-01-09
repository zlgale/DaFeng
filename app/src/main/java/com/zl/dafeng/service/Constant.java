package com.zl.dafeng.service;

public class Constant {

    /**
     * 外网正式接口
     */
//    // 图片前缀
//    public static final String  IMGURL= "http://api.miaodj.cn";
//    // 通用地址
//    public static final String COMMONURL = "http://api.miaodj.cn/index.php/App/";
    /**
     * 新内网测试接口
     */
    // 图片前缀
    public static final String  IMGURL= "http://imglocal.miaodj.cn";
    // 通用地址
    public static final String COMMONURL = "http://local.miaodj.cn/index.php/App/";
    /**
     * 公共接口
     */
    // 注册
    public static final String register = COMMONURL+"Login/register";
    // 登录
    public static final String login = COMMONURL+"Login/login";
    // 快捷登录
    public static final String quick_login = COMMONURL+"Login/quick_login";
    // 发送短信
    public static final String sendmsg = COMMONURL+"Login/sendmsg";
    // 登出
    public static final String logout = COMMONURL+"Common/logout";
    // 手机号码验证
    public static final String check_phone = COMMONURL+"Login/check_phone";
    // 获取省列表
    public static final String get_province = COMMONURL+"Public/get_province";
    // 获取市列表
    public static final String get_city = COMMONURL+"Public/get_city";
    // 获取区列表
    public static final String get_area = COMMONURL+"Public/get_area";
    // 获取所有的省市区
    public static final String get_address = COMMONURL+"Public/get_address";
    // 版本更新
    public static final String get_android_version = COMMONURL+"ExceptLogin/get_android_version";
    // 广告图片
    public static final String ads_img = COMMONURL+"ExceptLogin/first_image";
    /**
     * 业主接口
     */
    // 门店列表
    public static final String get_store_banner = COMMONURL+"ExceptLogin/get_store_banner";
    // 门店首页图片信息
    public static final String get_store_home_page = COMMONURL+"ExceptLogin/get_store_home_page";
    // 门店列表
    public static final String get_select_stores = COMMONURL+"ExceptLogin/get_select_stores";
    // 装修案例列表
    public static final String get_store_case = COMMONURL+"ExceptLogin/get_store_case";
    // 装修风格列表
    public static final String get_case_style = "ExceptLogin/get_case_style";
    // 装修案例房型列表
    public static final String get_case_room_list = COMMONURL+"ExceptLogin/get_case_room_list";
    // 装修案例房型列表
    public static final String get_quick_house_type = COMMONURL+"QuickOffer/get_quick_house_type";
    // 快速报价-获取价格
    public static final String get_quick_price = COMMONURL+"QuickOffer/get_quick_price";
    // 快速报价-立即预约
    public static final String add_quick_customer = COMMONURL+"QuickOffer/add_quick_customer";
    // 我的推荐客户列表
    public static final String my_recommend_custome = COMMONURL+"Customer/my_recommend_customers";
    // 推荐客户
    public static final String recommend_customer = COMMONURL+"Customer/recommend_customer";
    // 获取用户基本资料
    public static final String get_profile = COMMONURL+"Customer/get_profile";
    // 项目详情
    public static final String get_projects = COMMONURL+"Project/get_projects";
    // 查看项目节点列表
    public static final String get_nodes = COMMONURL+"Project/get_nodes";
    // 查看项目节点详情
    public static final String get_node_detail = COMMONURL+"Project/get_node_detail";
    // 获取个人中心信息
    public static final String get_personal_page = COMMONURL+"Customer/get_personal_page";
    // 修改密码
    public static final String update_password =COMMONURL+"Customer/update_password";
    // 忘记密码
    public static final String getback_password =COMMONURL+"Public/getback_password";
    // 姓名修改
    public static final String update_name = COMMONURL+"Customer/update_name";
    // 性别修改
    public static final String update_sex = COMMONURL+"Customer/update_sex";
    // 更改房屋面积
    public static final String update_house_room = COMMONURL+"Customer/update_house_room";
    // 更改居住人数
    public static final String update_house_person = COMMONURL+"Customer/update_house_person";
    // 更改房屋类型
    public static final String update_house_type = COMMONURL+"Customer/update_house_type";
    // 更改房屋地址
    public static final String update_house_address = COMMONURL+"Customer/update_house_address";
    // 更改所属地区
    public static final String update_area = COMMONURL+"Customer/update_area";
    // 查看施工工人
    public static final String get_project_worker = COMMONURL+"Project/get_project_worker";
    // 查看施工名片
    public static final String show_worker_card = COMMONURL+"Project/show_worker_card";
    // 待办事项
    public static final String my_todo = COMMONURL+"Customer/my_todo";
    // 注册协议
    public static final String get_register_agreement = COMMONURL+"ExceptLogin/get_register_agreement";
    // 消息通知
    public static final String my_message = COMMONURL+"Customer/my_message";
    // 查看图纸
    public static final String get_drawings = COMMONURL+"Project/get_drawings";
    // 确认/不确认 图纸
    public static final String confirm_check_draw = COMMONURL+"Project/confirm_check_draw";
    // 确认/不确认 选品单
    public static final String confirm_choose_material = COMMONURL+"Project/confirm_choose_material";
    // 查看付款信息
    public static final String get_bargain_pay = COMMONURL+"Project/get_bargain_pay";
    // 查看合同
    public static final String get_bargain = COMMONURL+"Project/get_bargain";
    // 确认/不确认 施工进场
    public static final String confirm_project_start = COMMONURL+"Project/confirm_project_start";
    // 查看施工日志
    public static final String get_project_log = COMMONURL+"Project/get_project_log";
    // 查看施工图片
    public static final String get_project_album = COMMONURL+"Project/get_project_album";
    // 签到积分列表
    public static final String get_score_log = COMMONURL+"Customer/get_score_log";
    // 我的推荐客户详情
    public static final String my_recommend_customer_detail = COMMONURL+"Customer/my_recommend_customer_detail";
    // 上传图片
    public static final String upload_imgs = COMMONURL+"Public/upload_imgs";
    // 修改头像
    public static final String update_headimg = COMMONURL+"Customer/update_headimg";
    // 获取主材列表
    public static final String get_material_list = COMMONURL+"Material/get_material_list";
    // 获取主材列表(新接口)
    public static final String get_material_new_list = COMMONURL+"Material/get_material_new_list";
    // 我的选品单
    public static final String my_choose_materials = COMMONURL+"Customer/my_choose_materials";
    // 获取选品单列表
    public static final String get_choose_materials = COMMONURL+"Project/get_choose_materials";
    // 选择主材到选品单--旧的
    public static final String choose_material = COMMONURL+"Material/choose_material";
    // 取消已选择主材（选品单）--旧的
    public static final String cancel_choose_material = COMMONURL+"Material/cancel_choose_material";
    // 选择/取选主材到选品单(并返回同种数据)--新的
    public static final String select_material = COMMONURL+"Material/select_material";
    // 获取主材图片
    public static final String get_material_images = COMMONURL+"ExceptLogin/get_material_images";
    // 意见反馈
    public static final String push_opinion = COMMONURL+"Project/push_opinion";
    // 获取业主优惠券
    public static final String get_coupon = COMMONURL+"Customer/get_coupon";
    // 获取连续签到天数
    public static final String get_score_day = COMMONURL+"Customer/get_score_day";
    // 签到得积分
    public static final String to_sign = COMMONURL+"Customer/to_sign";
    // 装修案例相册
    public static final String get_store_case_images = COMMONURL+"ExceptLogin/get_store_case_images";
    // 预约量房
    public static final String add_bespeak = COMMONURL+"ExceptLogin/add_bespeak";
    // 获取主材详情(已登录)
    public static final String get_material_detail = COMMONURL+"Material/get_material_detail";


    // 用户基本资料的修改
    public static final String profile = "http://test3.emplus.cn/index.php?m=Vans&c=profile&a=profile";
    // 验证信息的修改
    public static final String verify_info = "http://test3.emplus.cn/index.php?m=Vans&c=profile&a=verify_info";
    // 修改密码
    public static final String resetpassword = "http://test3.emplus.cn/index.php?m=Vans&c=profile&a=resetpassword";

}
