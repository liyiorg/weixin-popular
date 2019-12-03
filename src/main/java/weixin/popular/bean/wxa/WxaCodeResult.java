package weixin.popular.bean.wxa;

import weixin.popular.bean.BaseResult;

import java.awt.image.BufferedImage;

public class WxaCodeResult extends BaseResult {

    private BufferedImage bufferedImage;

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
