package com.gosling.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @类描述：字符串工具类
 * @项目名称：gosling-blog-service
 * @包名：com.gosling.blog.util
 * @类名称：StringUtil
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2017-12-10 18:30:15
 */

public class StringUtil {
    private static final String regValidatorIp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";

    /**
     * 检查字符串是否为空
     * <p>为null或者长度为0视为空字符串
     * @param value 要检查的字符串
     * @param trim 是否去掉头尾的特定字符
     * @param trimChars 要去掉的特定字符
     * @return
     */
    public static boolean isEmpty(String value, boolean trim, char... trimChars) {
        if (trim)
            return value == null || trim(value, trimChars).length() <= 0;
        return value == null || value.length() <= 0;
    }

    /**
     * 检查字符串是否为空
     * <p>为null或者长度为0视为空字符串
     * @param value 要检查的字符串
     * @param trim 是否去掉头尾的空格
     * @return
     */
    public static boolean isEmpty(String value, boolean trim) {
        return isEmpty(value, trim, ' ');
    }

    /**
     * 检查字符串是否为空
     * <p>为null或者长度为0视为空字符串
     * @param value 要检查的字符串
     * @return
     */
    public static boolean isEmpty(String value) {
        return isEmpty(value, false);
    }

    /**
     * 如果为null，转换为""
     * @param value
     * @return
     */
    public static String nullSafeString(String value) {
        return value == null ? "" : value;
    }

    /**
     * 确保存入数据库的string值不会引起数据库报错。
     * <p>
     * 1. 数据库不允许为null，value为nul时返回""；<br />
     * 2. 超过最大长度时截断字符串。
     * @param value 要存入数据库的字符串值。
     * @param nullable 是否允许为null。
     * @param maxLength 最大长度。
     * @return
     */
    public static String dbSafeString(String value, boolean nullable, int maxLength) {
        if (value == null) {
            if (nullable)
                return null;
            return nullSafeString(value);
        }
        if (value.length() > maxLength)
            return value.substring(0, maxLength);
        return value;
    }

    /**
     * 去掉头尾空格字符
     * @param value 待处理的字符串
     * @return
     */
    public static String trim(String value) {
        return trim(3, value, ' ');
    }

    /**
     * 去除字符串头尾的特定字符
     * 
     * @param value 待处理的字符串
     * @param chars 需要去掉的特定字符
     * @return
     */
    public static String trim(String value, char... chars) {
        return trim(3, value, chars);
    }

    /**
     * 去除字符串头部的特定字符
     * 
     * @param value 待处理的字符串
     * @param chars 需要去掉的特定字符
     * @return
     */
    public static String trimStart(String value, char... chars) {
        return trim(1, value, chars);
    }

    /**
     * 去除字符串尾部的特定字符
     * @param value 待处理的字符串
     * @param chars 需要去掉的特定字符
     * @return
     */
    public static String trimEnd(String value, char... chars) {
        return trim(2, value, chars);
    }

    /**
     * 去掉字符串头尾特定字符
     * @param mode 
     * <li>1: 去掉头部特定字符；
     * <li>2: 去掉尾部特定字符；
     * <li>3: 去掉头尾特定字符；
     * @param value 待处理的字符串
     * @param chars 需要去掉的特定字符
     * @return
     */
    private static String trim(int mode, String value, char... chars) {
        if (value == null || value.length() <= 0)
            return value;

        int startIndex = 0, endIndex = value.length(), index = 0;
        if (mode == 1 || mode == 3) {
            // trim头部
            while (index < endIndex) {
                if (contains(chars, value.charAt(index++))) {
                    startIndex++;
                    continue;
                }
                break;
            }
        }

        if (startIndex >= endIndex)
            return "";

        if (mode == 2 || mode == 3) {
            // trim尾部
            index = endIndex - 1;
            while (index >= 0) {
                if (contains(chars, value.charAt(index--))) {
                    endIndex--;
                    continue;
                }
                break;
            }
        }

        if (startIndex >= endIndex)
            return "";
        if (startIndex == 0 && endIndex == value.length() - 1)
            return value;

        return value.substring(startIndex, endIndex);
    }

    private static boolean contains(char[] chars, char chr) {
        if (chars == null || chars.length <= 0)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chr)
                return true;
        }
        return false;
    }

    /**
     * 判断是否是有效的IP地址。
     * @param value
     * @return
     */
    public static boolean isIp(String value) {
        if (isEmpty(value))
            return false;
        return value.matches(regValidatorIp);
    }

    /**
     * 检查整数是否为空
     * @param val 要检查的字符串
     * @return
     */
    public static boolean isNullOrZero(Integer val) {
        if (val == null || val == 0) {
            return true;
        }
        return false;

    }

    /**
     * 以特定分隔符分开的重组Integer集合
     * @param string
     * @param sep
     * @return
     */
    public static List<Integer> string2IntegerList(String string, String sep) {
        List<Integer> list = null;
        try {
            String[] arr = string.split(sep);
            list = new ArrayList<Integer>(arr.length);
            for (String str : arr) {
                Integer i = Integer.valueOf(str);
                list.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Integer> string2IntegerList(String string) {
        return string2IntegerList(string, ",");
    }

    /**
     * list 转换成字符串 并加入分隔符
     * @param list
     * @param separator
     * @return
     */
    public static String listToString(List list, String separator) {
        if (list == null || list.size() < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    /**
     * 过滤特殊字符，如果发生异常返回没有过滤之前的字符串
     * @param str
     * @return
     */
    public static String stringFilterSpecial(String str) {
        // 只允许字母和数字     
        // String   regEx  =  "[^a-zA-Z0-9]";                   
        try {
            // 清除掉所有特殊字符
            String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？_]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 判断是否是字母是返回true，不是返回false
     * @param alpha
     * @return
     */
    public static boolean is_alpha(String alpha) {
        if (alpha == null)
            return false;
        return alpha.matches("[a-zA-Z]+");
    }

    /**
     * 获取UUID，去掉 “-”
     * @return
     */
    public static String produceUUID() {
        return String.valueOf(java.util.UUID.randomUUID()).replaceAll("-", "");
    }

    /**
     * 产生随机字符串
     * 
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     * 
     * @param length
     *            int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 截取数字  
     * @param content
     * @return
     */
    public static String getNumbers(String content) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(content);
        while (matcher.find())
            return matcher.replaceAll("");
        return content;
    }

}
