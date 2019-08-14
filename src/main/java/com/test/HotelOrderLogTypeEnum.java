package com.test;

public enum HotelOrderLogTypeEnum {
    ORDER_CREATE("ORDER_CREATE", "新增订单"), //
    ORDER_CONTACT_UPDATE("ORDER_CONTACT_UPDATE", "修改联系人"), //
    ORDER_CHANNELPAY_UPDATE("ORDER_CHANNELPAY_UPDATE", "修改渠道及支付类型"), //
    ORDER_CHANNEL_ORDER_NO_UPDATE("ORDER_CHANNEL_ORDER_NO_UPDATE", "修改订单渠道订单号"), //
    ORDER_REMARK_UPDATE("ORDER_REMARK_UPDATE", "修改订单备注"), //
    ORDER_CLASS_UPDATE("ORDER_CLASS_UPDATE", "修改订单图案"), //
    ORDER_DEAD_LINE_UPDATE("ORDER_DEAD_LINE_UPDATE", "修改订单保留时效"), //
    ORDER_ROOM_ADD("ORDER_ROOM_ADD", "添加入住信息"), //
    ORDER_ROOM_UPDATE("ORDER_ROOM_UPDATE", "修改入住信息"), //
    ORDER_ROOM_DELETE("ORDER_ROOM_DELETE", "删除入住信息"), //
    ORDER_ROOM_ADD_CHECK_IN("ORDER_ROOM_ADD_CHECK_IN", "直接入住"), //
    ORDER_ROOM_CUSTOMER_ADD("ORDER_ROOM_CUSTOMER_ADD", "增加房间入住人"), //
    ORDER_ROOM_CUSTOMER_UPDATE("ORDER_ROOM_CUSTOMER_UPDATE", "修改房间入住人"), //
    ORDER_ROOM_CUSTOMER_DELETE("ORDER_ROOM_CUSTOMER_DELETE", "删除房间入住人"), //
    ORDER_ROOM_PRICE_UPDATE("ORDER_ROOM_PRICE_UPDATE", "修改房价"), //
    ORDER_ALLOCATE_ROOM("ORDER_ALLOCATE_ROOM", "订单分房"), //
    ORDER_CANCEL_ALLOCATE_ROOM("ORDER_CANCEL_ALLOCATE_ROOM", "取消分房"), //
    ORDER_CHECK_IN("ORDER_CHECK_IN", "办理入住"), //
    ORDER_LEAVE_HOTEL("ORDER_LEAVE_HOTEL", "置为离店"), //
    ORDER_CHECK_OUT("ORDER_CHECK_OUT", "办理退房"), //
    ORDER_ADVANCE_CHECK_OUT("ORDER_ADVANCE_CHECK_OUT", "提前离店"), //
    ORDER_DELAY_CHECK_OUT("ORDER_DELAY_CHECK_OUT", "延迟离店"), //
    ORDER_SURCHARGE("ORDER_SURCHARGE", "加收房费"), //
    ORDER_CANCEL("ORDER_CANCEL", "取消预订"), //
    ORDER_BREAK_PROMISE("ORDER_BREAK_PROMISE", "失约未到"), //
    ORDER_CANCEL_CHECK_IN("ORDER_CANCEL_CHECK_IN", "取消入住"), //
    ORDER_INVOICE_PRICE_UPDATE("ORDER_INVOICE_PRICE_UPDATE", "修改订单发票信息"), //
    ORDER_AR_CUSTOMER_UPDATE("ORDER_AR_CUSTOMER_UPDATE", "修改订单协议客户信息"), //

    ;

    private String key;
    private String name;

    private HotelOrderLogTypeEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

}
