package com.fred.common.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fred.common.timer.entity.Warning;

/**
 * 预警执行类
 * 在该类中查询出已设置的所有预警，并依次执行预警信息
 * @author 杨祥东
 */
public class WarnTask extends TimerTask {

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void run() {
		try {
			this.cleanup();
			List<Warning> warningList = this.retriveAll();
			if(warningList.size()>0){				
				for(Warning warning : warningList){
					this.method102(warning);//2为合同提醒
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 清除已统计过的数据
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void cleanup(){
		String jpql = " delete from WarningContent";
//		JPAUtil.executeUpdate(jpql);
		System.out.println(jpql);
	}

	/**
	 * 101、公司合同到期
	 * @param partyId
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void method101(Warning warning){
		//查询即将到期合同
/*		List<Contract> contracts = contractService.retrieveContractOver(warning.getWarningDay().intValue());
		List<WarningContent> contentList = new ArrayList<WarningContent>();
		List<Long> warnPerIdLs = HyCommonUtil.paraseIds(warning.getLoginIds());
			for(Contract contract:contracts){
				for(Long warPerId : warnPerIdLs){
					WarningContent content = new WarningContent();
					Long contentId = SequenceUtil.genEntitySequenceNo(WarningContent.class);
					content.setContentId(contentId);
					content.setWarningId(warning.getWarningId());
					content.setContentDate(HyCommonUtil.getDate());
					content.setObjectType(warning.getLoginType());
					content.setWarnObject(warPerId);
					content.setContent("提示："+contract.getName()+"合同即将到期.");
					contentList.add(content);
			}
		}
		JPAUtil.create(contentList);*/
	}
	 
	public List<Warning> retriveAll(){
		List<Warning> warnLs = new ArrayList<Warning>();
		Warning warn1 = new Warning(1L,"易木","好好练习别偷懒");
		Warning warn2 = new Warning(2L,"有时","victory need sacrifice!");
		warnLs.add(warn1);
		warnLs.add(warn2);
		return warnLs;
	}
	
	private void method102(Warning warning){
		System.out.println("编号为："+warning.getWarningId()+"的提醒，提醒人为:"+warning.getWarningName()
				+",内容为："+warning.getWarningDescribe());
	}
}
