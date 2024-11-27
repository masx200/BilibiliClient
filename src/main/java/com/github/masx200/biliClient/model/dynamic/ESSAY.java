package com.github.masx200.biliClient.model.dynamic;

import com.github.masx200.biliClient.model.BaseModel;
import com.github.masx200.biliClient.utils.TransDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * Auto-generated: 2024-11-27 13:23:3
 *
 * @author json.cn (i@json.cn)
 * @website <a href="http://www.json.cn/">...</a>
 */
@Setter
@Getter
@Data
public class ESSAY implements BaseModel {

    private long ctime;
    private long id;
    private String title;
    private String summary;
    private Author author;
    private List<String> image_urls;
    private long publish_time;
    //    private long ctime;
    private int mtime;
    private String stats;
    private List<String> origin_image_urls;

    @Override
    public Date createTime() {
        return TransDate.timestampToDate(this.ctime);
    }

}

