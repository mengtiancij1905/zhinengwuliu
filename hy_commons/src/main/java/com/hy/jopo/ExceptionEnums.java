package com.hy.jopo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    //1XX：分类错误

    //2XX：品牌错误
    BRAND_IS_EMPTY(200, "品牌为空！"),

    //4XX：商品错误
    PRICE_CANNOT_BE_NULL(400, "价格不能为空"),
    SPECIFICATION_GROUP_IS_EMPTY(401, "规格组为空！"),
    SPECIFICATION_GROUP_PARAM_IS_EMPTY(402, "该规格组对应的参数为空!"),
    GOODS_NOT_FOUND(403,"商品为空！"),
    GOODS_DETAIL_NOT_FOUND(404,"商品详情为空!"),
    SKU_IS_EMPTY(405,"sku信息为空！"),
    Category_NOT_FOUND(400,"商品分类信息为空！"),

    //5xx:文件上传错误
    UPLOAD_FILE_ERROR_TYPE(500, "文件上传类型错误！"),
    UPLOAD_FILE_ERROR_CONTENT(501, "文件上传的内容不符合要求！"),
    UPLOAD_FILE_ERROR(502, "文件上传错误！"),
    INVALID_VERFIY_CODE(601, "验证码错误"),
    INSERT_ERROR(602,"添加失败"),
    USER_NULL(603,"用户不存在"),
    OrderNULL(500,"订单不存在"),
    NO_AUTHORIZED(605,"token获取失败"),
    USER_PASS_ERROR(604,"用户名密码错误"),
    UPDATE_ERROR(501,"修改失败");
    private int code;
    private String msg;
}
