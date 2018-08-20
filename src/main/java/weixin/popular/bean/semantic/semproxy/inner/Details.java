package weixin.popular.bean.semantic.semproxy.inner;

/**
 * @program: weixin-popular
 * @description:
 * @author: 01
 * @create: 2018-08-18 13:32
 **/
public class Details {
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
}
