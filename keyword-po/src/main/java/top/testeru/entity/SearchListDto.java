package top.testeru.entity;

import java.util.List;

public class SearchListDto {
    List<SearchDto> datas;


    @Override
    public String toString() {
        return "SearchListDto{" +
                "datas=" + datas +
                '}';
    }

    public List<SearchDto> getDatas() {
        return datas;
    }

    public void setDatas(List<SearchDto> datas) {
        this.datas = datas;
    }
}
