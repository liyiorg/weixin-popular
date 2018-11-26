package weixin.popular.bean.media;

public enum MediaType{
	image {

		@Override
		public String fileSuffix() {
			return "jpg";
		}

		@Override
		public String uploadType() {
			return "image";
		}
	},voice_mp3 {

		@Override
		public String fileSuffix() {
			return "mp3";
		}

		@Override
		public String uploadType() {
			return "voice";
		}
	},voice_amr {

		@Override
		public String fileSuffix() {
			return "amr";
		}

		@Override
		public String uploadType() {
			return "voice";
		}
	},video {
		@Override
		public String fileSuffix() {
			return "mp4";
		}

		@Override
		public String uploadType() {
			return "video";
		}
	},thumb {
		@Override
		public String fileSuffix() {
			return "jpg";
		}

		@Override
		public String uploadType() {
			return "thumb";
		}
	};

	public abstract String fileSuffix();

	/**
	 * 上传类型
	 * @return uploadType
	 */
	public abstract String uploadType();



}
