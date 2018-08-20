package weixin.popular.bean.shakearound.material.add;

public enum MediaType {
    /**
     * 摇一摇页面展示的icon图
     */
    icon {
        @Override
        public String fileSuffix() {
            return "jpg";
        }

        @Override
        public String uploadType() {
            return "icon";
        }

    },
    /**
     * 申请开通摇一摇周边功能时需上传的资质文件
     */
    license {
        @Override
        public String fileSuffix() {
            return "jpg";
        }

        @Override
        public String uploadType() {
            return "license";
        }
    };

    public abstract String fileSuffix();

    public abstract String uploadType();
}
