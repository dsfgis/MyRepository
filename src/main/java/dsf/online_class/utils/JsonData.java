package dsf.online_class.utils;

import sun.applet.resources.MsgAppletViewer;

public class JsonData {
    private Integer code;
    private String msg;
    private Object data;

    public JsonData(){}
    public JsonData(Integer code,String msg,Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }

    public static JsonData buildSuccess()
    {
        return new JsonData(0,null,null);
    }
    public static JsonData buildSuccess(Object data)
    {
        return new JsonData(0,"success",data);

    }
    public static JsonData error(String msg)
    {
        return new JsonData(-1,msg,null);
    }
    public static JsonData error(Integer code,String msg)
    {
        return new JsonData(code,msg,null);
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
