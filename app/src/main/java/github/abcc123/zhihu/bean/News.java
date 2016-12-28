package github.abcc123.zhihu.bean;

import java.util.List;

/**
 * Created by xintong on 2016/12/28.
 */

public class News {

    /**
     * date : 20161228
     * stories : [{"images":["http://pic3.zhimg.com/b4f604f118572634b1db38700c9a8c1a.jpg"],"type":0,"id":9096964,"ga_prefix":"122812","title":"大误 · 你看这有一个洞"},{"images":["http://pic3.zhimg.com/573b48c15c83a4acc32bbda0a2ad8b72.jpg"],"type":0,"id":9103208,"ga_prefix":"122811","title":"听说手机都会爆炸，电动汽车那么多的电池真的安全吗？"},{"title":"自由随性，清醒而疯狂，就爱「不正常」的浅野忠信","ga_prefix":"122810","images":["http://pic1.zhimg.com/58b11e74cc78c299766f956023c2c7b0.jpg"],"multipic":true,"type":0,"id":9100776},{"images":["http://pic4.zhimg.com/7561fd80ca4122261c3b34ab31df118f.jpg"],"type":0,"id":9083880,"ga_prefix":"122809","title":"用来给孩子爬来爬去的垫子，买之前可得好好挑选"},{"images":["http://pic1.zhimg.com/3d81afc4f9738fafbfee0a357c381e90.jpg"],"type":0,"id":9087927,"ga_prefix":"122808","title":"打算年后跳槽，现在就准备一份漂亮的简历吧"},{"images":["http://pic4.zhimg.com/c6df92901b4aa48e6017584454481b67.jpg"],"type":0,"id":9101814,"ga_prefix":"122807","title":"一瓶一块，三瓶两块五，该怎么买？"},{"images":["http://pic1.zhimg.com/11b50a06a8ae68bf32057e40b8c9b588.jpg"],"type":0,"id":9086246,"ga_prefix":"122807","title":"法律意义上，宿舍算「住宅」吗？"},{"images":["http://pic3.zhimg.com/7642324a20c278c69d0c15b0cbda5be6.jpg"],"type":0,"id":9101810,"ga_prefix":"122807","title":"2016 年度盘点 · 奥巴马，全球最有名的科技宅"},{"images":["http://pic3.zhimg.com/785abaf0cc4f4b26763a6c97ebd28626.jpg"],"type":0,"id":9102445,"ga_prefix":"122806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic1.zhimg.com/9f11cfb71f3c8108a6293b9aefb3c9d4.jpg","type":0,"id":9087927,"ga_prefix":"122808","title":"打算年后跳槽，现在就准备一份漂亮的简历吧"},{"image":"http://pic1.zhimg.com/27fc1dc1a79d987777d7234008f5b9ac.jpg","type":0,"id":9100776,"ga_prefix":"122810","title":"自由随性，清醒而疯狂，就爱「不正常」的浅野忠信"},{"image":"http://pic2.zhimg.com/303eaef149bbbe20ba135c4eae6273e5.jpg","type":0,"id":9101810,"ga_prefix":"122807","title":"2016 年度盘点 · 奥巴马，全球最有名的科技宅"},{"image":"http://pic1.zhimg.com/cdc3f3e78180172b17028de036488860.jpg","type":0,"id":9101443,"ga_prefix":"122717","title":"知乎好问题 · 有哪些适合普通人阅读的经济学论文？"},{"image":"http://pic2.zhimg.com/93e116d4ead2251a89c2b8495c26f845.jpg","type":0,"id":9101343,"ga_prefix":"122717","title":"美剧越来越短，也越来越好看了"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic3.zhimg.com/b4f604f118572634b1db38700c9a8c1a.jpg"]
         * type : 0
         * id : 9096964
         * ga_prefix : 122812
         * title : 大误 · 你看这有一个洞
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;
        private String date;
        private boolean isRead = false;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public boolean isRead() {
            return isRead;
        }

        public void setRead(boolean read) {
            isRead = read;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic1.zhimg.com/9f11cfb71f3c8108a6293b9aefb3c9d4.jpg
         * type : 0
         * id : 9087927
         * ga_prefix : 122808
         * title : 打算年后跳槽，现在就准备一份漂亮的简历吧
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
