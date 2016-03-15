package weixin.popular.bean.message;

import java.util.List;
import java.util.Map;

import weixin.popular.bean.BaseResult;

public class CurrentAutoreplyInfo extends BaseResult{

	private Integer is_add_friend_reply_open;
	
	private Integer is_autoreply_open;
	
	private Map<String,String> add_friend_autoreply_info;
	
	private Map<String,String> message_default_autoreply_info;
	
	private Keyword_autoreply_info keyword_autoreply_info;
	
	public static class Keyword_autoreply_info{
		
		private List<Keyword_reply> list;
		
		public static class Keyword_reply{
			
			private String rule_name;
			
			private Integer create_time;
			
			private String reply_mode;
			
			private List<Keyword_list_info> keyword_list_info;
			
			private List<Reply_list_info> reply_list_info;
			
			public static class Keyword_list_info{
				
				private String type;
				
				private String match_mode;
				
				private String content;

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getMatch_mode() {
					return match_mode;
				}

				public void setMatch_mode(String match_mode) {
					this.match_mode = match_mode;
				}

				public String getContent() {
					return content;
				}

				public void setContent(String content) {
					this.content = content;
				}
				
			}
			
			public static class Reply_list_info{
				private String type;
				
				private String content;
				
				private News_info_list news_info;
				
				public static class News_info_list{
					private List<News_info> list;
					
					public static class News_info{
						
						private String title;
						
						private String author;
						
						private String digest;
						
						private Integer show_cover;
						
						private String cover_url;

						private String content_url;
						
						private String source_url;

						public String getTitle() {
							return title;
						}

						public void setTitle(String title) {
							this.title = title;
						}

						public String getAuthor() {
							return author;
						}

						public void setAuthor(String author) {
							this.author = author;
						}

						public String getDigest() {
							return digest;
						}

						public void setDigest(String digest) {
							this.digest = digest;
						}

						public Integer getShow_cover() {
							return show_cover;
						}

						public void setShow_cover(Integer show_cover) {
							this.show_cover = show_cover;
						}

						public String getCover_url() {
							return cover_url;
						}

						public void setCover_url(String cover_url) {
							this.cover_url = cover_url;
						}

						public String getContent_url() {
							return content_url;
						}

						public void setContent_url(String content_url) {
							this.content_url = content_url;
						}

						public String getSource_url() {
							return source_url;
						}

						public void setSource_url(String source_url) {
							this.source_url = source_url;
						}
						
					}

					public List<News_info> getList() {
						return list;
					}

					public void setList(List<News_info> list) {
						this.list = list;
					}
					
					
				}

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getContent() {
					return content;
				}

				public void setContent(String content) {
					this.content = content;
				}

				public News_info_list getNews_info() {
					return news_info;
				}

				public void setNews_info(News_info_list news_info) {
					this.news_info = news_info;
				}
				
				
			}

			public String getRule_name() {
				return rule_name;
			}

			public void setRule_name(String rule_name) {
				this.rule_name = rule_name;
			}

			public Integer getCreate_time() {
				return create_time;
			}

			public void setCreate_time(Integer create_time) {
				this.create_time = create_time;
			}

			public String getReply_mode() {
				return reply_mode;
			}

			public void setReply_mode(String reply_mode) {
				this.reply_mode = reply_mode;
			}

			public List<Keyword_list_info> getKeyword_list_info() {
				return keyword_list_info;
			}

			public void setKeyword_list_info(List<Keyword_list_info> keyword_list_info) {
				this.keyword_list_info = keyword_list_info;
			}

			public List<Reply_list_info> getReply_list_info() {
				return reply_list_info;
			}

			public void setReply_list_info(List<Reply_list_info> reply_list_info) {
				this.reply_list_info = reply_list_info;
			}
			
			
		}

		public List<Keyword_reply> getList() {
			return list;
		}

		public void setList(List<Keyword_reply> list) {
			this.list = list;
		}
		
	}

	public Integer getIs_add_friend_reply_open() {
		return is_add_friend_reply_open;
	}

	public void setIs_add_friend_reply_open(Integer is_add_friend_reply_open) {
		this.is_add_friend_reply_open = is_add_friend_reply_open;
	}

	public Integer getIs_autoreply_open() {
		return is_autoreply_open;
	}

	public void setIs_autoreply_open(Integer is_autoreply_open) {
		this.is_autoreply_open = is_autoreply_open;
	}

	public Map<String, String> getAdd_friend_autoreply_info() {
		return add_friend_autoreply_info;
	}

	public void setAdd_friend_autoreply_info(
			Map<String, String> add_friend_autoreply_info) {
		this.add_friend_autoreply_info = add_friend_autoreply_info;
	}

	public Map<String, String> getMessage_default_autoreply_info() {
		return message_default_autoreply_info;
	}

	public void setMessage_default_autoreply_info(
			Map<String, String> message_default_autoreply_info) {
		this.message_default_autoreply_info = message_default_autoreply_info;
	}

	public Keyword_autoreply_info getKeyword_autoreply_info() {
		return keyword_autoreply_info;
	}

	public void setKeyword_autoreply_info(
			Keyword_autoreply_info keyword_autoreply_info) {
		this.keyword_autoreply_info = keyword_autoreply_info;
	}
	
	
}
