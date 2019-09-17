package org.qings2329.learn;

public class SplitSQL {

    public static void main(String[] args) {


        // 1215609

        //        for (int i = 1; i < 3400; i++) {
        //
        //            System.out.println(createSQL((i - 1) * 1000, i * 1000));
        //        }

        for (int i = 1; i < 1280; i++) {

            System.out.println(createSQL2((i - 1) * 1000, i * 1000));
        }
    }

    private static String createSQL(int start, int end) {
        String sql = " begin; "
                + " update t_pms_hotel_order t1 , t_pms_hotel_order_log t2 "
                + " set t1.creator = t2.operator, t1.creator_name = if(t2.operator_name = '渠道推送', 'SYSTEM', t2.operator_name) "
                + " where t1.hotel_id =t2.hotel_id and t1.id = t2.order_id  "
                + " and t2.log_key in ('ORDER_CREATE', 'ORDER_ROOM_ADD_CHECK_IN') "
                + " and t1.id >= " + start + " and t1.id <= " + end + "; commit; ";

        return sql;
    }

    private static String createSQL2(int start, int end) {
        String sql = " begin; "
                + " update t_pms_hotel_order t1 , t_pms_hotel_link_room_log t2 "
                + " set t1.creator = t2.operator, t1.creator_name = if(t2.operator_name = '渠道推送', 'SYSTEM', t2.operator_name) "
                + " where t1.hotel_id =t2.hotel_id and t1.id = t2.order_id  "
                + " and t2.log_key in ('ORDER_CREATE', 'ORDER_DIRECTLY_CHECK_IN') "
                + " and t1.id >= " + start + " and t1.id <= " + end + "; commit; ";

        return sql;
    }


}
