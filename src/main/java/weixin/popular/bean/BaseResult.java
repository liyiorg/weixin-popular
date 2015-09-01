package weixin.popular.bean;

/**
 * 微信请求状态数据
 *
 * @author LiYi
 */
public class BaseResult {

  private static final String SUCCESS_CODE = "0";

  private String errcode;
  private String errmsg;

  public String getErrcode() {
    return errcode;
  }

  public void setErrcode(String errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  public boolean isSuccess() {
    return errcode == null || errcode.isEmpty() || errcode.equals(SUCCESS_CODE);
  }

}
