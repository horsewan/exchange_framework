package com.zwan.bitrade.model.update;

import com.zwan.bitrade.ability.UpdateAbility;
import com.zwan.bitrade.entity.DataDictionary;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author GS
 * @Title: ${file_name}
 * @Description:
 * @date 2018/4/1214:46
 */
@Data
public class DataDictionaryUpdate implements UpdateAbility<DataDictionary> {
    @NotBlank
    private String value;
    private String comment;

    @Override
    public DataDictionary transformation(DataDictionary dataDictionary) {
        dataDictionary.setValue(value);
        dataDictionary.setComment(comment);
        return dataDictionary;
    }
}
