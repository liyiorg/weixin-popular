package weixin.popular.bean.scan.info;


public class BaseInfo {
    private String  base_info;
    private String  title;
    private String  brand_tag;
    private String  category_id;
    private String  store_mgr_type;
    private String  [] store_vendorid_list;
    private String  color;

    public String getBase_info() {
        return base_info;
    }

    public void setBase_info(String base_info) {
        this.base_info = base_info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand_tag() {
        return brand_tag;
    }

    public void setBrand_tag(String brand_tag) {
        this.brand_tag = brand_tag;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getStore_mgr_type() {
        return store_mgr_type;
    }

    public void setStore_mgr_type(String store_mgr_type) {
        this.store_mgr_type = store_mgr_type;
    }

    public String[] getStore_vendorid_list() {
        return store_vendorid_list;
    }

    public void setStore_vendorid_list(String[] store_vendorid_list) {
        this.store_vendorid_list = store_vendorid_list;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
