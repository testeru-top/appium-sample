package top.testeru.entity;

public class SearchDto {
    private String search;
    private int num;

    @Override
    public String toString() {
        return "SearchDto{" +
                "search='" + search + '\'' +
                ", num=" + num +
                '}';
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
