package cn.huangbc.springbootweb.result;

import lombok.ToString;

/**
 * @author huangbc
 * @version 1.0
 * @date 2021/12/21 11:09
 */
public class ResultVO<T> {

    /*状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
