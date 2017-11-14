package utils;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class Field {
    public static final String LOGIN_URL = "http://120.27.23.105/user/login"; // 拼接：mobile =?&password=?;
    public static final String REG_URL = "http://120.27.23.105/user/reg"; // 拼接：mobile =?&password=?;


    public static final String CHANGE_USER_NICKNAME = "http://120.27.23.105/user/updateNickName"; // 拼接?uid=?&nickname=''

    public static final String GETUSERINFO = "http://120.27.23.105/user/getUserInfo"; // 拼接?uid = ?

    // 主页数据
    public static final String HOME_PATH = "http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage";

    // 搜索框输入搜索的商品
    public static final String SEARCHE_GOODS_PATH = "http://120.27.23.105/product/searchProducts"; // 拼接?keywords=笔记本&page=1

    // 查询购物车
    public static final String SEARCH_CART_PATH = "http://120.27.23.105/product/getCarts";
}
