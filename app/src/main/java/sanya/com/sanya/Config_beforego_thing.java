package sanya.com.sanya;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2015/12/3.
 * 佛祖保佑             永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */
public class Config_beforego_thing {

        public static String[] totalTitle=new String[]{ "证件","背包","服装", "摄影相关",   "药品", "卫生用品"};

        public static List<List<String>> totalBody=new ArrayList<List<String>>();
        public static List<String> body=new ArrayList<>();
public static void addAll()
        {
                totalBody.add(new ArrayList<String>());
                totalBody.add(new ArrayList<String>());
                totalBody.add(new ArrayList<String>());
                totalBody.add(new ArrayList<String>());
                totalBody.add(new ArrayList<String>());
                totalBody.add(new ArrayList<String>());

                totalBody.get(0).add("1、身份证");
                totalBody.get(0).add("2、银行卡");
                totalBody.get(0).add("3、行驶本、驾驶证");
                totalBody.get(0).add("4、学生证（如有）");

                totalBody.get(1).add("1、登山包（45-80L不等，可用拉杆箱代替）");
                totalBody.get(1).add("2、双肩包 ");
                totalBody.get(1).add("3、腰包或随身挎包（按需携带）");

                totalBody.get(2).add("1、T恤若干（速干最好）");
                totalBody.get(2).add("2、内衣2-3套");
                totalBody.get(2).add("3、袜子一双");
                totalBody.get(2).add("4、人字拖或休闲拖鞋");
                totalBody.get(2).add("5、帽子");
                totalBody.get(2).add("6、墨镜");
                totalBody.get(2).add("7、雨伞");

                totalBody.get(3).add("1、相机及镜头");
                totalBody.get(3).add("2、三角架");
                totalBody.get(3).add("3、麂皮（擦镜布）");
                totalBody.get(3).add("4、摄影包及防水罩");
                totalBody.get(3).add("5、笔记本电脑（按需携带）");
                totalBody.get(3).add("6、备用电池及充电器");

                totalBody.get(4).add("1、肠胃药：吗叮呤、黄连素、十滴水");
                totalBody.get(4).add("2、感冒药：板蓝根（每天两包）、百服宁（退烧型）");
                totalBody.get(4).add("3、驱虫药：花绿水、驱蚊器");
                totalBody.get(4).add("4、外伤药 ：消炎药、金霉素眼膏");
                totalBody.get(4).add("5、维生素片、润喉片、止血绷带、创可贴");

                totalBody.get(5).add("1、洗漱用品：牙刷、牙膏、肥皂、毛巾、洗发水、梳子、剃须刀");
                totalBody.get(5).add("2、卫生用品：湿纸巾，卫生纸，卫生巾");
                totalBody.get(5).add("3、高度数防水护肤霜（很重要哦）");

        };
}
