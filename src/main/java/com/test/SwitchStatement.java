package com.test;

/**
 * switch 语句
 */
public class SwitchStatement {


    public static void main(String[] args) {

        HotelOrderLogTypeEnum hotelOrderLogType = HotelOrderLogTypeEnum.ORDER_LEAVE_HOTEL;

        switch (hotelOrderLogType) {
            case ORDER_CHECK_IN:
                System.out.println(HotelOrderLogTypeEnum.ORDER_CHECK_IN.getName());
            case ORDER_ROOM_ADD_CHECK_IN:
                System.out.println(HotelOrderLogTypeEnum.ORDER_ROOM_ADD_CHECK_IN.getName());
            case ORDER_LEAVE_HOTEL:
                System.out.println(HotelOrderLogTypeEnum.ORDER_LEAVE_HOTEL.getName());
            case ORDER_CHECK_OUT:
            case ORDER_ADVANCE_CHECK_OUT:
            case ORDER_DELAY_CHECK_OUT:
            case ORDER_BREAK_PROMISE:
            case ORDER_CANCEL_CHECK_IN:
            case ORDER_CANCEL:

            case ORDER_CREATE:
                System.out.println(HotelOrderLogTypeEnum.ORDER_CREATE.getName());
                break;
            case ORDER_CONTACT_UPDATE:

                break;
            case ORDER_CHANNELPAY_UPDATE:

                break;
            case ORDER_CHANNEL_ORDER_NO_UPDATE:

                break;
            case ORDER_REMARK_UPDATE:

                break;
            case ORDER_AR_CUSTOMER_UPDATE:

            case ORDER_INVOICE_PRICE_UPDATE:
            case ORDER_ROOM_CUSTOMER_ADD:
            case ORDER_ROOM_CUSTOMER_UPDATE:
            case ORDER_ROOM_CUSTOMER_DELETE:
            case ORDER_ROOM_PRICE_UPDATE:

            case ORDER_ROOM_UPDATE:

                break;
            case ORDER_ALLOCATE_ROOM:
            case ORDER_CANCEL_ALLOCATE_ROOM:
            case ORDER_ROOM_DELETE:
            case ORDER_ROOM_ADD:
                break;
        }
    }


}
