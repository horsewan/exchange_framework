package com.zwan.bitrade.model.create;

import com.zwan.bitrade.ability.CreateAbility;
import com.zwan.bitrade.constant.Platform;
import com.zwan.bitrade.entity.AppRevision;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author GS
 * @Title: ${file_name}
 * @Description:
 * @date 2018/4/2416:33
 */
@Data
public class AppRevisionCreate implements CreateAbility<AppRevision> {

    private String remark;

    @NotBlank
    private String version;

    private String downloadUrl;

    @NotNull
    private Platform platform;

    //转化
    @Override
    public AppRevision transformation() {
        AppRevision appRevision = new AppRevision();
        appRevision.setRemark(this.remark);
        appRevision.setVersion(this.version);
        appRevision.setDownloadUrl(this.downloadUrl);
        appRevision.setPlatform(this.platform);
        return appRevision;
    }
}
