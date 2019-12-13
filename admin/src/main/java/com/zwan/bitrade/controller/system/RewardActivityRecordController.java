package com.zwan.bitrade.controller.system;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.zwan.bitrade.annotation.AccessLog;
import com.zwan.bitrade.constant.ActivityRewardType;
import com.zwan.bitrade.constant.AdminModule;
import com.zwan.bitrade.constant.PageModel;
import com.zwan.bitrade.entity.RewardActivitySetting;
import com.zwan.bitrade.service.RewardActivitySettingService;
import com.zwan.bitrade.util.MessageResult;

import com.zwan.bitrade.controller.common.BaseAdminController;
import com.zwan.bitrade.entity.QRewardActivitySetting;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/system/reward-activity-record")
public class RewardActivityRecordController extends BaseAdminController {

    @Autowired
    private RewardActivitySettingService rewardActivitySettingService;

    @RequiresPermissions("system:reward-activity-record:merge")
    @PostMapping("merge")
    @AccessLog(module = AdminModule.SYSTEM, operation = "创建修改邀请奖励设置")
    public MessageResult merge(@Valid RewardActivitySetting setting) {
        rewardActivitySettingService.save(setting);
        return MessageResult.success("保存成功");
    }

    /**
     * 查询所有未被禁用的（判断type条件）
     * 默认按照id降序
     *
     * @param type
     * @return
     */
    @RequiresPermissions("system:reward-activity-record:page-query")
    @GetMapping("page-query")
    @AccessLog(module = AdminModule.SYSTEM, operation = "分页查询邀请奖励设置")
    public MessageResult pageQuery(PageModel pageModel,
                                   @RequestParam(value = "type", required = false) ActivityRewardType type) {
        BooleanExpression predicate = null;
        if (type != null) {
            predicate = QRewardActivitySetting.rewardActivitySetting.type.eq(type);
        }
        Page<RewardActivitySetting> all = rewardActivitySettingService.findAll(predicate, pageModel);
        return success(all);
    }

    @RequiresPermissions("system:reward-activity-record:deletes")
    @DeleteMapping("deletes")
    @AccessLog(module = AdminModule.SYSTEM, operation = "批量删除邀请奖励设置")
    public MessageResult deletes(Long[] ids) {
        Assert.notNull(ids, "ids不能为null");
        rewardActivitySettingService.deletes(ids);
        return MessageResult.success("删除成功");
    }
}
