package cn.iocoder.yudao.adminserver.modules.pay.dal.mysql.app;

import cn.iocoder.yudao.adminserver.modules.pay.controller.app.vo.PayAppExportReqVO;
import cn.iocoder.yudao.adminserver.modules.pay.controller.app.vo.PayAppPageReqVO;
import cn.iocoder.yudao.coreservice.modules.pay.dal.dataobject.merchant.PayAppDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 支付应用信息 Mapper
 *
 * @author 芋艿
 */
@Mapper
public interface PayAppMapper extends BaseMapperX<PayAppDO> {

    default PageResult<PayAppDO> selectPage(PayAppPageReqVO reqVO, Collection<Long> merchantIds) {
        return selectPage(reqVO, new QueryWrapperX<PayAppDO>()
                .likeIfPresent("name", reqVO.getName())
                .eqIfPresent("status", reqVO.getStatus())
                .eqIfPresent("remark", reqVO.getRemark())
                .eqIfPresent("pay_notify_url", reqVO.getPayNotifyUrl())
                .eqIfPresent("refund_notify_url", reqVO.getRefundNotifyUrl())
                .inIfPresent("merchant_id", merchantIds)
                .betweenIfPresent("create_time", reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .orderByDesc("id"));
    }

    default List<PayAppDO> selectList(PayAppExportReqVO reqVO, Collection<Long> merchantIds) {
        return selectList(new QueryWrapperX<PayAppDO>()
                .likeIfPresent("name", reqVO.getName())
                .eqIfPresent("status", reqVO.getStatus())
                .eqIfPresent("remark", reqVO.getRemark())
                .eqIfPresent("pay_notify_url", reqVO.getPayNotifyUrl())
                .eqIfPresent("refund_notify_url", reqVO.getRefundNotifyUrl())
                .inIfPresent("merchant_id", merchantIds)
                .betweenIfPresent("create_time", reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .orderByDesc("id"));
    }

}
