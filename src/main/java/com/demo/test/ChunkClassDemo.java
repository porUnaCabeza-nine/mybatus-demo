package com.demo.test;

public class ChunkClassDemo {

    //自增id
    private int id;

    //选择的屏幕大小
    private String screenSize;

    //块名称:
    private String tableCardTemplate;

    //创建时间
    private String createTime;

    //修改时间
    private String updateTime;

    //背景图路径
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getTableCardTemplate() {
        return tableCardTemplate;
    }

    public void setTableCardTemplate(String tableCardTemplate) {
        this.tableCardTemplate = tableCardTemplate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public static void main(String[] args) {
            String str = "ilovejavajavacdejavailha123java34javali3java@#@R#FDSFAFDAjavai23o2fjai23javii2o3java";
            String sToFind = "java";
            String str1 = "00 00 66 00 00 00 00";
            String sToFind1 = "0";

            int num = new ChunkClassDemo().countStr(str1,sToFind1);
            System.out.println("共找到" + num + "个" + sToFind1);
        }

        /**
         * @param str 原字符串
         * @param sToFind 需要查找的字符串
         * @return 返回在原字符串中sToFind出现的次数
         */
        private int countStr(String str,String sToFind) {
            int num = 0;
            while (str.contains(sToFind)) {
                str = str.substring(str.indexOf(sToFind) + sToFind.length());
                num ++;
            }
            return num;
        }




}
