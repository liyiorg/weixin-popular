package weixin.popular.bean.semantic.semproxy;

import weixin.popular.bean.BaseResult;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 18:10
 * @Description:
 */
public class SemproxySearchResult extends BaseResult {

    private String query;
    private String type;
    private Semantic semantic;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Semantic getSemantic() {
        return semantic;
    }

    public void setSemantic(Semantic semantic) {
        this.semantic = semantic;
    }

    private class Semantic {
        private Details details;

        public Details getDetails() {
            return details;
        }

        public void setDetails(Details details) {
            this.details = details;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        private class Details {
            private String airline;
            private String hit_str;
            private String answer;
            private ContextInfo context_info;
            private StartLoc start_loc;
            private EndLoc end_loc;
            private StartDate start_date;

            public String getHit_str() {
                return hit_str;
            }

            public void setHit_str(String hit_str) {
                this.hit_str = hit_str;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public ContextInfo getContext_info() {
                return context_info;
            }

            public void setContext_info(ContextInfo context_info) {
                this.context_info = context_info;
            }

            public StartLoc getStart_loc() {
                return start_loc;
            }

            public void setStart_loc(StartLoc start_loc) {
                this.start_loc = start_loc;
            }

            public EndLoc getEnd_loc() {
                return end_loc;
            }

            public void setEnd_loc(EndLoc end_loc) {
                this.end_loc = end_loc;
            }

            public StartDate getStart_date() {
                return start_date;
            }

            public void setStart_date(StartDate start_date) {
                this.start_date = start_date;
            }

            public String getAirline() {
                return airline;
            }

            public void setAirline(String airline) {
                this.airline = airline;
            }

            private class StartLoc {
                private String type;
                private String city;
                private String city_simple;
                private String loc_ori;
                private String modify_times;
                private String slot_content_type;

                public String getModify_times() {
                    return modify_times;
                }

                public void setModify_times(String modify_times) {
                    this.modify_times = modify_times;
                }

                public String getSlot_content_type() {
                    return slot_content_type;
                }

                public void setSlot_content_type(String slot_content_type) {
                    this.slot_content_type = slot_content_type;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCity_simple() {
                    return city_simple;
                }

                public void setCity_simple(String city_simple) {
                    this.city_simple = city_simple;
                }

                public String getLoc_ori() {
                    return loc_ori;
                }

                public void setLoc_ori(String loc_ori) {
                    this.loc_ori = loc_ori;
                }
            }

            private class EndLoc extends StartLoc {
            }

            private class StartDate {
                private String type;
                private String date;
                private String date_ori;
                private String date_lunar;
                private String modify_times;
                private String slot_content_type;
                private String week;

                public String getDate_lunar() {
                    return date_lunar;
                }

                public void setDate_lunar(String date_lunar) {
                    this.date_lunar = date_lunar;
                }

                public String getModify_times() {
                    return modify_times;
                }

                public void setModify_times(String modify_times) {
                    this.modify_times = modify_times;
                }

                public String getSlot_content_type() {
                    return slot_content_type;
                }

                public void setSlot_content_type(String slot_content_type) {
                    this.slot_content_type = slot_content_type;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getDate_ori() {
                    return date_ori;
                }

                public void setDate_ori(String date_ori) {
                    this.date_ori = date_ori;
                }
            }

            private class ContextInfo {
                private String isFinished;
                private String null_times;

                public String getIsFinished() {
                    return isFinished;
                }

                public void setIsFinished(String isFinished) {
                    this.isFinished = isFinished;
                }

                public String getNull_times() {
                    return null_times;
                }

                public void setNull_times(String null_times) {
                    this.null_times = null_times;
                }
            }
        }

        private String intent;
    }
}

