package com.demo.test.listTest;

/**
 * @Description // 短信发送记录表
 * @Author ljc
 * @Date  2019/11/26 10:38
 * @Param
 * @return
 **/
public class TsmsCount {
    private Integer taskId;

    private Integer mobiles;

    private Integer smss;

    private Integer submits;

    private Integer delivrds;

    private Integer sendday;

    private String cm;


    public TsmsCount() {
    }

    static TsmsCount merge(TsmsCount s1, TsmsCount s2) {
        if (!s1.equals ( s2 )) {
            throw new IllegalArgumentException ();
        }
        return new TsmsCount ( s1.taskId, s1.sendday,s1.cm,
                (s1.mobiles + s2.mobiles),
                (s1.smss+s2.smss),
        (s1.submits+s2.submits),
                (s1.delivrds+s2.delivrds));
    }
    public TsmsCount(Integer taskId, Integer sendday, String cm, int i, int i1, int i2, int i3) {
        this.taskId = taskId;
        this.sendday = sendday;
        this.cm=cm;
        this.mobiles=i;
        this.smss=i1;
        this.submits=i2;
        this.delivrds=i3;

    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getMobiles() {
        return mobiles;
    }

    public void setMobiles(Integer mobiles) {
        this.mobiles = mobiles;
    }

    public Integer getSmss() {
        return smss;
    }

    public void setSmss(Integer smss) {
        this.smss = smss;
    }

    public Integer getSubmits() {
        return submits;
    }

    public void setSubmits(Integer submits) {
        this.submits = submits;
    }

    public Integer getDelivrds() {
        return delivrds;
    }

    public void setDelivrds(Integer delivrds) {
        this.delivrds = delivrds;
    }

    public Integer getSendday() {
        return sendday;
    }

    public void setSendday(Integer sendday) {
        this.sendday = sendday;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskId == null) ? 0 : taskId.hashCode ());
        result = prime * result + ((mobiles == null) ? 0 : mobiles.hashCode ());
        result = prime * result + ((smss == null) ? 0 : smss.hashCode ());
        result = prime * result + ((submits == null) ? 0 : submits.hashCode ());
        result = prime * result + ((sendday == null) ? 0 : sendday.hashCode ());
        result = prime * result + ((cm == null) ? 0 : cm.hashCode ());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass () != obj.getClass ())
            return false;

        TsmsCount other = (TsmsCount) obj;
        if (taskId == null) {
            if (other.taskId != null)
                return false;
        } else if (!taskId.equals ( other.taskId ))
            return false;

        if (mobiles == null) {
            if (other.mobiles != null)
                return false;
        } else if (!mobiles.equals ( other.mobiles ))
            return false;

        if (smss == null) {
            if (other.smss != null)
                return false;
        } else if (!smss.equals ( other.smss ))
            return false;

        if (submits == null) {
            if (other.submits != null)
                return false;
        } else if (!submits.equals ( other.submits ))
            return false;

        if (sendday == null) {
            if (other.sendday != null)
                return false;
        } else if (!sendday.equals ( other.sendday ))
            return false;

        if (cm == null) {
            if (other.cm != null)
                return false;
        } else if (!cm.equals ( other.cm ))
            return false;
        return true;
    }




}