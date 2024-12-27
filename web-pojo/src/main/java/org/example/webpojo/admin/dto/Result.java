package org.example.webpojo.admin.dto;

/**
 * @class Result 返回信息结果类
 * @param <T> 任意数据
 */
public class Result<T> {
    private boolean success; // 操作是否成功

    private String message; // 提供给用户的提示信息

    private Integer code; // 状态吗，用于表示不同类型的响应

    private T data; // 响应数据

    // 成功时使用的构造函数
    public Result(T data) {
        this.success = true;
        this.message = "success";
        this.code = 200;
        this.data = data;
    }

    // 失败时使用的构造函数
    public Result(String message, Integer code) {
        this.success = false;
        this.message = message;
        this.code = code;
    }

    // 静态方法用于快速创建成功或者失败的实例
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> error(String message, Integer code) {
        return new Result<>(message, code);
    }
}
