package com.example.zzk_finaly_pro_1.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Works_Util {

    public static String[] deal_newfood_data(String data) {
        String[] this_data = data.split("&");
        String[] need_data = new String[this_data.length];

        try {
            String str2 = URLDecoder.decode(this_data[0].substring(this_data[0].indexOf("=") + 1), "utf-8");
            need_data[0] = str2;

            String str1 = this_data[1].substring(this_data[1].indexOf("=") + 1);
            need_data[1] = str1;
            need_data[2] = this_data[2].substring(this_data[2].indexOf("=") + 1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return need_data;
    }

    public static String[] deal_newlogin_data(String data) {
        String[] this_data = data.split("&");
        String[] need_data = new String[this_data.length];

        try {
            String str3 = this_data[0].substring(this_data[0].indexOf("=") + 1);
            need_data[0] = str3;

            String str1 = this_data[1].substring(this_data[1].indexOf("=") + 1);
            need_data[1] = str1;

            String str2 = URLDecoder.decode(this_data[2].substring(this_data[2].indexOf("=") + 1), "utf-8");
            need_data[2] = str2;


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return need_data;
    }

    public static String[] updata_newfood(String data) {
        String[] this_data = data.split("&");
        String[] need_data = new String[this_data.length];


        String str2 = this_data[0].substring(this_data[0].indexOf("=") + 1);
        need_data[0] = str2;

        String str1 = this_data[1].substring(this_data[1].indexOf("=") + 1);
        need_data[1] = str1;

        return need_data;
    }


//    public static String getNotGoodsMes(List<Goods_work> list){
//        String str = "";
//        for (int i = 0; i < list.size(); ) {
//            int res = new Date().compareTo(list.get(i).getTime_end());
//            if (res == 0 || res == 1) {
//                str += list.get(i).getId();
//                str += ",";
//                list.remove(list.get(i));
//            }else i++;
//        }
//        return str;
//    }
//
//    public static  <T> Object My_work_Util(T t, String data) {
//        String t_class = String.valueOf(t.getClass());
//        String[] t_arrays = t_class.split("com.finallypro2.POJO.");
//
//        switch (t_arrays[t_arrays.length - 1]) {
//            case "Goods_work":
//                return goodUtil((Goods_work) t, data);
//            case "Ready_work":
//                return readyUtil((Ready_work) t, data);
//            case "User_message":
//                return UserMesUtil((User_message) t, data);
//            case "Work_message":
//                return WorkMesUtil((Work_message) t, data);
//            case "Complain":
//                return ComplainUtil((Complain) t, data);
//        }
//        return null;
//    }
//
//
//
//    public static Goods_work goodUtil(Goods_work goods_work, String data) {
////        Goods_work goods_work = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            long time1 = Long.parseLong(need_data[3]);
//            long time2 = Long.parseLong(need_data[4]);
//            need_data[3] = simpleDateFormat.format(new Date(time1));
//            need_data[4] = simpleDateFormat.format(new Date(time2));
//
//            goods_work.setAnum(need_data[0]);
//            goods_work.setTime_start(simpleDateFormat.parse(need_data[3]));
//            goods_work.setTime_end(simpleDateFormat.parse(need_data[4]));
//            goods_work.setPlace(need_data[1]);
//            goods_work.setMessage(URLDecoder.decode(need_data[2], "utf-8"));
//            goods_work.setMarket(Integer.parseInt(need_data[5]));
//
//        } catch (ParseException e) {
//            e.getStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return goods_work;
//    }
//
//    public static Ready_work readyUtil(Ready_work ready_work, String data) {
////        Ready_work ready_work = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            long time1 = Long.parseLong(need_data[4]);
//            long time2 = Long.parseLong(need_data[5]);
//            need_data[4] = simpleDateFormat.format(new Date(time1));
//            need_data[5] = simpleDateFormat.format(new Date(time2));
//
//            ready_work.setPlace(need_data[1]);
//            ready_work.setMessage(URLDecoder.decode(need_data[3], "utf-8"));
//            ready_work.setTime_start(simpleDateFormat.parse(need_data[4]));
//            ready_work.setTime_end(simpleDateFormat.parse(need_data[5]));
//            ready_work.setAnum(need_data[0]);
//            ready_work.setBnum(need_data[2]);
//            ready_work.setMarket(need_data[6]);
//
//        } catch (ParseException e) {
//            e.getStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return ready_work;
//    }
//
//    public static User_message UserMesUtil(User_message user_message, String data) {
////        User_message user_message = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//            user_message.setPhone(need_data[0]);
//            user_message.setPart(need_data[1]);
//            user_message.setPlace(need_data[2]);
//            user_message.setTalk(URLDecoder.decode(need_data[3], "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return user_message;
//    }
//
//    public static Work_message WorkMesUtil(Work_message work_message, String data) {
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            work_message.setPlace(need_data[2]);
//            work_message.setPhone(need_data[0]);
//            work_message.setPart(need_data[1]);
//            work_message.setTalk(URLDecoder.decode(need_data[3], "utf-8"));
//
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return work_message;
//    }
//
//    public static Complain ComplainUtil(Complain complain, String data) {
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
//
//                String str2 = this_data[i].substring(this_data[i].indexOf("=") + 1);
//                need_data[i] = str2;
//            }
//            complain.setUser(need_data[0]);
//            complain.setWork(need_data[1]);
//            complain.setDate(new Date());
//            switch (need_data[2]) {
//                case "1":
//                    complain.setMessage("服务态度太差");
//                    break;
//                case "2":
//                    complain.setMessage("服务效果太低");
//                    break;
//                case "3":
//                    complain.setMessage("人员消息异常");
//                    break;
//                case "4":
//                    complain.setMessage(URLDecoder.decode(need_data[3], "UTF-8"));
//                    break;
//            }
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return complain;
//    }
//
//    //用于转换前端发布菜单页面的信息，然后进行处理
//    public static Goods_work goodUtil(String data) {
//        Goods_work goods_work = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            long time1 = Long.parseLong(need_data[3]);
//            long time2 = Long.parseLong(need_data[4]);
//            need_data[3] = simpleDateFormat.format(new Date(time1));
//            need_data[4] = simpleDateFormat.format(new Date(time2));
//
//            goods_work = new Goods_work(
//                    need_data[0],
//                    simpleDateFormat.parse(need_data[3]),
//                    simpleDateFormat.parse(need_data[4]),
//                    need_data[1],
//                    URLDecoder.decode(need_data[2], "utf-8"),
//                    Integer.parseInt(need_data[5]));
//        } catch (ParseException e) {
//            e.getStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return goods_work;
//    }
//
//    public static Ready_work readyUtil(String data) {
//        Ready_work ready_work = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            long time1 = Long.parseLong(need_data[4]);
//            long time2 = Long.parseLong(need_data[5]);
//            need_data[4] = simpleDateFormat.format(new Date(time1));
//            need_data[5] = simpleDateFormat.format(new Date(time2));
//
//            ready_work = new Ready_work(
//                    need_data[1], URLDecoder.decode(need_data[3], "utf-8"),
//                    simpleDateFormat.parse(need_data[4]),
//                    simpleDateFormat.parse(need_data[5]),
//                    need_data[0], need_data[2], need_data[6]);
//        } catch (ParseException e) {
//            e.getStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return ready_work;
//    }
//
//    public static User_message UserMesUtil(String data) {
//        User_message user_message = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            user_message = new User_message(need_data[0], need_data[1], need_data[2], URLDecoder.decode(need_data[3], "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return user_message;
//    }
//
//    public static Work_message WorkMesUtil(String data) {
//        Work_message work_message = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
//                String str1 = this_data[i].substring(0, this_data[i].indexOf("="));
//                String str2 = this_data[i].substring(str1.length() + 1);
//                need_data[i] = str2;
//            }
//
//            work_message = new Work_message(need_data[2], need_data[0], need_data[1], URLDecoder.decode(need_data[3], "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.getStackTrace();
//        }
//        return work_message;
//    }
//
//    public static Complain ComplainUtil(String data) {
//        Complain complain = null;
//        try {
//            String[] this_data = data.split("&");
//            String[] need_data = new String[this_data.length];
//            for (int i = 0; i < this_data.length; i++) {
////                String str1 = this_data[i].substring(0,this_data[i].indexOf("="));
////                String str2 = this_data[i].substring(str1.length()+1);
//                String str2 = this_data[i].substring(this_data[i].indexOf("=") + 1);
//                need_data[i] = str2;
//            }
//            complain = new Complain(need_data[0], need_data[1], new Date());
//            switch (need_data[2]) {
//                case "1":
//                    complain.setMessage("服务态度太差");
//                    break;
//                case "2":
//                    complain.setMessage("服务效果太低");
//                    break;
//                case "3":
//                    complain.setMessage("人员消息异常");
//                    break;
//                case "4":
//                    complain.setMessage(URLDecoder.decode(need_data[3], "UTF-8"));
//                    break;
//            }
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return complain;
//    }
//
//    public static String[] root_Return(String data) {
//        String[] need_data = new String[2];
//        try {
//            String[] this_data = data.split("&");
//            for (int i = 0; i < this_data.length; i++) {
//                String str2 = this_data[i].substring(this_data[i].indexOf("=") + 1);
//                need_data[i] = str2;
//            }
//            need_data[1] = URLDecoder.decode(need_data[1], "UTF-8");
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return need_data;
//    }
//
//    public static Integer r_Num(Integer num,Integer divisor){
//        Integer number =0;
//        if (num % divisor == 0){
//            number = num / divisor;
//        } else {
//            number = (num / divisor) + 1;
//        }
////        if ((num / divisor) == 0) {
////            number = 1;
////        } else {
////            number = (num) / divisor;
////            if (((num) % divisor) != 0) {
////                number += 1;
////            }
////        }
//        return number;
//    }

}
